package com.social.postboard.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime creationDate;

    private Long upVotes;

    @Enumerated
    private PostType type;

    private String title;

    private String contents;

    @OneToMany
    private List<Comment> comments;

}
