package com.example.ciclo3.controller;


import com.example.ciclo3.entities.Message;
import com.example.ciclo3.entities.Client;
import com.example.ciclo3.entities.Message;
import com.example.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll() { return messageService.getAll();}

    @GetMapping("/{id}")
    public Optional<Message> getTool(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save  (@RequestBody Message a) {return messageService.save(a);}


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update (@RequestBody Message a){return messageService.update(a);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }


}
