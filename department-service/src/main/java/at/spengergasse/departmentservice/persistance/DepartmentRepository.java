package at.spengergasse.departmentservice.persistance;
import at.spengergasse.departmentservice.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getFindByDepartmentId(Long departmentId);
}
