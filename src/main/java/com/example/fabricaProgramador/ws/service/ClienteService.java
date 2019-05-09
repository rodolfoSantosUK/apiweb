package com.example.fabricaProgramador.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.fabricaProgramador.model.Cliente;

@Service
public class ClienteService {

	private Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

	Integer proximoId = 6;
	
	public Map<Integer, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<Integer, Cliente> clientes) {
		this.clientes = clientes;
	}

	public Collection<Cliente>  criarClientes () {
		clientes.put(1, Cliente.create().withIdCliente(1).withNome("Denis"));
		clientes.put(2, Cliente.create().withIdCliente(2).withNome("Marcio"));
		clientes.put(3, Cliente.create().withIdCliente(3).withNome("Ronaldo"));
		clientes.put(4, Cliente.create().withIdCliente(4).withNome("Fabricio"));
		clientes.put(5, Cliente.create().withIdCliente(5).withNome("Arnaldo"));
		return clientes.values();
	}

	public Cliente cadastrar(Cliente cliente) {
		cliente.setId(proximoId);
		proximoId++;
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}
	
	public void excluir(Cliente cliente) {
		clientes.remove(cliente.getId());
	}

	public Cliente alterar(Cliente cliente) {
		return clientes.put(cliente.getId(), cliente);
	}

	public Cliente buscarPorId(Integer idCliente) {
		return clientes.get(idCliente);
	}


	
	
}
