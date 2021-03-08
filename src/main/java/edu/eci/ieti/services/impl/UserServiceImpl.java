package edu.eci.ieti.services.impl;

import java.util.ArrayList;
import java.util.List;

import edu.eci.ieti.models.User;
import edu.eci.ieti.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    List<User> usuarios = new ArrayList<User>();
    boolean band = false;

    @Override
    public List<User> getAll() {        
        if(!band)
            generateData();
        return usuarios;
    }

    private void generateData() {
        band = true;
        String[] names = { "karen", "Lizeth", "Michael", "Cristian", "Marcela" };
        for (int i = 0; i < 5; i++) {
            String id = i + 1 + "";
            usuarios.add(new User(id, names[i], names[i] + "@mail.com", "hola123"));
        }
    }

    @Override
    public User getById(String userId) {
        User userFind = new User();
        for (User usuario : usuarios) {
            if (usuario.getId().equals(userId))
                userFind = usuario;
        }
        System.out.println("usuario encontrado: " + userFind);
        return userFind;
    }

    @Override
    public User create(User user) {
        if (user == null) {
            user = new User("21", "Eduard", "edkillah@mail.com", "654321");
        }
        boolean band=false;
        for(User usuario: usuarios){
            if(usuario.getId().equals(user.getId())){
                band=true;

            }
        }
        if(!band){
            usuarios.add(user);
        }        
        return user;
    }

    @Override
    public User update(User user) {
        User userToUpdate = null;
        if (user != null) {
            for(User usuario: usuarios){
                if(usuario.getId().equals(user.getId())){
                    userToUpdate = usuario;
                }
            }
            usuarios.remove(userToUpdate);
            usuarios.add(user);
        }
    
        return user;
    }

    @Override
    public void remove(String userId) {
        User userToDelete = null;
        for (User user : usuarios) {
            if (user.getId().equals(userId)) {
                userToDelete = user;
            }
        }        
        if (userToDelete != null) {
            usuarios.remove(userToDelete);
        }
    }
}
