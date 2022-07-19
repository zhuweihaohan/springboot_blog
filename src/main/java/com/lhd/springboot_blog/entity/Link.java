package com.lhd.springboot_blog.entity;

import java.util.Date;

public class Link {
	private Integer linkId;

	//链接地址
	private String linkUrl;

	//链接名称
	private String linkName;

	//链接图片
	private String linkImage;

	//链接描述
	private String linkDescription;

	//链接所有者昵称
	private String linkOwnerNickname;

	//联系方式
	private String linkOwnerContact;

	//最后更新时间
	private Date linkUpdateTime;

	//创建时间
	private Date linkCreateTime;

	//链接顺序
	private Integer linkOrder;

	//链接状态
	private Integer linkStatus;
	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	public String getLinkOwnerNickname() {
		return linkOwnerNickname;
	}

	public void setLinkOwnerNickname(String linkOwnerNickname) {
		this.linkOwnerNickname = linkOwnerNickname;
	}

	public String getLinkOwnerContact() {
		return linkOwnerContact;
	}

	public void setLinkOwnerContact(String linkOwnerContact) {
		this.linkOwnerContact = linkOwnerContact;
	}

	public Date getLinkUpdateTime() {
		return linkUpdateTime;
	}

	public void setLinkUpdateTime(Date linkUpdateTime) {
		this.linkUpdateTime = linkUpdateTime;
	}

	public Date getLinkCreateTime() {
		return linkCreateTime;
	}

	public void setLinkCreateTime(Date linkCreateTime) {
		this.linkCreateTime = linkCreateTime;
	}

	public Integer getLinkOrder() {
		return linkOrder;
	}

	public void setLinkOrder(Integer linkOrder) {
		this.linkOrder = linkOrder;
	}

	public Integer getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(Integer linkStatus) {
		this.linkStatus = linkStatus;
	}


}
