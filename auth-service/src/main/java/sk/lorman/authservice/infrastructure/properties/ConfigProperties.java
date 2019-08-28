package sk.lorman.authservice.infrastructure.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties
@PropertySource("classpath:application.properties")
@Getter
@Setter
public class ConfigProperties {
     
    private String signingKey;
}