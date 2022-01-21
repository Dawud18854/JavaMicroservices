package at.spengergasse.assignmentservice.persistance;

import at.spengergasse.assignmentservice.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    Assignment getFindByAssignmentId(Long assignmentId);

}
