package com.thanura.dep8.api;

import com.thanura.dep8.dto.UserDTO;
import com.thanura.dep8.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Validated
@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public UserDTO registerUser(@RequestBody @Valid UserDTO user, Errors errors){
      if(errors.hasFieldErrors()){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.getFieldErrors()
                  .get(0).getDefaultMessage());
      }
      return userService.registerUser(user);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{userId}",consumes = "application/json")
    public void updateUser(@PathVariable String userId,@RequestBody UserDTO user, Errors errors){
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.getFieldErrors()
                    .get(0).getDefaultMessage());
        }
        user.setId(userId);
        userService.updateUser(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{/userId:[A-Fa-f0-9\\-]{36}}")
    public void deleteUser(@PathVariable String userId){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Deleted");
    }
    @GetMapping(path = "{/userId:[A-Fa-f0-9\\-]{36}}",produces = "application/json")
    public UserDTO getUserInfo(@PathVariable String userId){
        return userService.getUserInfo(userId);
    }





}
