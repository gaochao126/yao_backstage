package com.jiuyi.yao.dao.admin;

import java.util.List;

import com.jiuyi.yao.dto.admin.AdminDto;
import com.jiuyi.yao.dto.admin.PatientDto;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface AdminDao {
	/**
	 * 
	 * @number 1 @description 查询管理员列表
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月11日
	 */
	public List<PatientDto> queryAdminList() throws Exception;

	/**
	 * 
	 * @number 2 @description 通过名字密码查询管理员
	 * 
	 * @param adminDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月11日
	 */
	public List<AdminDto> queryAdminByNameAndPassword(AdminDto adminDto) throws Exception;
}
