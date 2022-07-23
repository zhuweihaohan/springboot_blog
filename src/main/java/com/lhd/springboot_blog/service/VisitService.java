package com.lhd.springboot_blog.service;

import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.entity.IpListInfo;
import com.lhd.springboot_blog.entity.VisitInfo;

public interface VisitService {
    void addRecord(String visitIp, String url,String site);

    int getNewIp(String visitIp);

    PageInfo<VisitInfo> getPageVisitList(Integer pageIndex, Integer pageSize);

    PageInfo<IpListInfo> getPageIpList(Integer pageIndex, Integer pageSize);
}
