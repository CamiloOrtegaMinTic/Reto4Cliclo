package com.example.ciclo3.repository.crudRepository;

import com.example.ciclo3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message,Integer>{
}
