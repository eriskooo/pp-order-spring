package sk.lorman.pporderspring.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;

}
