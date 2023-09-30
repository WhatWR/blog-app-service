package com.kulboonanake.blogAppService.repository;

import com.kulboonanake.blogAppService.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
