package com.jiuyi.yao.service.product;

import com.jiuyi.yao.dto.ResponseDto;
import com.jiuyi.yao.dto.product.FormatDto;
import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ProductService {
	/**
	 * 
	 * @number 1 @description 添加药品
	 * 
	 * @param productDto
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	public ResponseDto insertProduct(ProductDto productDto) throws Exception;

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
	public ResponseDto ProductList(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number	3		@description	商品详情
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	public ResponseDto productDetail(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number	4		@description	修改商品基本信息
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	public ResponseDto updateProd(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number	5		@description	删除规格
	 * 
	 * @param formatDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月31日
	 */
	public ResponseDto deleteFormat(FormatDto formatDto) throws Exception;

	/**
	 * 
	 * @number		6	@description	修改规格
	 * 
	 * @param formatDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月31日
	 */
	public ResponseDto updateFormat(FormatDto formatDto) throws Exception;

	/**
	 * 
	 * @number			@description
	 * 
	 * @throws Exception
	 *
	 * @Date 2016年3月7日
	 */
	public void insertProdByExcel() throws Exception;

}
