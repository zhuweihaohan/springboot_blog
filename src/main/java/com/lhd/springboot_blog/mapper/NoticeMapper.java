package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoticeMapper {

	@Select("select * from notice")
	List<Notice> listNotice();
@Insert("insert into notice (notice_title,notice_content) values(#{noticeTitle},#{noticeContent})")
	void addNotice(Notice notice);
@Delete("delete from notice where notice_id=#{id}")
void deleteNoticeById(Integer id);

@Select("select * from notice where notice_id=#{id}")
Notice getNoticeById(Integer id);

@Update("update notice set notice_title=#{noticeTitle},notice_content=#{noticeContent} where notice_id=#{noticeId}")
void updateById(Notice n);

}
