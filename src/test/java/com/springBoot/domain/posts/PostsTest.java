package com.springBoot.domain.posts;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

public class PostsTest extends TestCase {

    @Test
    public void testLomBok(){
        String title = "titleTest";
        String content = "contentTest";

        Posts p = Posts.builder()
                .title(title)
                .content(content)
                .author("wanderingkmg@naver.com").build();

        Assertions.assertThat(p.getTitle()).isEqualTo(title);
        Assertions.assertThat(p.getContent()).isEqualTo(content);
    }
}