package org.example.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.example.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * form-data 提交表单 自己实现
 *
 * @author wangheng
 * @date 2023/02/08 18:33
 */
@WebServlet(name = "demo3", value = "/servlet/demo3")
public class ServletDemo3 extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServletDemo3.class);


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload   upload  = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				LOGGER.info("param:{}={}", item.getFieldName(), item.getString("UTF-8"));
			}
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		}

		ResponseUtils.printHtml(response, "A Servlet Demo", " This is "
				+ this.getClass() + ", using the POST method");

	}
}
