package com.jiuyi.yao.mapper.product;

import java.util.List;

import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月14日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ProductDB {
	public List<ProductDto> ProdList() throws Exception;
}
