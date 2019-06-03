package com.example.fabricaProgramador.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fabricaProgramador.model.Cliente;
import com.example.fabricaProgramador.ws.service.ClienteService;

@RestController // Capaz de responder requisições http
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", 
			      produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
		Collection<Cliente> clientesBuscados = clienteService.criarClientes();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cliente",  
			consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		clienteService.getClientes().put(clienteCadastrado.getId(), clienteCadastrado);
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{idCliente}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer idCliente) {

		Cliente clienteEncontrado = clienteService.buscarPorId(idCliente).get();
		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clienteEncontrado);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		clienteService.alterar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}


}
