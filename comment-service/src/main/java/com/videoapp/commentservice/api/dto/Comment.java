package com.videoapp.commentservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {
    private int user_id;
    private String text;
    private int likes;
}
