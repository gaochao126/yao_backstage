package com.jiuyi.yao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jiuyi.yao.common.Constants;
import com.jiuyi.yao.common.SysCfg;
import com.jiuyi.yao.common.Util;
import com.jiuyi.yao.dto.ResultDto;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

/**
 * @description 文件上传
 * @author zhb
 * @createTime 2015年6月23日
 */
public class FileUploadServlet extends BaseServlet {
	private static final long serialVersionUID = -7020454770786546065L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		ResultDto result = new ResultDto();
		String type = req.getParameter("type");
		System.out.println(type + "=");
		try {

			// 新建一个SmartUpload对象
			SmartUpload su = new SmartUpload();

			PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, "", true, 8192, true);

			// 上传初始化
			su.initialize(pageContext);
			// su.initialize(getServletConfig(), req, resp);

			// 设置上传限制
			// 限制每个上传文件的最大长度为4MB
			su.setMaxFileSize(4 * 1024 * 1024);

			// 限制总上传文件的长度
			su.setTotalMaxFileSize(40 * 1024 * 1024);

			// 设定允许上传的文件
			su.setAllowedFilesList("jpg,png,jpeg,JPG,PNG,JPEG");

			// 设定禁止上传的文件
			su.setDeniedFilesList("exe,bat,jsp,htm,html");

			// 上传文件
			su.upload();
			String filePath = null;
			if ("1".equals(type)) {
				filePath = SysCfg.getString("service.medicine.url");
			}
			Files files = su.getFiles();
			if (files == null || files.getCount() == 0) {
				result.setResultCode(1);
				result.setResultDesc("上传文件不能为空");
				out.print(Constants.gson.toJson(result));
				return;
			}
			Map<String, Object> detail = new HashMap<String, Object>();
			List<String> list = new ArrayList<String>();
			result.setDetail(detail);
			detail.put("list", list);

			for (int i = 0; i < files.getCount(); i++) {

				File file = files.getFile(i);
				System.out.println("xunhuan+" + file.getFileExt() + "==" + file.getFieldName());
				String fileName = null;
				if ("1".equals(type)) {
					fileName = "yao_" + Util.getUniqueSn() + "." + file.getFileExt();
				}
				file.saveAs(filePath + fileName, SmartUpload.SAVE_AUTO);
				list.add(fileName);
			}

			result.setResultCode(0);
			result.setResultDesc("上传成功");
			out.print(Constants.gson.toJson(result));
		} catch (Exception e) {
			result.setResultCode(1);
			result.setResultDesc("文件上传失败");
			out.print(Constants.gson.toJson(result));
			logger.error("文件上传失败", e);
		} finally {
			out.flush();
			out.close();
			logger.info("file upload response : " + Constants.gson.toJson(result));
		}
	}
}