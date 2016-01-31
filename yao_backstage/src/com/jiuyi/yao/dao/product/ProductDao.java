package com.jiuyi.yao.dao.product;

import java.util.List;

import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ProductDao {
	/**
	 * 
	 * @number 1 @description 添加药品
	 * 
	 * @param productDto
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	public void insertProduct(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number	2		@description	商品列表
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	public List<ProductDto> productList(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number	3		@description	修改商品基本信息
	 * 
	 * @param productDto
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	public void updateProd(ProductDto productDto) throws Exception;


}
