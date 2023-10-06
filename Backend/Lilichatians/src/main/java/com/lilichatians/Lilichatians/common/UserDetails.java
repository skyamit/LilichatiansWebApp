package com.lilichatians.Lilichatians.common;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "user_details")
@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
    @Column(name = "dob")
    Long dob;
    @Column(name = "profile_link")
    String profileLink;
    @Column(name = "cover_link")
    String coverLink;
    @Column(name = "user_name", unique = true)
    String userName;

}
