package at.spengergasse.userservice.service;
import at.spengergasse.userservice.domain.Exceptions.ServiceException;
import at.spengergasse.userservice.service.DTO.UserDto;
import at.spengergasse.userservice.service.VO.*;
import at.spengergasse.userservice.domain.User;
import at.spengergasse.userservice.persistance.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(UserDto::fromUser)
                .collect(Collectors.toList());
    }

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public UserDto findUserById(Long id){
        log.info("Inside findUserById of UserService");
        return userRepository.findById(id)
                .map(UserDto::fromUser)
                .orElseThrow(()->
                        new ServiceException("User with id "+id+"does not exist"));
    }

    public void partialUpdate(Long id, String firstName, String lastName){
        userRepository.partialUpdate(id,firstName,lastName);
    }

    public void deleteUser(Long id) throws ServiceException {
        var user = findUserById(id);
        userRepository.deleteById(id);
    }

    public UserDepartmentVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        UserDepartmentVO vo = new UserDepartmentVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                        Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
    public UserAssignmentVO getUserWithAssignment(Long userId) {
        log.info("Inside getUserWithAssignment of UserService");
        UserAssignmentVO vo = new UserAssignmentVO();
        User user = userRepository.findByUserId(userId);
        Assignment assignment =
                restTemplate.getForObject("http://ASSIGNMENT-SERVICE/assignments/"+user.getAssignmentId(),
                        Assignment.class);
        vo.setUser(user);
        vo.setAssignment(assignment);

        return vo;
    }
    public UserDepartmentAssignmentVO getUserWithAssignmentAndDepartment(Long userId) {
        log.info("Inside UserDepartmentAssignmentVO of UserService");
        UserDepartmentAssignmentVO vo = new UserDepartmentAssignmentVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                        Department.class);
        Assignment assignment =
                restTemplate.getForObject("http://ASSIGNMENT-SERVICE/assignments/"+user.getAssignmentId(),
                        Assignment.class);
        vo.setUser(user);
        vo.setAssignment(assignment);
        vo.setDepartment(department);

        return vo;
    }





}
