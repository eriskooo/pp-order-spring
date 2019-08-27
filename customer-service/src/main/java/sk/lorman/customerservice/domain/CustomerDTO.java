package sk.lorman.customerservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;

}
