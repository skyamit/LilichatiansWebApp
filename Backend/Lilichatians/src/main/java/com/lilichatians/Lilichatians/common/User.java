package com.lilichatians.Lilichatians.common;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "code")
    String code;
    @Column(name = "last_login")
    Long lastLogin;
    @Column(name = "is_active")
    Boolean isActive;
    @Column(name = "latitude")
    Float latitude;
    @Column(name = "longitude")
    Float longitude;
    @Column(name = "ip_address")
    String ipAddress;
    @Column(name = "is_online")
    Boolean isOnline;
}
