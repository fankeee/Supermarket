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
		// ʵ����ҵ��ӿ�
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
		// ��ȡ��������
		String type = request.getParameter("type");
		System.out.println("========type==========" + type);

		if ("checkUserID".equals(type)) {
			// ����û�ID�Ƿ����
			checkUserID(request, response);
		}else if("account_login".equals(type)){
			// �˺ŵ�¼
			accountLogin(request, response);
		}
	}

	/**
	 * ����û�ID�Ƿ����
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void checkUserID(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// ���ҳ�滺��
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		// ��������
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		// �û���
		String temp = request.getParameter("username");
		System.out.println("===========userID=========" + temp);
		int userID = Integer.parseInt(temp);

		Boolean result = userService.checkUserID(userID);
		System.out.println("======��ѯ���======" + result);
		out.println(result);
		out.flush();
		out.close();

	}

	/**
	 * �˺ŵ�¼
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
		// �û�ID
		int userID = Integer.parseInt(request.getParameter("username"));
		// ����
		String pwd = request.getParameter("password");

		User user = userService.accountLogin(userID, pwd);
		// System.out.println("user" + user);
		// ���ҳ�滺��
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		// ��������
		response.setContentType("text/html;charset=utf-8");

		if (user == null) {
			// ��¼ʧ��

			out.println(false);
			out.flush();
			out.close();
		} else {
			// ��¼�ɹ�

			// ����ǰ��¼�û����󱣴浽session��
			session.setAttribute("user", user);
			System.out.println("��¼�ɹ�");
			/*
			 * out.println(true); out.flush(); out.close();
			 */
			// ��ת����ҳ��

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
