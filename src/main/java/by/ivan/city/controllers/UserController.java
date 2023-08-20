package by.ivan.city.controllers;

import by.ivan.city.dto.converters.UserDtoToEntityConverter;
import by.ivan.city.dto.core.UserDTO;
import by.ivan.city.models.User;
import by.ivan.city.models.enums.Role;
import by.ivan.city.models.enums.Status;
import by.ivan.city.services.UserService;
import by.ivan.city.util.PersonNotCreatedException;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserDtoToEntityConverter userDtoToEntityConverter;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper,
                          UserDtoToEntityConverter userDtoToEntityConverter) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userDtoToEntityConverter = userDtoToEntityConverter;
    }

    @GetMapping("/user")
    public User getUser(long id) {
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public List<User> getUser() {
        return userService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Valid UserDTO userDTO
                                                /* BindingResult bindingResult*/ ) {
       /* if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new PersonNotCreatedException(errorMsg.toString());
        } */
        userService.saveUser(userDtoToEntityConverter.convert(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
        /*return ResponseEntity.ok(HttpStatus.OK); */
    }

    /*
    @ExceptionHandler
    ResponseEntity<PersonErrorResponse> handleExceprion (PersonNotCreatedException e) {
        PersonErrorResponse response = new PersoneErrorResponse();
        e.getMessage();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST)
    } */


}

