package simple.rest.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.rest.server.models.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByRegistrationNumber(String regNo);
}
