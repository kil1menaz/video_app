package com.videoapp.commentservice.api;


import com.videoapp.commentservice.repo.model.Comment;
import com.videoapp.commentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {
    public final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> index()
    {
        final List<Comment> comments = commentService.fetchAll();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> show(@PathVariable long id) {
        try {
            final Comment comment = commentService.fetchById(id);
            return ResponseEntity.ok(comment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.videoapp.commentservice.api.dto.Comment comment)
    {
        final int user_id = comment.getUser_id();
        final String text = comment.getText();
        final int likes = comment.getLikes();
        final long id = commentService.create(user_id, text, likes);
        final String location = String.format("/comment/%d", id);


        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.videoapp.commentservice.api.dto.Comment comment)
    {
        final int user_id = comment.getUser_id();
        final String text = comment.getText();
        final int likes = comment.getLikes();
        commentService.update(id, user_id, text, likes);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id)
    {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
