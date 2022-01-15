package at.spengergasse.departmentservice.presentation;
import at.spengergasse.departmentservice.domain.Department;
import at.spengergasse.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService deparmentService;


    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return deparmentService.saveDepartment(department);
    }

}