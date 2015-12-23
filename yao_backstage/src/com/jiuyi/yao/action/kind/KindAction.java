package com.jiuyi.yao.action.kind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jiuyi.yao.action.BaseAction;
import com.jiuyi.yao.dto.KindDto;
import com.jiuyi.yao.service.kind.KindService;

/**
 * @author superb @Date 2015年12月18日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class KindAction extends BaseAction {

	private static final long serialVersionUID = 4981878863860428977L;

	@Autowired
	private KindService kindService;

	private KindDto kindDto;

	public static List<KindDto> types = new ArrayList<KindDto>();

	public static List<KindDto> seconds = new ArrayList<KindDto>();

	public static Map<String, List<KindDto>> thirds = new HashMap<String, List<KindDto>>();

	/**
	 * 
	 * @number @description 获取一级分类到缓存
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月22日
	 */
	public List<KindDto> getTypes() throws Exception {
		if (types.isEmpty()) {
			KindDto kindDto = new KindDto();
			types = kindService.queryType(kindDto);
			return types;
		} else {
			return types;
		}
	}

	/**
	 * 
	 * @number @description 获取二级分类缓存
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月22日
	 */
	public List<KindDto> getSeconds(KindDto kindDto) throws Exception {
		if (seconds.isEmpty()) {
			seconds = kindService.querySecondByTypeId(kindDto);
			return seconds;
		} else {
			return seconds;
		}
	}

	public List<KindDto> getThirds(String secondId) throws Exception {
		if (!thirds.containsKey(secondId)) {
			KindDto kindDto = new KindDto();
			kindDto.setSecond_id(secondId);
			List<KindDto> kinds = kindService.queryThirdBySecondId(kindDto);
			thirds.put(secondId, kinds);
			return kinds;
		} else {
			return thirds.get(secondId);
		}
	}

	/**
	 * 
	 * @number 1 @description 查询一级分类
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public String typeList() throws Exception {
		List<KindDto> kinds = getTypes();
		String result = JSONObject.toJSONString(kinds);
		print(result);
		return null;
	}

	/**
	 * 
	 * @number 2 @description 查询二级分类
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public String SecondList() throws Exception {
		List<KindDto> kinds = getSeconds(kindDto);
		String result = JSONObject.toJSONString(kinds);
		print(result);
		return null;
	}

	/**
	 * 
	 * @number 3 @description 查询三级分类
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public String ThirdList() throws Exception {
		List<KindDto> kinds = getThirds(kindDto.getSecond_id());
		String result = JSONObject.toJSONString(kinds);
		print(result);
		return null;
	}

	public KindDto getKindDto() {
		return kindDto;
	}

	public void setKindDto(KindDto kindDto) {
		this.kindDto = kindDto;
	}

}
