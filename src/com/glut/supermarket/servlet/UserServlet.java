package com.glut.supermarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glut.supermarket.bean.User;
import com.glut.supermarket.service.IUserService;
import com.glut.supermarket.service.impl.UserServiceImpl;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService userService = null;

	public void init(ServletConfig config) throws ServletException {
		// 实例化业务接口
		userService = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取参数类型
		String type = request.getParameter("type");
		System.out.println("========type==========" + type);

		if ("checkUserID".equals(type)) {
			// 检查用户ID是否存在
			checkUserID(request, response);
		}else if("account_login".equals(type)){
			// 账号登录
			accountLogin(request, response);
		}
	}

	/**
	 * 检查用户ID是否存在
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void checkUserID(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 清空页面缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		// 处理乱码
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		// 用户名
		String temp = request.getParameter("username");
		System.out.println("===========userID=========" + temp);
		int userID = Integer.parseInt(temp);

		Boolean result = userService.checkUserID(userID);
		System.out.println("======查询结果======" + result);
		out.println(result);
		out.flush();
		out.close();

	}

	/**
	 * 账号登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void accountLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// 用户ID
		int userID = Integer.parseInt(request.getParameter("username"));
		// 密码
		String pwd = request.getParameter("password");

		User user = userService.accountLogin(userID, pwd);
		// System.out.println("user" + user);
		// 清空页面缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		// 处理乱码
		response.setContentType("text/html;charset=utf-8");

		if (user == null) {
			// 登录失败

			out.println(false);
			out.flush();
			out.close();
		} else {
			// 登录成功

			// 将当前登录用户对象保存到session中
			session.setAttribute("user", user);
			System.out.println("登录成功");
			/*
			 * out.println(true); out.flush(); out.close();
			 */
			// 跳转到主页面

			// request.getRequestDispatcher("index.jsp").forward(request,
			// response);

			// response.sendRedirect("${pageContext.request.contextPath
			// }/index.jsp");
			out.println(true);
			out.flush();
			out.close();
		}
	}
	
}
