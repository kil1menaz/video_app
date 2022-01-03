package com.video.videoservice.api;


import com.video.videoservice.repo.model.Video;
import com.video.videoservice.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/videos")
@RestController
public final class VideoController {

    public final VideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> index()
    {
        final List<Video> videos = videoService.fetchAll();
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> show(@PathVariable long id) {
        try {
            final Video video = videoService.fetchById(id);
            return ResponseEntity.ok(video);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.video.videoservice.api.dto.Video video)
    {
        final String name = video.getName();
        final String description = video.getDescription();
        final int likes = video.getLikes();
        final int dislikes = video.getDislikes();
        final long duration = video.getDuration();
        final long id = videoService.create(name, description, likes, dislikes, duration);
        final String location = String.format("/video/%d", id);


        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.video.videoservice.api.dto.Video video)
    {
        final String name = video.getName();
        final long duration = video.getDuration();
        final int likes = video.getLikes();
        final int dislikes = video.getDislikes();
        final String description = video.getDescription();
        videoService.update(id, name, description, likes, dislikes,  duration);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id)
    {
        videoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

