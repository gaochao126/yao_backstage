package com.jiuyi.yao.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.Util;
import com.jiuyi.yao.dao.product.FormatDao;
import com.jiuyi.yao.dao.product.ImgDao;
import com.jiuyi.yao.dao.product.ProductDao;
import com.jiuyi.yao.dto.ResponseDto;
import com.jiuyi.yao.dto.product.FormatDto;
import com.jiuyi.yao.dto.product.ImgDto;
import com.jiuyi.yao.dto.product.ProductDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.product.ProductService;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ImgDao imgDao;

	@Autowired
	private FormatDao formatDao;

	/**
	 * 
	 * @number 1 @description 添加药品
	 * 
	 * @param productDto
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	@Override
	public ResponseDto insertProduct(ProductDto productDto) throws Exception {
		if (productDto == null) {
			throw new BusinessException("数据不能为空");
		}
		if (!Util.isNotEmpty(productDto.getType_id())) {
			throw new BusinessException("请选择商品分类");
		}
		if (!Util.isNotEmpty(productDto.getSecond_id())) {
			throw new BusinessException("请选择商品分类");
		}
		if (!Util.isNotEmpty(productDto.getThird_id())) {
			throw new BusinessException("请选择商品分类");
		}
		if (!Util.isNotEmpty(productDto.getBrand_id())) {
			throw new BusinessException("请选择品牌");
		}
		if (!Util.isNotEmpty(productDto.getProd_name())) {
			throw new BusinessException("请填写名称");
		}
		if (!Util.isNotEmpty(productDto.getProd_certno())) {
			throw new BusinessException("请填写批准文号");
		}
		if (!Util.isNotEmpty(productDto.getProd_function())) {
			throw new BusinessException("请填写功能主治");
		}
		if (!Util.isNotEmpty(productDto.getImgSrcs())) {
			throw new BusinessException("请选择图片");
		}

		// 设置拼音
		productDto.setProd_pinyin(productDto.getProd_pinyin().toLowerCase());
		productDto.setProd_firstABC(productDto.getProd_firstABC().toLowerCase());

		System.out.println("typeId" + productDto.getType_id());
		System.out.println("secondId" + productDto.getSecond_id());
		System.out.println("thirdId" + productDto.getThird_id());
		System.out.println("brandId" + productDto.getBrand_id());
		System.out.println("shapIp" + productDto.getShape_id());
		System.out.println("Kind" + productDto.getKind_id());
		System.out.println("name" + productDto.getProd_name());
		System.out.println("commonName" + productDto.getProd_commonName());
		System.out.println("pinyin" + productDto.getProd_pinyin());
		System.out.println("ABC" + productDto.getProd_firstABC());
		System.out.println("function" + productDto.getProd_function());
		System.out.println("usage" + productDto.getProd_usage());
		System.out.println("成分" + productDto.getProd_chengfen());
		System.out.println("stroge" + productDto.getProd_storage());
		System.out.println("keep" + productDto.getProd_keepdate());
		System.out.println("cerno" + productDto.getProd_certno());
		System.out.println("产地" + productDto.getProd_chandi());
		System.out.println("图片" + productDto.getImgSrcs());
		System.out.println("禁忌" + productDto.getProd_taboo());
		System.out.println("===============规格==========");

		for (int i = 0; i < productDto.getFormats().size(); i++) {
			System.out.println("规格：" + productDto.getFormats().get(i) + "==包装：" + productDto.getPacks().get(i) + "==价格：" + productDto.getPrices().get(i) + "==库存：" + productDto.getSku().get(i));
		}

		// 添加商品
		String gid = Util.getUniqueSn();
		// 生成商品ID
		productDto.setProd_id(gid);
		// 生成图片ID
		String imgId = Util.getUniqueSn();
		// 生成默认规格ID
		String formatId = Util.getFormatId();

		productDto.setImg_id(imgId);
		productDto.setFormat_id(formatId);

		productDao.insertProduct(productDto);

		// 获得图片
		String imgSrc = productDto.getImgSrcs();
		ImgDto imgDto = new ImgDto();
		imgDto.setImg_id(imgId);
		imgDto.setImg_src(imgSrc);
		imgDto.setProd_id(gid);
		imgDto.setImg_type(1);

		System.out.println("添加图片");
		// 添加图片
		imgDao.insertImg(imgDto);
		System.out.println("添加图片成功");
		for (int i = 0; i < productDto.getFormats().size(); i++) {
			FormatDto formatDto = new FormatDto();
			if (i == 0) {
				formatDto.setFormat_id(formatId);
			} else {
				formatDto.setFormat_id(Util.getFormatId());
			}
			formatDto.setProd_id(gid);
			formatDto.setProd_format(productDto.getFormats().get(i));
			formatDto.setProd_pack(productDto.getPacks().get(i));
			formatDto.setProd_price(productDto.getPrices().get(i));
			formatDto.setProd_sku(productDto.getSku().get(i));
			formatDto.setFormat_status(1);
			formatDao.insertFormat(formatDto);
		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultCode(0);
		responseDto.setResultDesc("添加成功");
		return responseDto;
	}

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
	@Override
	public ResponseDto ProductList(ProductDto productDto) throws Exception{
		List<ProductDto> list = productDao.productList(productDto);
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		responseDto.setDetail(map);
		responseDto.setResultCode(0);
		responseDto.setResultDesc("商品列表");
		return responseDto;
	}

	/**
	 * 
	 * @number	3		@description	商品详情
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月29日
	 */
	@Override
	public ResponseDto productDetail(ProductDto productDto) throws Exception {
		if (productDto == null) {
			throw new BusinessException("数据异常");
		}
		if (!Util.isNotEmpty(productDto.getProd_id())) {
			throw new BusinessException("商品id不能为空");
		}

		// 查询商品
		List<ProductDto> prods = productDao.productList(productDto);
		ProductDto prod = new ProductDto();
		if (prods != null && prods.isEmpty()) {
			prod = prods.get(0);
		}

		// 查询规格
		FormatDto formatDto = new FormatDto();
		formatDto.setProd_id(productDto.getProd_id());
		List<FormatDto> formats = formatDao.queryFormat(formatDto);

		// 查询图片
		List<ImgDto> imgs = imgDao.queryImg(productDto);

		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prod", prod);
		map.put("formats", formats);
		map.put("imgs", imgs);
		responseDto.setDetail(map);
		responseDto.setResultDesc("商品详情");
		responseDto.setResultCode(0);
		return responseDto;
	}

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
	@Override
	public ResponseDto updateProd(ProductDto productDto) throws Exception{
		if(productDto == null){
			throw new BusinessException("数据异常");
		}
		if (!Util.isNotEmpty(productDto.getProd_id())) {
			throw new BusinessException("商品id不能为空");
		}
		if (!Util.isNotEmpty(productDto.getType_id()) || !Util.isNotEmpty(productDto.getSecond_id()) || !Util.isNotEmpty(productDto.getThird_id())) {
			throw new BusinessException("请选择商品类别");
		}
		if (!Util.isNotEmpty(productDto.getThird_id())) {
			throw new BusinessException("请选择商品分类");
		}
		if (!Util.isNotEmpty(productDto.getBrand_id())) {
			throw new BusinessException("请选择品牌");
		}
		if (!Util.isNotEmpty(productDto.getProd_name())) {
			throw new BusinessException("请填写名称");
		}
		if (!Util.isNotEmpty(productDto.getProd_certno())) {
			throw new BusinessException("请填写批准文号");
		}
		if (!Util.isNotEmpty(productDto.getProd_function())) {
			throw new BusinessException("请填写功能主治");
		}

		productDao.updateProd(productDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("修改基本信息");
		responseDto.setResultCode(0);
		return responseDto;
	}

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
	@Override
	public ResponseDto deleteFormat(FormatDto formatDto) throws Exception {
		if (formatDto == null) {
			throw new BusinessException("数据异常");
		}
		if (!Util.isNotEmpty(formatDto.getFormat_id())) {
			throw new BusinessException("规格id不能为空");
		}
		formatDao.deleteFormat(formatDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultCode(0);
		responseDto.setResultDesc("删除成功");
		return responseDto;
	}

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
	@Override
	public ResponseDto updateFormat(FormatDto formatDto) throws Exception {
		if (formatDto == null) {
			throw new BusinessException("数据不能为空");
		}
		if(!Util.isNotEmpty(formatDto.getProd_format())){
			throw new BusinessException("规格不能为空");
		}
		if(!Util.isNotEmpty(formatDto.getProd_pack())){
			throw new BusinessException("包装不能为空");
		}
		if(formatDto.getProd_price()==null){
			throw new BusinessException("价格不能为空");
		}
		if (formatDto.getProd_sku() == null) {
			throw new BusinessException("库存能为空");
		}
		return null;
	}

}
