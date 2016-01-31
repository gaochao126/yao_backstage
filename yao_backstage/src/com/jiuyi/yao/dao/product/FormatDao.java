package com.jiuyi.yao.dao.product;

import java.util.List;

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

	/**
	 * 
	 * @number	2		@description
	 * 
	 * @param formatDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	public List<FormatDto> queryFormat(FormatDto formatDto) throws Exception;

	/**
	 * 
	 * @number		3	@description	删除规格
	 * 
	 * @param formatDto
	 * @throws Exception
	 *
	 * @Date 2016年1月31日
	 */
	public void deleteFormat(FormatDto formatDto) throws Exception;

	/**
	 * 
	 * @number		4	@description	修改规格
	 * 
	 * @param formatDto
	 * @throws Exception
	 *
	 * @Date 2016年1月31日
	 */
	public void updateFormat(FormatDto formatDto) throws Exception;
}
