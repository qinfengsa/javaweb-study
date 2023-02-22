package org.example.servlet;

import org.apache.commons.io.IOUtils;
import org.example.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * form-data 提交表单
 * 必须加注解 @MultipartConfig
 *
 * @author wangheng
 * @date 2023/02/08 18:33
 */
@WebServlet(name = "demo2", value = "/servlet/demo2")
@MultipartConfig
public class ServletDemo2 extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServletDemo2.class);


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String       filedName = part.getName();
			List<String> values    = IOUtils.readLines(part.getInputStream(), "UTF-8");
			LOGGER.info("param:{}={}", filedName, String.join(",", values));
		}
		// 流被读取了，为空，无法再次读取
		InputStream  inputStream = request.getInputStream();
		List<String> params      = IOUtils.readLines(inputStream, "UTF-8");
		for (String param : params) {
			LOGGER.info("param:{}", param);
		}
		ResponseUtils.printHtml(response, "A Servlet Demo", " This is "
				+ this.getClass() + ", using the POST method");

	}
}
