package com.social.postboard.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Community {

    // ID is a tag used in the URL
    @Id
    private String id;

    private LocalDateTime creationDate;

    private String title;

    private String description;

    @OneToMany
    private List<Post> posts;
}
