package at.spengergasse.assignmentservice.presentation;

import at.spengergasse.assignmentservice.domain.Assignment;
import at.spengergasse.assignmentservice.service.AssignmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignments")
@Slf4j
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;


    @PostMapping("/")
    public Assignment saveAssignment(@RequestBody Assignment assignment){
        log.info("Inside saveAssignment method of AssignmentController");
        return assignmentService.saveAssignment(assignment);
    }

    @GetMapping("/{id}")
    public Assignment findAssignmentById(@PathVariable("id") Long assignmentId){
        log.info("Inside findDepartmentById method of DepartmentController");
        return assignmentService.findAssignmentById(assignmentId);
    }
}
