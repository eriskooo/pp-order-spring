package sk.lorman.authservice.domain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import sk.lorman.authservice.infrastructure.exception.AuthException;
import sk.lorman.authservice.infrastructure.properties.ConfigProperties;
import sk.lorman.authservice.infrastructure.security.SecurityConstants;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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

        ZonedDateTime now = ZonedDateTime.now();
        Date issuedAt = toDate(now);
        Date expiresAt = toDate(now.plus(15, ChronoUnit.MINUTES));
        Date notBefore = toDate(now);

        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(properties.getSigningKey().getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)

                .setSubject(user)
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("rol", "user")
                .compact();


//        return JWT.create()
//                .withIssuer(issuer)
//                .withIssuedAt(issuedAt)
//                .withExpiresAt(expiresAt)
//                .withNotBefore(notBefore)
//                .withSubject(credentialDTO.getUsername())
//                .withClaim(OPEN_ID_STANDARD_CLAIM_FIRSTNAME, credentialDTO.getUsername())
//                .withClaim(OPEN_ID_STANDARD_CLAIM_LASTNAME, credentialDTO.getUsername())
//                .withClaim(CUSTOM_CLAIM_ROLES, "admin")
//                .sign(Algorithm.HMAC256(secretKey));
    }

    private Date toDate(final ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    private void validate(String user, String pwd) {
        if (!user.equals(pwd)) {
            throw new AuthException("user and pwd does not match");
        }
    }
}
