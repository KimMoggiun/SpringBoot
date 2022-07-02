package com.springBoot.web;

import com.springBoot.domain.posts.PostsRepository;
import com.springBoot.web.dto.PostsSaveDto;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerTest extends TestCase {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void testSave(){
        String title = "title";
        String content = "content";
        String author = "author";
        PostsSaveDto postsSaveDto = PostsSaveDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/posts";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postsSaveDto, Long.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        Assertions.assertThat(postsRepository.findAll().get(0).getTitle()).isEqualTo(title);
        Assertions.assertThat(postsRepository.findAll().get(0).getContent()).isEqualTo(content);

    }
}