package org.example.servlet;

import org.example.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangheng
 * @date 2023/02/08 18:59
 */
public class DefaultServletDemo extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultServletDemo.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		LOGGER.info("uri:{}", uri);
		ResponseUtils.printHtml(response, "Default Servlet", "This is a Default Servlet");
	}
}
