package com.lilichatians.Lilichatians.common;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    User receiver;
    @Column(name = "message")
    String message;
    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "last_updated")
    String lastUpdated;
}
