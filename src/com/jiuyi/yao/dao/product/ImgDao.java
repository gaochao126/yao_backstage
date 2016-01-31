package com.jiuyi.yao.dao.product;

import java.util.List;

import com.jiuyi.yao.dto.product.ImgDto;
import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ImgDao {
	/**
	 * 
	 * @number 1 @description 添加图片
	 * 
	 * @param imgDto
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	public void insertImg(ImgDto imgDto) throws Exception;

	/**
	 * 
	 * @number	2		@description	查询图片
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	public List<ImgDto> queryImg(ProductDto productDto) throws Exception;
}
