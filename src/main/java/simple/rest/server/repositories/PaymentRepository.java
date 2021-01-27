package simple.rest.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.rest.server.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findByReference(String reference);
}
