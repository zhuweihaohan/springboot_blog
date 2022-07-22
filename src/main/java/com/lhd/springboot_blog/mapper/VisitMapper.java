package com.lhd.springboot_blog.mapper;

public interface VisitMapper {
    void addRecord(String visitIp, String url);

    int getNewIp(String visitIp);
}
