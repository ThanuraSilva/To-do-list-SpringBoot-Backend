package com.thanura.dep8.service.impl;

import com.thanura.dep8.dto.UserDTO;
import com.thanura.dep8.repositary.UserRepository;
import com.thanura.dep8.service.UserService;
import com.thanura.dep8.service.exception.DuplicateEmailException;
import com.thanura.dep8.service.exception.NotFoundException;
import com.thanura.dep8.service.util.EntityDTOConversion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final EntityDTOConversion transform;

    public UserServiceImpl(UserRepository userRepository, EntityDTOConversion transform) {
        this.userRepository = userRepository;
        this.transform = transform;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws DuplicateEmailException {
        //find out whether it is there existed user going to be saved
        if(userRepository.existsUserByEmail(userDTO.getEmail())) throw new DuplicateEmailException("User already exists");
        //if not
        userDTO.setId(UUID.randomUUID().toString());
        //save and return the result
        return null;


    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) throws NotFoundException {
        return null;
    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {

    }
}
