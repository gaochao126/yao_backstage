package com.jiuyi.yao.dto.admin;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class AdminDto extends BaseDto {

	private static final long serialVersionUID = -2049201864489618095L;

	private String admin_id;

	private String admin_name;

	private String admin_password;

	private String admin_img;

	private String admin_level;

	/** 仓库ID. */
	private String wh_id;

	/** 身份证号. */
	private String admin_idcard;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_img() {
		return admin_img;
	}

	public void setAdmin_img(String admin_img) {
		this.admin_img = admin_img;
	}

	public String getAdmin_level() {
		return admin_level;
	}

	public void setAdmin_level(String admin_level) {
		this.admin_level = admin_level;
	}

	public String getWh_id() {
		return wh_id;
	}

	public void setWh_id(String wh_id) {
		this.wh_id = wh_id;
	}

	public String getAdmin_idcard() {
		return admin_idcard;
	}

	public void setAdmin_idcard(String admin_idcard) {
		this.admin_idcard = admin_idcard;
	}

}
