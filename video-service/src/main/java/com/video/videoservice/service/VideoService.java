package com.video.videoservice.service;


import com.video.videoservice.repo.VideoRepo;
import com.video.videoservice.repo.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public final class VideoService
{
    private final VideoRepo videoRepo;

    public List<Video> fetchAll()
    {
        return videoRepo.findAll();
    }

    public Video fetchById(long id)  throws IllegalArgumentException
    {
        return videoRepo.getById(id);
    }

    public long create(String name, String description, int likes, int dislikes, long duration) throws IllegalArgumentException
    {
        final Video video = new Video(name, description, likes, dislikes, duration);
        final Video savedVideo = videoRepo.save(video);
        return savedVideo.getId();
    }

    public void update(long id, String name, String description, int likes, int dislikes, long duration)
    {
        final Video video = videoRepo.getById(id);
        video.setDescription(description);
        video.setDuration(duration);
        video.setName(name);
        video.setLikes(likes);
        video.setDislikes(dislikes);
        videoRepo.save(video);
    }

    public void delete(long id)
    {
        videoRepo.deleteById(id);
    }
}
