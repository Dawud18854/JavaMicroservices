package at.spengergasse.assignmentservice.service;

import at.spengergasse.assignmentservice.domain.Assignment;
import at.spengergasse.assignmentservice.persistance.AssignmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment saveAssignment(Assignment assignment) {
        log.info("Inside saveDepartment method of DepartmentService");
        return assignmentRepository.save(assignment);
    }

    public Assignment findAssignmentById(Long assignment) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return assignmentRepository.getFindByAssignmentId(assignment);
    }
}
