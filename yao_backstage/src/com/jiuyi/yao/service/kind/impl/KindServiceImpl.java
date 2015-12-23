package com.jiuyi.yao.service.kind.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.Util;
import com.jiuyi.yao.dao.kind.KindDao;
import com.jiuyi.yao.dto.KindDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.kind.KindService;

/**
 * @author superb @Date 2015年12月18日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class KindServiceImpl implements KindService {
	@Autowired
	private KindDao kindDao;

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
	@Override
	public List<KindDto> queryType(KindDto kindDto) throws Exception {
		return kindDao.queryTypeList(kindDto);
	}

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
	@Override
	public List<KindDto> querySecondByTypeId(KindDto kindDto) throws Exception {

		return kindDao.querySecondListByTypeId(kindDto);
	}

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
	@Override
	public List<KindDto> queryThirdBySecondId(KindDto kindDto) throws Exception {
		if (kindDto == null) {
			throw new BusinessException("数据异常");
		}
		if (!Util.isNotEmpty(kindDto.getSecond_id())) {
			throw new BusinessException("二级分类ID不能为空");
		}

		return kindDao.queryThirdListBySecondId(kindDto);
	}
}
