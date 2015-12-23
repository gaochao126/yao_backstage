package com.jiuyi.yao.action.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiuyi.yao.action.BaseAction;
import com.jiuyi.yao.dto.admin.PatientDto;
import com.jiuyi.yao.dto.product.ProductDto;
import com.jiuyi.yao.service.admin.AdminService;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class AdminAction extends BaseAction {
	private static final long serialVersionUID = 2420014262381943739L;

	@Autowired
	private AdminService adminService;

	/**
	 * 
	 * @number 1 @description 管理员列表
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月11日
	 */
	public String adminList() throws Exception {
		List<PatientDto> d = adminService.adminList();
		System.out.println(d.get(0).getPassword() + "-===-=-=-=-=-=-");
		System.out.println("++++++++++++");
		List<ProductDto> prods = adminService.productList();
		System.out.println("================");
		System.out.println(prods.size());
		for (int i = 0; i < prods.size(); i++) {
			System.out.println(prods.get(i).getProd_id() + "------" + prods.get(i).getProd_name());
		}

		this.setDataList(adminService.adminList());
		return "adminList";
	}

	public String list() throws Exception {
		System.out.println("_+=_+_+_");
		return "list";
	}
}
