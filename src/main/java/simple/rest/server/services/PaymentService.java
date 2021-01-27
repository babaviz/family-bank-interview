package simple.rest.server.services;

import simple.rest.server.models.Payment;

import java.util.List;

public interface PaymentService {
    Payment save(Payment payment);
    List<Payment> findAll();
    void delete(long id);
    Payment findByReference(String reference);
    void notifyGuardian(Payment payment);
}
