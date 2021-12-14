package com.yoranm.user_api_service.user;

import com.yoranm.user_api_service.models.IdModelUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/api/resources/user")
    public IdModelUser createUser(){
        return userService.createUser();
    }

    @GetMapping("/api/resources/users")
    public List<UserModel> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/api/resources/user/{id}")
    public UserModel getUserById(IdModelUser id) throws ChangeSetPersister.NotFoundException {
        return userService.getById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @PutMapping("/api/resources/user/{id}")
    public UserModel updateUser(@PathVariable IdModelUser id, @RequestBody UserModel newUser){
        return userService.updateById(id, newUser);
    }

    @DeleteMapping("/api/resources/user/{id}")
    public void  deleteUser(IdModelUser id){
        userService.deleteById(id);
    }

    @GetMapping("/api/resources/model")
    public void getIdModel(){
        System.out.println(userService.idModel());
    }
}
