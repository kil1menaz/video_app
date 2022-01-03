package com.video.videoservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Video {
    private String name;
    private String description;
    private long duration;
    private int likes;
    private int dislikes;
}
