package com.jiuyi.yao.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @description 用户请求过滤
 * @author zhb
 * @createTime 2015年7月20日
 */
public class RequestFilter implements Filter {
	protected final static Logger logger = Logger.getLogger(RequestFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String reqUrl = req.getServletPath();
		reqUrl = reqUrl.substring(reqUrl.lastIndexOf("/") + 1);
		if (reqUrl.startsWith("FileUploadServlet")) {
			RequestDispatcher rdsp = request.getRequestDispatcher("FileUploadServlet");
			rdsp.forward(req, resp);
			return;
		}
		if (reqUrl.startsWith("weixinapi")) {
			RequestDispatcher rdsp = request.getRequestDispatcher("weixinapi");
			rdsp.forward(req, resp);
			return;
		}

		if (!Util.isNotEmpty(reqUrl)) {
			return;
		}

		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}