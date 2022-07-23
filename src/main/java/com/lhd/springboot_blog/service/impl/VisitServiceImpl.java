package com.lhd.springboot_blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.entity.*;
import com.lhd.springboot_blog.mapper.VisitMapper;
import com.lhd.springboot_blog.service.VisitService;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Autowired
private Ip2regionSearcher regionSearcher;
    @Override
    public void addRecord(String visitIp, String url,String site) {
      visitMapper.addRecord(visitIp,url,site);
    }

    @Override
    public int getNewIp(String visitIp) {
        return visitMapper.getNewIp(visitIp);
    }

    @Override
    public PageInfo<VisitInfo> getPageVisitList(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);

        List<VisitInfo> visitList= visitMapper.findAll();

        return new PageInfo<>(visitList);
    }

    @Override
    public PageInfo<IpListInfo> getPageIpList(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<IpListInfo> ipList= visitMapper.findIpList();
        for (int i = 0; i < ipList.size(); i++) {
            String ip = ipList.get(i).getIp();
            ipList.get(i).setSite(regionSearcher.getAddress(ip));
            ipList.get(i).setLastVistTime(visitMapper.getLastVisitTime(ip));
        }
        return new PageInfo<>(ipList);
    }
}
