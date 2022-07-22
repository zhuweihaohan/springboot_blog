package com.lhd.springboot_blog.service;

public interface VisitService {
    void addRecord(String visitIp, String url);

    int getNewIp(String visitIp);
}
