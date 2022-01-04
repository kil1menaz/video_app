package com.videoapp.commentservice.service;

import com.videoapp.commentservice.repo.CommentRepo;
import com.videoapp.commentservice.repo.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepo commentRepo;


    public List<Comment> fetchAll()
    {
        return commentRepo.findAll();
    }

    public Comment fetchById(long id)  throws IllegalArgumentException
    {
        return commentRepo.getById(id);
    }

    public long create(int user_id, String text, int likes) throws IllegalArgumentException
    {
        final Comment comment = new Comment(user_id, text, likes);
        final Comment savedComment = commentRepo.save(comment);
        return savedComment.getId();
    }

    public void update(long id, int user_id, String text, int likes)
    {
        final Comment comment = commentRepo.getById(id);
        comment.setUser_id(user_id);
        comment.setText(text);
        comment.setLikes(likes);
        commentRepo.save(comment);
    }

    public void delete(long id)
    {
        commentRepo.deleteById(id);
    }
}
