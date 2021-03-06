package at.spengergasse.cloud.gateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackMethodController {


    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service seems not to be working,⁄n please try again later" ;
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod(){
        return "Department Service seems not to be working,⁄n please try again later" ;
    }

    @GetMapping("/assignmentServiceFallBack")
    public String assignmentServiceFallBackMethod(){
        return "Department Service seems not to be working,⁄n please try again later" ;
    }

}
