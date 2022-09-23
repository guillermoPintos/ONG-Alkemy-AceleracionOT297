package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.RoleEntity;
import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.models.request.UserRegisterRequest;
import com.alkemy.ong.models.response.UserRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMapper {
    @Autowired
    private PasswordEncoder encoder;

    public UserRegisterResponse userEntity2UserResponse(UserEntity userEntity, String token) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(userEntity.getIdUser());
        userRegisterResponse.setFirstName(userEntity.getFirstName());
        userRegisterResponse.setLastName(userEntity.getLastName());
        userRegisterResponse.setEmail(userEntity.getEmail());
        userRegisterResponse.setPassword(userEntity.getPassword());
        userRegisterResponse.setToken(token);
        return userRegisterResponse;
    }

    public UserEntity userRequest2UserEntity(UserRegisterRequest userRegisterRequest, Set<RoleEntity> role) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRegisterRequest.getFirstName());
        userEntity.setLastName(userRegisterRequest.getLastName());
        userEntity.setEmail(userRegisterRequest.getEmail());
        userEntity.setPassword(encoder.encode(userRegisterRequest.getPassword()));
        userEntity.setRoleEntityId(role);
        return userEntity;
    }
}
