package br.com.vainaweb.escolat3.model;


import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotação que diz que essa classe é uma entidade
@Entity
@Table(name = "tb_colaboradores" )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// será a classe responsavel pela entidade
public class ColaboradorModel {
	


	@Id //Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true) //Formata as colunas
	@Email //Valida isso como um email
	private String email;
	
	@Column(unique = true)
	@CPF //Valida como um CPF
	private String cpf;
	private Cargo cargo;
	
	@Embedded //Incorpora a classe na entidade (OS ATRIBUTOS DESSA CLASSA SERÃO PARTE DA MINHA TABELA)
	private Endereco endereco;
	
	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public ColaboradorModel(DadosColaborador dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.cpf = dados.cpf();
		this.cargo = dados.cargo();
	}
	
}