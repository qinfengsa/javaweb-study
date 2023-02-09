package org.example.servlet;

import org.example.util.ResponseUtils;

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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String         uri     = request.getRequestURI();
		ServletContext context = getServletContext();
		context.setAttribute("uri", uri);
		ResponseUtils.printHtml(response, "A Servlet Demo", " This is " + this.getClass() + ", using the GET method");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResponseUtils.printHtml(response, "A Servlet Demo", " This is "
				+ this.getClass() + ", using the POST method");

	}
}
