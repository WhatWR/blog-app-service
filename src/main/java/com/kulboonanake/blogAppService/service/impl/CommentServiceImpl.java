package com.kulboonanake.blogAppService.service.impl;

import com.kulboonanake.blogAppService.entity.Comment;
import com.kulboonanake.blogAppService.entity.Post;
import com.kulboonanake.blogAppService.exception.ResourceNotFoundException;
import com.kulboonanake.blogAppService.payload.CommentDto;
import com.kulboonanake.blogAppService.payload.PostDto;
import com.kulboonanake.blogAppService.payload.PostResponse;
import com.kulboonanake.blogAppService.repository.CommentRepository;
import com.kulboonanake.blogAppService.repository.PostRepository;
import com.kulboonanake.blogAppService.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);
        return mapToDTO(newComment);
    }

    @Override
    public void getAllComments(int pageNo, int pageSize, String sortBy, String sortDir) {

    }

    @Override
    public PostDto getCommentById(long id) {
        return null;
    }

    @Override
    public PostDto updateComment(CommentDto commentDto, long id) {
        return null;
    }

    @Override
    public void DeleteCommentById(long id) {

    }

    private CommentDto mapToDTO(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment  = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
}
