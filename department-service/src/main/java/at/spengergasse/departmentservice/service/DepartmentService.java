package at.spengergasse.departmentservice.service;

import at.spengergasse.departmentservice.domain.Department;
import at.spengergasse.departmentservice.persistance.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }
}
