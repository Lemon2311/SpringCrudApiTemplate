package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{


    @Autowired
    private UserRepository userRepository;

    //CRUD->SQl->HTTPRequest
    //create/insert/post
    public void addUser(User user){
        userRepository.save(user);
    }

    //read/select/get
    public List<User> getUsers(){

        return userRepository.findAll();
    }

    public Optional<User> getUser(long id){
        Optional<User> user=userRepository.findById(id);
        return user;
    }

    //update/update/put
    public void updateUser(User user) {

        Optional<User> theUser = userRepository.findById(user.getId());

        theUser.map(user0 -> {
            user0.setName(user.getName());
            user0.setEmail(user.getEmail());
            return null;
        });
    }

    //delete/delete/delete
    public void deleteUser(User user){
        userRepository.delete(user);
    }



}
