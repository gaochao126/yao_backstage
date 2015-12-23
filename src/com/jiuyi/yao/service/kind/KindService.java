package com.jiuyi.yao.service.kind;

import java.util.List;

import com.jiuyi.yao.dto.KindDto;

/**
 * @author superb @Date 2015年12月18日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface KindService {
	/**
	 * 
	 * @number 1 @description 查询一级分类
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public List<KindDto> queryType(KindDto kindDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 根据一级分类ID查询二级分类
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public List<KindDto> querySecondByTypeId(KindDto kindDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 根据二级ID查询三级分类
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public List<KindDto> queryThirdBySecondId(KindDto kindDto) throws Exception;

}
