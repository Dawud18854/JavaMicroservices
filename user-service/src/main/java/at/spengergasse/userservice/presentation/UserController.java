package at.spengergasse.userservice.presentation;
import at.spengergasse.userservice.service.DTO.UserDto;
import at.spengergasse.userservice.service.VO.UserAssignmentVO;
import at.spengergasse.userservice.service.VO.UserDepartmentAssignmentVO;
import at.spengergasse.userservice.service.VO.UserDepartmentVO;
import at.spengergasse.userservice.domain.User;
import at.spengergasse.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @PutMapping("/{id}/{firstName}/{lastName}")
    public void updateSongField(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName){
        userService.partialUpdate(id,firstName,lastName);
    }

    @DeleteMapping({"/{id}"})
    public void deleteMusic(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/getAll")
    public List<UserDto> getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("/withAssignmentDepartment/{id}")
    public UserDepartmentAssignmentVO getUserWithDepartmentAndAssignment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithAssignment of UserController");
        return userService.getUserWithAssignmentAndDepartment(userId);
    }

    @GetMapping("/withAssignment/{id}")
    public UserAssignmentVO getUserWithAssignment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithAssignment of UserController");
        return userService.getUserWithAssignment(userId);
    }

    @GetMapping("/withDepartment/{id}")
    public UserDepartmentVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

}

