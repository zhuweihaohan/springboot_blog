package com.lhd.springboot_blog.mapper;

import java.util.List;

public interface ImgMapper {

    List<String> selImgUrlByArticleId(int articleId);

    List<String> selImgPathByArticleId(Integer id);

    void delArticleImgRefByArticleId(Integer id);
}
