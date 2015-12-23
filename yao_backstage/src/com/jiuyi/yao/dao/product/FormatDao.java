package com.jiuyi.yao.dao.product;

import com.jiuyi.yao.dto.product.FormatDto;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface FormatDao {
	/**
	 * 
	 * @number 1 @description 添加规格
	 * 
	 * @param formatDto
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	public void insertFormat(FormatDto formatDto) throws Exception;
}
