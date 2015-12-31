package com.jiuyi.yao.dto.doctor;

import java.util.Date;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @description 私人医生实体类
 * @author zhb
 * @createTime 2015年4月24日
 */
public class PersonalDoctorDto extends BaseDto {
	/** serialVersionUID. */
	private static final long serialVersionUID = 2279097736838269746L;

	/** id. */
	private String id;

	/** 患者id. */
	private Integer patientId;

	/** 医生id. */
	private Integer doctorId;

	/** 创建时间. */
	private Date createTime;

	/** 过期时间. */
	private Date expirationTime;

	/** 医生名称. */
	private String doctorName;

	/** 头像. */
	private String headPortrait;

	/** 科室名称. */
	private String departmentName;

	/** 医院名称. */
	private String hospitalName;

	/** 职称名称. */
	private String titleName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
}