package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.mapper.VisitMapper;
import com.lhd.springboot_blog.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/22 15:40
 * @company bonc
 * @project springboot_blog
 */
@Service
public class VisitServiceImpl implements VisitService {
@Autowired
private VisitMapper visitMapper;
    @Override
    public void addRecord(String visitIp, String url) {
      visitMapper.addRecord(visitIp,url);
    }

    @Override
    public int getNewIp(String visitIp) {
        return visitMapper.getNewIp(visitIp);
    }
}
