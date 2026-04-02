package com.landgraf.workshopmongo.resources;

import com.landgraf.workshopmongo.domain.User;
import com.landgraf.workshopmongo.repository.UserRepository;
import com.landgraf.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        System.out.println("Tamanho da lista: " + list.size());
        return ResponseEntity.ok().body(list);
    }

}
