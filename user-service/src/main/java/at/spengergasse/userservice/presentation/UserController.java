package at.spengergasse.userservice.presentation;
import at.spengergasse.userservice.domain.User;
import at.spengergasse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return UserService.findAll();
    }

    @GetMapping(value = "/{Username}", produces = APPLICATION_JSON_VALUE)
    public User findOne(@PathVariable String Username){return UserService.findOneByName(Username);}

    @DeleteMapping("/{Username}")
    public void deleteOneUser(@PathVariable String Username){
        UserService.deleteUser(Username);
    }

    @PostMapping
    public UserDto insertUser(@RequestBody UserDto User){
        return UserService.insertUser(User);
}
