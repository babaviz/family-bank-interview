package simple.rest.server.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.rest.server.models.Student;
import simple.rest.server.repositories.StudentRepository;
import simple.rest.server.services.StudentService;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student findByRegistration(String registrationNumber) {
        return repository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public Student findById(long id) {
        Optional<Student> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public boolean validateByRegistrationNumber(String registrationNumber) {
        Student student = findByRegistration(registrationNumber);
        return student!=null;
    }
}
