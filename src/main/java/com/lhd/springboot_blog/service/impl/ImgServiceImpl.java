package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.mapper.ImgMapper;
import com.lhd.springboot_blog.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/20 9:19
 * @company bonc
 * @project springboot_blog
 */
@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    ImgMapper imgMapper;
    @Override
    public List<String> selImgUrlByArticleId(int articleId) {
        return imgMapper.selImgUrlByArticleId(articleId);
    }
}
