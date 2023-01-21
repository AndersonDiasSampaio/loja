package br.com.lojalegal.store.system.model;

public class Pessoa {  
	
 	private String nome;
	private String cpf;
	private String endereco;
	public boolean cpfFormatado;
	 
	
	public Pessoa(String nome, String cpf, String endereco) {
		super();
		this.nome = nome;
		 this.cpf = cpf; 
		this.endereco = endereco;
	}


	public Pessoa() {
		this.nome="Nome nao informado";
		this.cpf="CPF nao informado";
		this.endereco="endereco nao informado";
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		String cpfFormatado = cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "." +  cpf.substring(9);
		  
		return cpfFormatado;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
 	 
}
