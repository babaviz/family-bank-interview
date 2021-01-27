package simple.rest.server.services;


import simple.rest.server.models.Student;


public interface StudentService {
    Student findByRegistration(String registrationNumber);
    Student findById(long id);
    boolean validateByRegistrationNumber(String registrationNumber);
}
