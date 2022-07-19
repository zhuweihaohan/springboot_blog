package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.Link;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LinkMapper {
	/**
	 * 查询链接
	 * @return
	 */
	@Select("select * from link")
	List<Link> listLink();
@Insert("insert into link (link_url,link_name,link_owner_contact,link_description,link_order,link_create_time) values(#{linkUrl},#{linkName},#{linkOwnerContact},#{linkDescription},#{linkOrder},NOW()) ")
void addLink(Link link);
@Delete("delete from link where link_id=#{id}")
void deleteById(Integer id);

@Select("select * from link where link_id=#{id}")
Link getLinkById(int id);

@Update("update link set link_url=#{linkUrl},link_name=#{linkName},link_owner_contact=#{linkOwnerContact},link_description=#{linkDescription},link_order=#{linkOrder},link_update_time=#{linkUpdateTime} where link_id=#{linkId}")
void update(Link link);

}
