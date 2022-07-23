package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.IpListInfo;
import com.lhd.springboot_blog.entity.VisitInfo;

import java.util.List;

public interface VisitMapper {
    void addRecord(String visitIp, String url,String site);

    int getNewIp(String visitIp);

    List<VisitInfo> findAll();

    List<IpListInfo> findIpList();

    String getLastVisitTime(String ip);
}
