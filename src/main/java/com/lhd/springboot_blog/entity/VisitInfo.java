package com.lhd.springboot_blog.entity;

import lombok.Data;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/22 15:22
 * @company bonc
 * @project springboot_blog
 */
@Data
public class VisitInfo {
    private int id;
    private String visitIp;
    private String visitTime;
    private String visitUrl;
}
