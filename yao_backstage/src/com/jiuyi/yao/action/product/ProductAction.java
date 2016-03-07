package com.jiuyi.yao.action.product;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jiuyi.yao.action.BaseAction;
import com.jiuyi.yao.dto.ResponseDto;
import com.jiuyi.yao.dto.product.ProductDto;
import com.jiuyi.yao.service.product.ProductService;

/**
 * @author superb @Date 2015年12月18日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 7782121447429596283L;

	@Autowired
	private ProductService productService;

	private ProductDto productDto;

	private ResponseDto responseDto;

	/**
	 * 
	 * @number 1 @description 添加商品
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public String insertProd() {
		try {
			responseDto = productService.insertProduct(productDto);
		} catch (Exception e) {
			responseDto.setResultDesc(e.getMessage());
			responseDto.setResultCode(1);
		}
		String result = JSONObject.toJSONString(responseDto);
		print(result);
		return null;
	}

	/**
	 * 
	 * @number 2 @description 去添加商品页面
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月22日
	 */
	public String toInsert() throws Exception {
		return "product_post";
	}

	public String insertProdByExcle() throws Exception {
		productService.insertProdByExcel();
		return "ok";
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public ResponseDto getResponseDto() {
		return responseDto;
	}

	public void setResponseDto(ResponseDto responseDto) {
		this.responseDto = responseDto;
	}

}
