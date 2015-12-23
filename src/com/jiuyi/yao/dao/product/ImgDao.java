package com.jiuyi.yao.dao.product;

import com.jiuyi.yao.dto.product.ImgDto;

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
}
