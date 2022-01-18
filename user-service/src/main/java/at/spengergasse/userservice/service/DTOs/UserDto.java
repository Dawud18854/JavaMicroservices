package at.spengergasse.userservice.service.DTOs;

import at.spengergasse.userservice.domain.User;

public record UserDto(Long id, String firstName, String lastName, String email) {

    public static UserDto fromUser(User user){
        return new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(), user.getEmail());
    }

    public User toUser(Long depId, Long aId){
        return  User.builder()
                .userId(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .departmentId(depId)
                .assignmentId(aId)
                .build();
    }

}
