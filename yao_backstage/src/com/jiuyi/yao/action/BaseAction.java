package com.jiuyi.yao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jiuyi.yao.common.Constants;
import com.jiuyi.yao.dto.Page;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @description base action
 * @author zhb
 * @createTime 2015年10月9日
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	/** serialVersionUID. */
	private static final long serialVersionUID = 8725831867311727902L;

	protected final static Logger logger = Logger.getLogger(BaseAction.class);

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	private Map<String, String> params;

	private List<?> dataList;

	private Object dataObj;

	private Page page;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @description 获取writer
	 * @return
	 * @throws IOException
	 */
	protected PrintWriter getWriter() throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "0");
		return response.getWriter();
	}

	/**
	 * @description <描述>
	 * @param oject
	 */
	protected void print(Object oject) {
		PrintWriter out = null;
		try {
			out = getWriter();
			out.print(oject);
		} catch (IOException e) {
			logger.error("响应异常", e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * @description 从参数中
	 * @param clazz
	 * @return
	 */
	protected <T> T getDtoFromParams(Class<T> clazz) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", this.getPage());
		if (this.getParams() != null) {
			map.putAll(this.getParams());
		}
		return Constants.gson.fromJson(Constants.gson.toJson(map), clazz);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public Object getDataObj() {
		return dataObj;
	}

	public void setDataObj(Object dataObj) {
		this.dataObj = dataObj;
	}
}