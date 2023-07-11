package com.example.ordersystem.dto;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date date;


}
