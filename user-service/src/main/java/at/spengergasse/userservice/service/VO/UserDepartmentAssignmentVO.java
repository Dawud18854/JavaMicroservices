package at.spengergasse.userservice.service.VO;

import at.spengergasse.userservice.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentAssignmentVO {
    private User user;
    private Department department;
    private Assignment assignment;
}
