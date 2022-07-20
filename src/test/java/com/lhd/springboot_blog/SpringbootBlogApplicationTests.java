package com.lhd.springboot_blog;

import com.lhd.springboot_blog.entity.Tag;
import com.lhd.springboot_blog.service.ArticleService;
import com.lhd.springboot_blog.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBlogApplicationTests {
@Autowired
private TagService tagService;
@Autowired
private ArticleService articleService;
    @Test
    void contextLoads() {
//        Tag tag=new Tag();
//        tag.setTagName("111");
//        tag.setTagDescription("111");
//        tagService.addTag(tag);
//        System.out.println(tag.getTagId());
//       articleService.addtest(6);
    }

}
