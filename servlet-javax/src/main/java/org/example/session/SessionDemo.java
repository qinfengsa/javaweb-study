package org.example.session;

import org.example.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wangheng
 * @date 2023/02/10 14:03
 */
public class SessionDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session   = request.getSession();
		String      sessionId = session.getId();
		// 将数据存储到session中
		session.setAttribute("data", "king");
		if (session.isNew()) {
			ResponseUtils.printHtml(response, "Session Demo", "session创建成功，sessionId：" + sessionId);
		} else {
			ResponseUtils.printHtml(response, "Session Demo", "服务器已经存在该session了，sessionId：" + sessionId);
		}
	}
}
