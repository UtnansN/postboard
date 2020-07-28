package com.social.postboard.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime creationDate;

    private LocalDateTime editDate;

    private String text;

    @ManyToMany
    private List<User> upVoters;

    @ManyToOne
    private Post post;
}
