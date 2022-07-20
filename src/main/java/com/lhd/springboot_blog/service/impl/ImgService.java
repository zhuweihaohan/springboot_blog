package com.lhd.springboot_blog.service.impl;

import java.util.List;

public interface ImgService {
    List<String> selImgUrlByArticleId(int articleId);
}
