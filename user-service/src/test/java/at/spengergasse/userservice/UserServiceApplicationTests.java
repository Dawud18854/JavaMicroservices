package at.spengergasse.userservice;

import at.spengergasse.userservice.domain.User;
import at.spengergasse.userservice.persistance.UserRepository;
import org.h2.engine.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Test @Order(1)
    public void assertInsertUser(){
        String firstName = "TestInsert";
        user = userRepository.save(new User(2L,firstName,"TestLastName","test@email.at",1L,1L));
        Assertions.assertTrue(user.getFirstName().equals(firstName));
    }

}
