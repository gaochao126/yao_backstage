package com.jiuyi.yao.service.doctor;

import com.jiuyi.yao.dto.ResponseDto;
import com.jiuyi.yao.dto.doctor.PersonalDoctorDto;

/**
 * @description 私人医生业务接口
 * @author zhb
 * @createTime 2015年4月24日
 */
public interface PersonalDoctorService {
	/**
	 * @description 获取私人医生
	 * @param personalDoctorDto
	 * @return
	 * @throws Exception
	 */
	public ResponseDto queryPersonalDoctors(PersonalDoctorDto personalDoctorDto) throws Exception;

	/**
	 * @description 判断是否为自己的私人医生
	 * @param personalDoctorDto
	 * @return
	 * @throws Exception
	 */
	public ResponseDto isMyPersonalDoctor(PersonalDoctorDto personalDoctorDto) throws Exception;
}