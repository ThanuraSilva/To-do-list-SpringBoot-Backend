package com.thanura.dep8.service;

import com.thanura.dep8.dto.UserDTO;
import com.thanura.dep8.service.exception.DuplicateEmailException;
import com.thanura.dep8.service.exception.NotFoundException;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO) throws DuplicateEmailException;

    UserDTO updateUser(UserDTO userDTO) throws NotFoundException;

    UserDTO getUserInfo(String userId) throws NotFoundException;

    void deleteUser(String userId) throws NotFoundException;
}
