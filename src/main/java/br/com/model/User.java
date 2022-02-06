package br.com.model;
public class User {
	private Integer id;
	private String nome;
	private String email;
	private String pais;
	
	
	public User (String nome, String email, String pais) {
		this.nome = nome;
		this.email = email;
		this.pais = pais;
	}
	
	public User (Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		//return "(" + this.id + ", " + this.name + ")";
		return this.id + " : " + this.nome + " : " + this.email + this.pais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
