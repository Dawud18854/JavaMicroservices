package at.spengergasse.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long Userid;

    private String departmentName;
    private Long departmentId;




}
