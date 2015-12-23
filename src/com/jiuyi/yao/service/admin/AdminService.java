package com.jiuyi.yao.service.admin;

import java.util.List;

import com.jiuyi.yao.dto.admin.PatientDto;
import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface AdminService {
	/**
	 * 
	 * @number 1 @description 管理员列表
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月11日
	 */
	public List<PatientDto> adminList() throws Exception;

	public List<ProductDto> productList() throws Exception;
}
