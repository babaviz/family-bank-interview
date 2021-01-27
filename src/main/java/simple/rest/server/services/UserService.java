package simple.rest.server.services;


import simple.rest.server.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findByUsername(String username);
}
