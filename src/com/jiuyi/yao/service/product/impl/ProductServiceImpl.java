package com.jiuyi.yao.service.product.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.Constants;
import com.jiuyi.yao.common.PinYinUtil;
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

	/**
	 * 
	 * @number			@description	从excel读取药品信息·
	 * 
	 * @param path
	 * @param fileName
	 * @param fileType
	 * @throws Exception
	 *
	 * @Date 2016年3月4日
	 */
	@Override
	public void insertProdByExcel() throws Exception {
		String path = "F:\\html\\";
		String fileName = "791";
		String fileType = "xlsx";
		InputStream stream = new FileInputStream(path + fileName + "." + fileType);
		Workbook wb = null;
		if (fileType.equals("xls")) {
			wb = new HSSFWorkbook(stream);
		} else if (fileType.equals("xlsx")) {
			wb = new XSSFWorkbook(stream);
		} else {
			System.out.println("您输入的文件格式不正确");
		}

		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			if (row.getRowNum() == 0 || row.getRowNum() == 1) {
				continue;
			}
			ProductDto productDto = new ProductDto();
			FormatDto formatDto = new FormatDto();
			ImgDto imgDto = new ImgDto();
			for (Cell cell : row) {
				if (cell.getColumnIndex() == 0) {
					continue;
				}
				switch (cell.getColumnIndex()) {
				case 1:// id
					productDto.setProd_id(((int) cell.getNumericCellValue() + 3550) + "");
					productDto.setAdd_time(new Date());
					break;
				case 2:// prod_code
					productDto.setProd_code(cell.getStringCellValue());
					break;
				case 3:// prod_name
					productDto.setProd_name(cell.getStringCellValue());
					productDto.setProd_pinyin(PinYinUtil.getPingYin(productDto.getProd_name()));
					productDto.setProd_firstABC(PinYinUtil.getFirstSpell(productDto.getProd_name()));
					productDto.setProd_discount(1.15);
					break;
				case 4:// prod_commonName
					productDto.setProd_commonName(cell.getStringCellValue());
					break;
				case 5:// type_id
					productDto.setType_id(cell.getStringCellValue());
					break;
				case 6:// second_id
					productDto.setSecond_id(cell.getStringCellValue().substring(0, 2));
					break;
				case 7:// third_id
					productDto.setThird_id(cell.getStringCellValue().substring(0, 4));
					break;
				case 8:// shape_id
						productDto.setShape_id(cell.getStringCellValue().substring(0, 2));
					break;
				case 9:// brand_id
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						productDto.setBrand_id(cell.getStringCellValue().substring(0, 2));
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setBrand_id("ba");
					}
					break;
				case 10:// kind_id
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						productDto.setKind_id(cell.getStringCellValue().substring(0, 2));
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setKind_id("md");
					}
					break;
				case 11:// prod_certno
					productDto.setProd_certno(cell.getStringCellValue());
					break;
				case 12:// prod_keepdate
					if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						productDto.setProd_keepdate(((int) cell.getNumericCellValue()) + "个月");
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setProd_keepdate("见说明书");
					}

					break;
				case 13:// prod_function
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						productDto.setProd_function(cell.getStringCellValue());
						productDto.setProd_usage("见说明书");
						productDto.setProd_chengfen("见说明书");
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setProd_function("见说明书");
						productDto.setProd_usage("见说明书");
					}

					break;

				case 16:// prod_bad
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						productDto.setProd_bad(cell.getStringCellValue());
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setProd_bad("见说明书");
					}
					break;
				case 17:// prod_taboo
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						productDto.setProd_taboo(cell.getStringCellValue());
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setProd_taboo("见说明书");
					}
					break;
				case 18:// prod_chandi
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						productDto.setProd_chandi(cell.getStringCellValue());
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						productDto.setProd_chandi("见说明书");
					}
					break;
				case 19:// prod_format
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						formatDto.setFormat_id(productDto.getProd_id());
						formatDto.setProd_id(productDto.getProd_id());
						formatDto.setProd_format(cell.getStringCellValue());
						formatDto.setProd_pack("见包装");
						formatDto.setProd_unit("见包装");
						formatDto.setProd_sku(2000);
						formatDto.setFormat_status(1);
						productDto.setFormat_id(productDto.getProd_id());
						productDto.setImg_id(productDto.getProd_id());
						imgDto.setImg_id(productDto.getProd_id());
						imgDto.setImg_src("defaultimg.jpg");
						imgDto.setProd_id(productDto.getProd_id());
						imgDto.setImg_type(1);
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						formatDto.setFormat_id(productDto.getProd_id());
						formatDto.setProd_id(productDto.getProd_id());
						formatDto.setProd_format("默认规格");
						formatDto.setProd_pack("见包装");
						formatDto.setProd_unit("见包装");
						formatDto.setProd_sku(2000);
						formatDto.setFormat_status(1);
						productDto.setFormat_id(productDto.getProd_id());
						productDto.setImg_id(productDto.getProd_id());

						imgDto.setImg_id(productDto.getProd_id());
						imgDto.setImg_src("defaultimg.jpg");
						imgDto.setProd_id(productDto.getProd_id());
						imgDto.setImg_type(1);
					}
					break;
				case 24:// prod_price
					if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						formatDto.setProd_price(new BigDecimal(cell.getNumericCellValue() + ""));
					}
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						formatDto.setProd_price(new BigDecimal(0));
					}
					break;
				}
			}
			System.out.println(Constants.gson.toJson(productDto));
			System.out.println(Constants.gson.toJson(formatDto));
			System.out.println(Constants.gson.toJson(imgDto));
			productDao.insertProduct(productDto);
			formatDao.insertFormat(formatDto);
			imgDao.insertImg(imgDto);
			System.out.println("\n");
			System.out.println(row.getRowNum() + "==============");
			System.out.print("----");
		}
	}

	public static void main(String[] args) throws Exception {
		ProductServiceImpl p = new ProductServiceImpl();
		p.insertProdByExcel();
	}
}
