package com.myblog9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

@Data
@Entity
@Table(name ="Posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "description", nullable = false, unique = true)
    private String description;
    @Column(name = "content", nullable = false, unique = true)
    private String content;

}
