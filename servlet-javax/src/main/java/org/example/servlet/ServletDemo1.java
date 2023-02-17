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
 * @date 2023/02/08 18:33
 */
public class ServletDemo1 extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServletDemo1.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String         uri     = request.getRequestURI();
		ServletContext context = getServletContext();
		context.setAttribute("uri", uri);

		String name = request.getParameter("name");

		String[] names = request.getParameterValues("name");
		LOGGER.info("name:{}", name);
		LOGGER.info("names:{}", String.join(",", names));

		ResponseUtils.printHtml(response, "A Servlet Demo", " This is " + this.getClass() + ", using the GET method");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String   name  = request.getParameter("name");
		String[] names = request.getParameterValues("name");
		LOGGER.info("name:{}", name);
		LOGGER.info("names:{}", String.join(",", names));
		ResponseUtils.printHtml(response, "A Servlet Demo", " This is "
				+ this.getClass() + ", using the POST method");

	}
}
