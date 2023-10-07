package com.lilichatians.Lilichatians.user.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserSignupDto {
    private String name;
    private String email;
    private String password;
    private String code;
}
