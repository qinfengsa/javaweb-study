package org.example.cookie;

import org.apache.commons.lang3.StringUtils;
import org.example.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author wangheng
 * @date 2023/02/10 10:44
 */
public class CookieDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String   time    = "";
		if (Objects.nonNull(cookies)) {
			for (Cookie cookie : cookies) {
				if (Objects.equals(cookie.getName(), "lastAssessTime")) {
					time = cookie.getValue();
				}
			}
		}


		// 登录用户时间
		String assessTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		Cookie cookie     = new Cookie("lastAssessTime", assessTime);
		// 将cookie的有效期设置为0，命令浏览器删除该cookie
		cookie.setMaxAge(120);
		// 添加cookie
		response.addCookie(cookie);
		if (StringUtils.isNotEmpty(time)) {
			ResponseUtils.printHtml(response, "Cookie Demo", "您上次访问的时间是：" + time);
		} else {
			ResponseUtils.printHtml(response, "Cookie Demo", "这是您第一次访问本站！");
		}
	}
}
