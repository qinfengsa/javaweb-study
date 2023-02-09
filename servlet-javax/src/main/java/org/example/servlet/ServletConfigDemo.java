package org.example.servlet;

import org.example.util.ResponseUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author wangheng
 * @date 2023/02/09 11:23
 */
public class ServletConfigDemo extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servletconfig
		ServletConfig config = this.getServletConfig();

		StringBuilder sb = new StringBuilder();
		//获取在web.xml中配置的初始化参数
		String paramVal = config.getInitParameter("name");//获取指定的初始化参数
		sb.append(paramVal);

		sb.append("<hr/>");
		//获取所有的初始化参数
		Enumeration<String> e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name  = e.nextElement();
			String value = config.getInitParameter(name);
			sb.append(name).append("=").append(value).append("<br/>");
		}

		ResponseUtils.printHtml(response, "ServletConfig", sb.toString());
	}
}
