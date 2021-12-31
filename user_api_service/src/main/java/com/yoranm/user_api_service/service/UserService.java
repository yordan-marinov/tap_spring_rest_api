package com.yoranm.user_api_service.service;

import com.yoranm.user_api_service.constants.Constants;
import com.yoranm.user_api_service.dto.UserDTO;
import com.yoranm.user_api_service.dto.AddressDTO;
import com.yoranm.user_api_service.dto.TransactionDTO;
import com.yoranm.user_api_service.model.Address;
import com.yoranm.user_api_service.model.Transaction;
import com.yoranm.user_api_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private List<AddressDTO> getAddresses(UUID userId) {
        ResponseEntity<AddressDTO[]> response = restTemplate.getForEntity(
                Constants.BASE_USER_ADDRESS_URI + userId + "/addresses",
                AddressDTO[].class
        );
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    private List<TransactionDTO> getTransactions(UUID userId) {
        ResponseEntity<TransactionDTO[]> response = restTemplate.getForEntity(
                Constants.BASE_USER_TRANSACTION_URI + userId + "/transactions",
                TransactionDTO[].class
        );
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    private void addAddress(AddressDTO addressDto, UUID userId) {
        Address address = createAddressModel(addressDto, userId);
        restTemplate.postForObject(
                Constants.BASE_POST_ADDRESS_URI,
                address,
                Address.class
        );
    }

    private Address createAddressModel(AddressDTO addressDto, UUID userId) {
        return new Address(
                userId,
                addressDto.getStreetName(),
                addressDto.getHouseNumber(),
                addressDto.getCity());
    }

    private void addTransaction(TransactionDTO transactionDto, UUID userId) {
        Transaction transaction = createTransactionModel (transactionDto, userId);
        restTemplate.postForObject(
                Constants.BASE_POST_ADDRESS_URI,
                transaction,
                ResponseEntity.class
        );
    }

    private Transaction createTransactionModel(TransactionDTO transactionDto, UUID userId) {
        return new Transaction(
                userId,
                transactionDto.getAmount()
        );
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUuid());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        List<AddressDTO> addressList = getAddresses(user.getUuid());
        userDTO.setAddresses(addressList);
        userDTO.setTransactions(getTransactions(user.getUuid()));

        return userDTO;
    }

    public UserDTO createUser(User user, AddressDTO address, TransactionDTO transaction) {
        addAddress(address, user.getUuid());
        addTransaction(transaction, user.getUuid());

        return convertToUserDTO(user);
    }
}