package com.jiuyi.yao.dto.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @description 患者实体类
 * @author zhb
 * @createTime 2015年4月3日
 */
public class PatientDto extends BaseDto {
	/** serialVersionUID. */
	private static final long serialVersionUID = 4755331480320529940L;

	/** id. */
	private Integer id;

	/** md5Id. */
	private String md5Id;

	/** 姓名. */
	private String name;

	/** 昵称. */
	private String nickname;

	/** 密码. */
	private String password;

	private String md5Password;

	/** 旧密码. */
	private String oldPassword;

	/** 新密码. */
	private String newPassword;

	/** 身份证. */
	private String uid;

	/** 医保卡. */
	private String yibaoId;

	/** 电话. */
	private String phone;

	/** 邮箱. */
	private String email;

	/** 头像. */
	private String headPortrait;

	/** 性别. */
	private Integer gender;

	/** 生日. */
	private Date birthday;

	/** 地址. */
	private String address;

	/** 注册时间. */
	private Date registerTime;

	/** 更新时间. */
	private Date updateTime;

	/** 云推送token. */
	private String pushToken;

	/** 验证码. */
	private String verificationCode;

	/** 用户等级. */
	private Integer level;

	/** 实名认证状态. */
	private Integer authStatus;

	/** 百度云通道id. */
	private String channelId;

	/** 过敏史. */
	private String allergicHistory;

	/** 微信号. */
	private String weixinOpenId;

	/** 余额. */
	private Double balance;

	/** 邀请码. */
	private String invitationCode;

	/** 提现密码. */
	private String withdrawalPassword;

	/** 有无提现密码. */
	private boolean haveWithdrawalPassword;

	/** 推送开关(0:关, 1:开). */
	private Integer pushSwitchStatus;

	/** 患者配药选择的药物. */
	private List<Map<String, String>> medicineList;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getYibaoId() {
		return yibaoId;
	}

	public void setYibaoId(String yibaoId) {
		this.yibaoId = yibaoId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getAllergicHistory() {
		return allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public String getWeixinOpenId() {
		return weixinOpenId;
	}

	public void setWeixinOpenId(String weixinOpenId) {
		this.weixinOpenId = weixinOpenId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getWithdrawalPassword() {
		return withdrawalPassword;
	}

	public void setWithdrawalPassword(String withdrawalPassword) {
		this.withdrawalPassword = withdrawalPassword;
	}

	public boolean isHaveWithdrawalPassword() {
		return haveWithdrawalPassword;
	}

	public void setHaveWithdrawalPassword(boolean haveWithdrawalPassword) {
		this.haveWithdrawalPassword = haveWithdrawalPassword;
	}

	public Integer getPushSwitchStatus() {
		return pushSwitchStatus;
	}

	public void setPushSwitchStatus(Integer pushSwitchStatus) {
		this.pushSwitchStatus = pushSwitchStatus;
	}

	public List<Map<String, String>> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Map<String, String>> medicineList) {
		this.medicineList = medicineList;
	}

	public String getMd5Password() {
		return md5Password;
	}

	public void setMd5Password(String md5Password) {
		this.md5Password = md5Password;
	}

	public String getMd5Id() {
		return md5Id;
	}

	public void setMd5Id(String md5Id) {
		this.md5Id = md5Id;
	}
}