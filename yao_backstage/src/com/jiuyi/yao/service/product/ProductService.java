package com.jiuyi.yao.service.product;

import com.jiuyi.yao.dto.ResponseDto;
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
}
