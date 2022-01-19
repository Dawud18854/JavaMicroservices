package at.spengergasse.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
