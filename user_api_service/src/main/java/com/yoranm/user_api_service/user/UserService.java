package com.yoranm.user_api_service.user;

import com.yoranm.user_api_service.constants.Constants;
import com.yoranm.user_api_service.dto.UserDTO;
import com.yoranm.user_api_service.models.IdModelUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private final UserRepository userRepository;
    private final WebClient webClient;
    private final RestTemplate restTemplate;


    @Autowired
    public UserService(UserRepository userRepository, WebClient webClient, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }


    public IdModelUser idModel(){
        System.out.println("Object" + restTemplate.getForObject(Constants.GENERATE_ID_URI, IdModelUser.class));
        System.out.println("Entity" + restTemplate.getForEntity(Constants.GENERATE_ID_URI, IdModelUser.class));


        return webClient.get()
                .uri(Constants.GENERATE_ID_URI)
                .retrieve()
                .bodyToMono(IdModelUser.class)
                .block();
    }

    public UserDTO convertToUserDTO(UserModel userModel){
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(userModel.getUserId());
        userDTO.setFirstName(userModel.getFirstName());
        userDTO.setLastName(userModel.getLastName());
        userDTO.setAddresses(userModel.getAddresses());
        userDTO.setTransactions(userModel.getTransactions());

        return userDTO;
    }


    @RequestMapping(value = Constants.GENERATE_ID_URI)
    public void getIdFromApi(){

    }

    public IdModelUser createUser() {
        System.out.println(idModel());

        return null;
    }

    public List<UserModel> getAllUsers() {
        return (List<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getById(IdModelUser id) {
        return userRepository.findById(id.getUuid());
    }

    public UserModel updateById(IdModelUser id, UserModel newUser) {
        return userRepository.findById(id.getUuid())
                .map(userModel -> {
                    userModel.setFirstName(newUser.getFirstName());
                    userModel.setLastName(newUser.getLastName());
                    return userRepository.save(userModel);
                })
                .orElseGet(() -> {
                    newUser.setUserId(id.getUuid());
                    return userRepository.save(newUser);
                });
    }

    public void deleteById(IdModelUser id) {
        userRepository.deleteById(id.getUuid());
    }
}
