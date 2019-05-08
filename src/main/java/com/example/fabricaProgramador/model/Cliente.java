package com.example.fabricaProgramador.model;

import java.util.StringTokenizer;

public class Cliente {

	
	private Integer id;
	
	private String nome;

	public static Cliente create() {
		return new Cliente();
	}
	
	public Cliente withIdCliente(Integer idCliente) {
        setId(idCliente);
        return this;
    }
	
	public Cliente withNome(String  nome) {
        setNome(nome);
        return this;
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	
	
	
}
