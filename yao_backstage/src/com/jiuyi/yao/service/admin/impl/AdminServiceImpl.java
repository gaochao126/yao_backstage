package com.jiuyi.yao.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.dao.admin.AdminDao;
import com.jiuyi.yao.dto.admin.PatientDto;
import com.jiuyi.yao.dto.product.ProductDto;
import com.jiuyi.yao.mapper.product.ProductDB;
import com.jiuyi.yao.service.admin.AdminService;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private ProductDB productDB;

	/**
	 * 
	 * @number 1 @description 管理员列表
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月11日
	 */
	@Override
	public List<PatientDto> adminList() throws Exception {
		return adminDao.queryAdminList();
	}

	@Override
	public List<ProductDto> productList() throws Exception {
		return productDB.ProdList();
	}
}
