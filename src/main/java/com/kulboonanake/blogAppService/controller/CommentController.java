package com.kulboonanake.blogAppService.controller;

import com.kulboonanake.blogAppService.payload.CommentDto;
import com.kulboonanake.blogAppService.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable(value = "postId") long postId,
            @Valid @RequestBody CommentDto commentDto
    ){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(
            @PathVariable(value = "postId") long postId
    ){
        return commentService.getCommentByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "id") long id
    ){
        return new ResponseEntity<>(commentService.getCommentById(postId, id), HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @Valid @RequestBody CommentDto commentDto,
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "id") long id
    ){
        CommentDto commentResponse = commentService.updateCommentById(commentDto, postId, id);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deletePost(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "id") long id
    ){
        commentService.deleteCommentById(postId, id);

        return new ResponseEntity<>("Comment entity deleted successfully", HttpStatus.OK);
    }
}
