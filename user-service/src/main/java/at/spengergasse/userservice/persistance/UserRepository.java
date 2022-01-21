package at.spengergasse.userservice.persistance;
import at.spengergasse.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    //void partialUpdate(Long id, String firstName, String lastName);
}
