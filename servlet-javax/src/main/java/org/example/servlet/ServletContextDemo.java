package org.example.servlet;

import org.example.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangheng
 * @date 2023/02/09 15:23
 */
public class ServletContextDemo extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServletContextDemo.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String         name    = context.getInitParameter("name");
		String         lastUri = (String) context.getAttribute("uri");
		LOGGER.info("name:{}", name);
		ResponseUtils.printHtml(response, "ServletContext", "lastUri:" + lastUri);
	}
}
