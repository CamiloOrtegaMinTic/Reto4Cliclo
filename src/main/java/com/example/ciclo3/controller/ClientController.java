package com.example.ciclo3.controller;


import com.example.ciclo3.entities.Client;
import com.example.ciclo3.entities.Tool;
import com.example.ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll() { return clientService.getAll();}

    @GetMapping("/{id}")
    public Optional<Client> getTool(@PathVariable("id") int id){
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save  (@RequestBody Client a) {return clientService.save(a);}

}
