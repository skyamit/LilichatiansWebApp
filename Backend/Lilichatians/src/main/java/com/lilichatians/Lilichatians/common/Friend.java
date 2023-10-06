package com.lilichatians.Lilichatians.common;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "friend")
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    User friend;
    @Column(name = "is_active")
    Boolean isActive;
    @Column(name = "last_updated")
    Boolean lastUpdated;
}
