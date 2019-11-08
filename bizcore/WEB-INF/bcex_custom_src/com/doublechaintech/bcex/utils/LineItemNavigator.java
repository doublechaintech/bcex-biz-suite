package com.doublechaintech.bcex.utils;

import com.terapico.caf.viewpage.SerializeScope;

public class LineItemNavigator {
	protected String code;
	protected String imageUrl;
	protected String title;
	protected String linkToUrl;
	protected String brief;
	public LineItemNavigator(String code, String imageUrl, String title, String linkToUrl, String brief) {
		super();
		this.code = code;
		this.imageUrl = imageUrl;
		this.title = title;
		this.linkToUrl = linkToUrl;
		this.brief = brief;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkToUrl() {
		return linkToUrl;
	}
	public void setLinkToUrl(String linkToUrl) {
		this.linkToUrl = linkToUrl;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
}
