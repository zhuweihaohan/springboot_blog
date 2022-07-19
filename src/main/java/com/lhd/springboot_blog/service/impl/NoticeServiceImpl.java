package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.entity.Notice;
import com.lhd.springboot_blog.mapper.NoticeMapper;
import com.lhd.springboot_blog.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService{
@Resource
private NoticeMapper noticeMapper;
	
	public List<Notice> listNotice() {
		
		return noticeMapper.listNotice();
	}

	
	public void addNotice(Notice notice) {
	noticeMapper.addNotice(notice);
	}


	
	public void deleteById(Integer id) {
		noticeMapper.deleteNoticeById(id);
		
	}


	public Notice getNoticeById(Integer id) {
		
		return noticeMapper.getNoticeById(id);
	}


	
	public void updateById(Notice n) {
		noticeMapper.updateById(n);
		
	}

}
