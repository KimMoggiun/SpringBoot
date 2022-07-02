package com.springBoot.web;

import com.springBoot.domain.posts.PostsRepository;
import com.springBoot.service.posts.PostsService;
import com.springBoot.web.dto.PostsSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;


    @PostMapping("/posts")
    public Long savePost(@RequestBody PostsSaveDto postsSaveDto){
        return postsService.save(postsSaveDto);
    }
}
