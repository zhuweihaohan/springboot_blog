package com.lhd.springboot_blog.entity;

import lombok.Data;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/23 0:00
 * @company bonc
 * @project springboot_blog
 */
@Data
public class IpListInfo {
    private String ip;
    private String count;
    private String lastVistTime;
    private String site;
}
