package com.springBoot.service.posts;

import com.springBoot.domain.posts.PostsRepository;
import com.springBoot.web.dto.PostsSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveDto postsSaveDto){
        return postsRepository.save(postsSaveDto.toEntity()).getId();
    }
}
