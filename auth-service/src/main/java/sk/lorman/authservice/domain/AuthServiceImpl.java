package sk.lorman.authservice.domain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import sk.lorman.authservice.infrastructure.exception.AuthException;
import sk.lorman.authservice.infrastructure.properties.ConfigProperties;
import sk.lorman.authservice.infrastructure.security.SecurityConstants;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private ConfigProperties properties;

    public AuthServiceImpl(ConfigProperties properties) {
        this.properties = properties;
    }

    @Override
    public String issueToken(String user, String password) {
        validate(user, password);
        return getTokenForUser(user);
    }

    private String getTokenForUser(String user) {
        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(properties.getSigningKey().getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .setSubject(user)
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("role", "user")
                .compact();
    }

    private void validate(String user, String pwd) {
        if (!user.equals(pwd)) {
            throw new AuthException("user and pwd does not match");
        }
    }
}
