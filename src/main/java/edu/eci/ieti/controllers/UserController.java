package edu.eci.ieti.controllers;

import edu.eci.ieti.models.User;
import edu.eci.ieti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{userId}")
    public User getById(@PathVariable String userId) {        
        return userService.getById(userId);
    }

    @GetMapping("/create")
    public User create(@RequestBody(required = false) User user ) {
        System.out.println("USER EN CREATE: "+user);
        return userService.create(user);
    }

    @GetMapping("/update")
    public User update(@RequestBody(required = false) User user){
        return userService.update(user);
    }

    @GetMapping("/delete/{id}")
    public void remove(@PathVariable String id){        
        userService.remove(id);
    }
}



