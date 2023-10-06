package com.lilichatians.Lilichatians.common;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "post_image")
@Entity
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    Post post;
    @Column(name = "image_link")
    String imageLink;
    @Column(name = "last_updated")
    Long lastUpdated;
}
