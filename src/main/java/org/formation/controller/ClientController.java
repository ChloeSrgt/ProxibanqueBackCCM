package org.formation.controller;

import java.util.List;

import org.formation.dto.AccountsDTO;
import org.formation.model.Client;
import org.formation.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clients")
public class ClientController {
    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);
    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    // GET
    @GetMapping
    List<Client> getAllClients() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable long id) {
        return service.getClientById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/accounts")
    public AccountsDTO getAccounts(@PathVariable Long id) {
        return service.getAccountsByClientId(id);
    }
    
    
    // DELETE
    @DeleteMapping("{id}")
    void deleteClient(@PathVariable long id) {
        service.deleteById(id);
    }

    // POST
    @PostMapping
    Client postClient(@RequestBody Client client) {
        LOG.info("Received client: {}", client);
        return service.save(client);
    }
    
    //PUT
    
    @PutMapping("{id}")
    public ResponseEntity<Client> putClient(@PathVariable long id, @RequestBody Client client){
    	LOG.info("Edited client : {} ", client);
    	service.update(client);
    	return null;
    }
}
