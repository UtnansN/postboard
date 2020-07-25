package com.social.postboard.repository;

import com.social.postboard.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    Optional<Community> findFirstByTag(String tag);

    void deleteByTag(String tag);

}
