package simple.rest.server.services;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
