package com.jiuyi.yao.dto.doctor;

import java.util.Date;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @description 医生实体类
 * @author zhb
 * @createTime 2015年4月13日
 */
public class DoctorDto extends BaseDto {
	/** serialVersionUID. */
	private static final long serialVersionUID = 7364629187885016248L;

	/** id. */
	private Integer id;

	private String md5Id;

	private String phone;

	private String idCardPath;

	private String titleCardPath;

	private String licenseCardPath;

	/** 姓名. */
	private String name;

	/** 头像. */
	private String head;

	/** 姓别(1:男, 2:女). */
	private Integer gender;

	/** 所在医院名称. */
	private String hospitalName;

	/** 所在医院id. */
	private Integer hospitalId;

	/** 二级科室id. */
	private Integer departmentId;

	/** 一级科室id. */
	private Integer parentDepartmentId;

	/** 科室名称. */
	private String departmentName;

	/** 推荐指数. */
	private Integer recommendScore;

	/** 科室分类（1：一级分类，2：二级分类）. */
	private Integer departmentType;

	/** 就诊数量. */
	private Integer attendanceCount;

	/** 职称id. */
	private Integer titleId;

	/** 职称. */
	private String titleName;

	/** 专长. */
	private String skill;

	/** 执业经历. */
	private String experience;

	/** 一元一诊名额. */
	private Integer yiyuanyizhenNumber;

	/** 图文咨询价格. */
	private Double consultPrice;

	/** 医生电话. */
	private String doctorPhone;

	/** 医生账户即将到账. */
	private Double accountComing;

	/** 查询类型(1:查询一级科室下的医生, 2:查询二级科室下的医生). */
	private Integer queryType;

	/** 医生类型(0:线下医生, 1:线上医生). */
	private Integer doctorType;

	/** 当前时间. */
	private Date nowDate;

	/** 剩余总挂号数量. */
	private Integer laveCount;

	private Integer levelOneDepartmentId;

	/** 科室图标. */
	private String departmentIcon;

	/** 平台一级科室. */
	private Integer parentId;

	private String demo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(Integer departmentType) {
		this.departmentType = departmentType;
	}

	public Integer getRecommendScore() {
		return recommendScore;
	}

	public void setRecommendScore(Integer recommendScore) {
		this.recommendScore = recommendScore;
	}

	public Integer getAttendanceCount() {
		return attendanceCount;
	}

	public void setAttendanceCount(Integer attendanceCount) {
		this.attendanceCount = attendanceCount;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getYiyuanyizhenNumber() {
		return yiyuanyizhenNumber;
	}

	public void setYiyuanyizhenNumber(Integer yiyuanyizhenNumber) {
		this.yiyuanyizhenNumber = yiyuanyizhenNumber;
	}

	public Double getConsultPrice() {
		return consultPrice;
	}

	public void setConsultPrice(Double consultPrice) {
		this.consultPrice = consultPrice;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public Double getAccountComing() {
		return accountComing;
	}

	public void setAccountComing(Double accountComing) {
		this.accountComing = accountComing;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public Integer getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(Integer doctorType) {
		this.doctorType = doctorType;
	}

	public Integer getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(Integer parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getLevelOneDepartmentId() {
		return levelOneDepartmentId;
	}

	public void setLevelOneDepartmentId(Integer levelOneDepartmentId) {
		this.levelOneDepartmentId = levelOneDepartmentId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Integer getLaveCount() {
		return laveCount;
	}

	public void setLaveCount(Integer laveCount) {
		this.laveCount = laveCount;
	}

	public String getMd5Id() {
		return md5Id;
	}

	public void setMd5Id(String md5Id) {
		this.md5Id = md5Id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCardPath() {
		return idCardPath;
	}

	public void setIdCardPath(String idCardPath) {
		this.idCardPath = idCardPath;
	}

	public String getLicenseCardPath() {
		return licenseCardPath;
	}

	public void setLicenseCardPath(String licenseCardPath) {
		this.licenseCardPath = licenseCardPath;
	}

	public String getTitleCardPath() {
		return titleCardPath;
	}

	public void setTitleCardPath(String titleCardPath) {
		this.titleCardPath = titleCardPath;
	}

	public String getDepartmentIcon() {
		return departmentIcon;
	}

	public void setDepartmentIcon(String departmentIcon) {
		this.departmentIcon = departmentIcon;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

}