package sk.lorman.authservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@ToString
public class CredentialDTO {

    @NotEmpty
    private String user;

    @NotEmpty
    private String password;
}
