package com.lhd.springboot_blog.service;

import com.lhd.springboot_blog.entity.Notice;

import java.util.List;

public interface NoticeService {

	List<Notice> listNotice();

	void addNotice(Notice notice);

	void deleteById(Integer id);

	Notice getNoticeById(Integer id);

	void updateById(Notice n);

}
