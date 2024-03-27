package br.com.vainaweb.escolat3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;

@Service// Classe de serviço gerenciada pelo Spring
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> encontrarTodos() {

		// Método da Repository que faz a query -> SELECT * FROM nome_da_tabela
		return repository.findAll();
	}

	public String cadastrar(DadosColaborador dados) {
		var colaboradorExistente = repository.findByCpf(dados.cpf());
		
		if (dados.cpf() == colaboradorExistente.get().getCpf()) {
			return "Colaborador ja existente";
		} else {
			var colaborador = new ColaboradorModel(dados);
			repository.save(colaborador);
			return "Cadastro Feito";
		}
	}
}