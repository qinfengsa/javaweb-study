package org.example.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangheng
 * @date 2023/02/09 15:45
 */
public class ResponseUtils {


	public static void printHtml(HttpServletResponse response, String title, String body) throws IOException {

		//设置服务器端以UTF-8编码进行输出
		response.setCharacterEncoding("UTF-8");
		//设置浏览器以UTF-8编码进行接收,解决中文乱码问题
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>" + title + "</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(body);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
