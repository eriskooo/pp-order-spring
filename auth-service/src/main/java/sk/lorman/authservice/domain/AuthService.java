package sk.lorman.authservice.domain;

public interface AuthService {

    /**
     * Issue token, or throw an exception when invalid autentication.
     *
     * @param user
     * @param pwd
     * @return
     */
    String issueToken(String user, String pwd);
}
