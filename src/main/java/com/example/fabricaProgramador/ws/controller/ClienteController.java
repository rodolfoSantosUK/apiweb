package com.example.fabricaProgramador.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fabricaProgramador.model.Cliente;

@RestController // Capaz de responder requisições http
public class ClienteController {

	Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

	public ClienteController() {
		clientes.put(1, Cliente.create().withIdCliente(1).withNome("Denis"));
		clientes.put(2, Cliente.create().withIdCliente(2).withNome("Marcio"));
		clientes.put(3, Cliente.create().withIdCliente(3).withNome("Ronaldo"));
		clientes.put(4, Cliente.create().withIdCliente(4).withNome("Fabricio"));
		clientes.put(5, Cliente.create().withIdCliente(5).withNome("Arnaldo"));
	}

	Integer proximoId = 6;

	private Cliente cadastrar(Cliente cliente) {
		cliente.setId(proximoId);
		proximoId++;
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
		Collection<Cliente> clientesBuscados = clientes.values();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cliente",  
			consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = cadastrar(cliente);
		clientes.put(clienteCadastrado.getId(), clienteCadastrado);
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{idCliente}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer idCliente) {

		Cliente clienteEncontrado = buscarPorId(idCliente);
		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		excluir(clienteEncontrado);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		 alterar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}

	private void excluir(Cliente cliente) {
		clientes.remove(cliente.getId());
	}

	private Cliente alterar(Cliente cliente) {
		return clientes.put(cliente.getId(), cliente);
	}

	private Cliente buscarPorId(Integer idCliente) {
		return clientes.get(idCliente);
	}

}
