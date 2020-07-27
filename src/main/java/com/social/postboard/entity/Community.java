package com.social.postboard.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Community {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime creationDate;

    // Tag is used in the URLs to access communities
    @Column(unique = true, nullable = false)
    private String tag;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToMany
    private List<User> members;

    @OneToMany
    private List<Post> posts;
}
