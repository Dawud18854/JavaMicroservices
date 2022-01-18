package at.spengergasse.userservice.service.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    private Long assignmentId;
    private String assignmentName;
    private LocalDate assignmentDue;
}
