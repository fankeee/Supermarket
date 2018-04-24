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

import com.glut.supermarket.bean.Goods;
import com.glut.supermarket.service.IGoodsService;
import com.glut.supermarket.service.impl.GoodsServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService goodsService = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		// 实例化商品业务
		goodsService = new GoodsServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===GoodsServlet===");
		String type = request.getParameter("type");
		System.out.println("===type===" + type);

		if ("findGoods".equals(type)) {
			// 根据商品ID查询
			findGoodsById(request, response);
		}
	}

	private void findGoodsById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// 清空页面缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		// 处理乱码
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String g_id = request.getParameter("g_id");
		System.out.println("GoodsServlet>>findGoodsById>>g_id:" + Integer.valueOf(g_id));
		Goods goods = goodsService.findGoodsById(Integer.valueOf(g_id));
		System.out.println("GoodsServlet>>findGoodsById>>g_id:" + goods);
		JSONObject jsonObj = JSONObject.fromObject(goods);
		out.println(jsonObj);
		out.flush();
		out.close();
	}

}
