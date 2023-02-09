package org.example.servlet;

import org.example.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServlet.class);

	private String message;

	public void init() {
		message = "Hello World!";
		LOGGER.info("HelloServlet init");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String         uri     = request.getRequestURI();
		ServletContext context = getServletContext();
		context.setAttribute("uri", uri);

		// Hello
		ResponseUtils.printHtml(response, "Hello Servlet", "<h1>" + message + "</h1>");
	}

	public void destroy() {
		LOGGER.info("helloServlet destroy");
	}
}
