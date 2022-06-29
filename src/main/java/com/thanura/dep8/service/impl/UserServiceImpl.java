package com.thanura.dep8.service.impl;

import com.thanura.dep8.dto.UserDTO;
import com.thanura.dep8.entity.User;
import com.thanura.dep8.repositary.UserRepository;
import com.thanura.dep8.service.UserService;
import com.thanura.dep8.service.exception.DuplicateEmailException;
import com.thanura.dep8.service.exception.NotFoundException;
import com.thanura.dep8.service.util.EntityDTOConversion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
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
        //find out whether it is existed user that going to be saved
        if(userRepository.existsUserByEmail(userDTO.getEmail())) throw new DuplicateEmailException("User already exists");
        //if not
        userDTO.setId(UUID.randomUUID().toString());
        //save and return the result
        return null;


    }

    @Override
    public void updateUser(UserDTO userDTO) throws NotFoundException {
     Optional<User> optUser = userRepository.findUserById(userDTO.getId());
     if(!optUser.isPresent()) throw new NotFoundException("No user found");
     optUser.get().setFullName(userDTO.getFullName());
     optUser.get().setPassword(userDTO.getPassword());

    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
       return userRepository.findUserById(userId).map(transform::getUserDTO)
                .orElseThrow(()->new NotFoundException("Invalid User"));
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {
         if(!userRepository.existsUserById(userId))throw new NotFoundException("Invalid UserId");

    }
}
