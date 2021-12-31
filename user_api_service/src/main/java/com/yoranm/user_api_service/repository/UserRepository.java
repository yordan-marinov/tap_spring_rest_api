package com.yoranm.user_api_service.repository;

import com.yoranm.user_api_service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
