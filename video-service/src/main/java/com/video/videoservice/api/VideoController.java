package com.video.videoservice.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/videos")
@RestController
public class VideoController {

    @GetMapping
    public ResponseEntity<Void> index()
    {
        return ResponseEntity.notFound().build();
    }
}
