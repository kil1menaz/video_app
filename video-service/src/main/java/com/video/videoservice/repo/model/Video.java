package com.video.videoservice.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "videos")
public final class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name")
    private String name;

    @Column(name ="description")
    private String description;

    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;

    @Column(name="duration")
    private long duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Video() {
    }

    public Video(String name, String description, int likes, int dislikes, long duration) {
        this.name = name;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
