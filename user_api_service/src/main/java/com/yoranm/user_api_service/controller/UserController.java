package com.yoranm.user_api_service.controller;

import com.yoranm.user_api_service.dto.UserDTO;
import com.yoranm.user_api_service.dto.AddressDTO;
import com.yoranm.user_api_service.dto.TransactionDTO;
import com.yoranm.user_api_service.model.User;
import com.yoranm.user_api_service.service.UserService;
import com.yoranm.user_api_service.utils.CreateUserRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/api/resources/user")
    public UserDTO createNewUser(@RequestBody CreateUserRequestBody createUserRequestBody){
        User user = createUserRequestBody.getUser();
        AddressDTO addressDTO = createUserRequestBody.getAddress();
        TransactionDTO transactionDTO = createUserRequestBody.getTransaction();

        return userService.createUser(user, addressDTO, transactionDTO);
    }

//    @GetMapping("/api/resources/user/{id}")
//    public User getUserById(String id) throws ChangeSetPersister.NotFoundException {
//        return userService.getById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
//    }
//
//    @PutMapping("/api/resources/user/{id}")
//    public User updateUser(@PathVariable IdModelUser id, @RequestBody User newUser){
//        return userService.updateById(id, newUser);
//    }
//
//    @DeleteMapping("/api/resources/user/{id}")
//    public void  deleteUser(IdModelUser id){
//        userService.deleteById(id);
//    }
//
//    @GetMapping("/api/resources/model")
//    public void getIdModel(){
//        System.out.println(userService.idModel());
//    }
}
