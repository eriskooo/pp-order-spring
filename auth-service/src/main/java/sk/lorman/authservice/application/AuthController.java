package sk.lorman.authservice.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.lorman.authservice.domain.AuthService;
import sk.lorman.authservice.domain.CredentialDTO;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(AuthController.BASE_URL)
public class AuthController {

    public static final String BASE_URL = "api/v1/auth";

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String issueToken(@RequestBody @Valid CredentialDTO credentialDTO) {
        return authService.issueToken(credentialDTO.getUser(), credentialDTO.getPassword());
    }
}
