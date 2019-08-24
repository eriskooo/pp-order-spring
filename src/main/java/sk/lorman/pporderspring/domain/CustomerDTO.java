package sk.lorman.pporderspring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;

}