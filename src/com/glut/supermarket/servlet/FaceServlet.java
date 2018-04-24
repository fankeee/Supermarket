package com.glut.supermarket.servlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.glut.supermarket.bean.User;
import com.glut.supermarket.service.IFaceService;
import com.glut.supermarket.service.impl.FaceServiceImpl;
import com.glut.supermarket.util.UploadUtil;
import com.jspsmart.upload.SmartUploadException;

import sun.misc.BASE64Decoder;

/**
 * 
 * @author Fk
 *
 */
@WebServlet("/FaceServlet")
public class FaceServlet extends HttpServlet {

	// 设置APPID/AK/SK
	// 在应用列表中查看（详细获取方法请看使用文档）
	String APP_ID = "9910647";
	String API_KEY = "rvk2uy9Unb2Bl2Mft45CHdBm";
	String SECRET_KEY = "YOa3ompF3zWLCTCHUnLpzFNO0BCOkpkp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("===========FaceServlet=============");
		// 处理编码
		response.setCharacterEncoding("UTF-8");

		// 图片路径
		String filePath = null;
		try {
			// 保存图片到磁盘
			filePath = savePic(request, response);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ==========================================================
		PrintWriter out = response.getWriter();
		JSONObject res = null;
		// 获取类型（注册？识别？........）
		String type = request.getParameter("type");
		System.out.println("===type===" + type);

		if ("faceIdentify".equals(type)) {
			// 人脸识别
			System.out.println("=======identify========");
			// 初始化一个FaceClient
			AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
			// 可选：设置网络连接参数
			client.setConnectionTimeoutInMillis(2000);
			client.setSocketTimeoutInMillis(60000);

			// 要计算一张图片与指定组group_01 内各用户相似度(可指定多组)
			List<String> groupList = new ArrayList<>();
			groupList.add("group_01");

			// 可选参数
			HashMap<String, Object> options = new HashMap<String, Object>();
			// 返回用户top数，默认为1，最多返回5个
			options.put("user_top_num", 1);

			// 调用识别接口
			res = client.identifyUser(groupList, filePath, options);
			System.out.println("百度回传数据=======" + res);

			if (res.has("result")) {
				JSONObject resultObj = res.getJSONArray("result").getJSONObject(0);
				// 用户id
				String uid = resultObj.getString("uid");
				// System.out.println("=====uid====="+uid.substring(5));
				int u_id = Integer.parseInt(uid.substring(5));
				// 相似度评分
				double scores = resultObj.getJSONArray("scores").getDouble(0);
				// 组id
				String group_id = resultObj.getString("group_id");
				// 用户信息
				String user_info = resultObj.getString("user_info");

				System.out.println("用户id：" + uid + "\n相似度评分：" + scores + "\n组id：" + group_id + "\n用户信息" + user_info);

				IFaceService faceService = new FaceServiceImpl();
				User user = null;

				if (scores >= 80) {
					System.out.println("==============大于80============");
					// 分数大于80分，再判断数据库中是否有对应的用户
					user = faceService.findByIdAndName(u_id, user_info);
					if (user != null) {
						// 登录成功
						System.out.println("============数据库有匹配用户================");
						request.getSession().setAttribute("user", user);
						out.println(true);
					}

				} else {
					// 登录失败
					System.out.println("登录失败");
					out.println(false);
				}
			}

		} else if ("facesetAddUser".equals(type)) {
			// 人脸注册（注册页面没写）
			System.out.println("=======facesetAddUser========");
			res = facesetAddUser(filePath);
		}

		/*
		 * // 将百度返回结果回显页面 PrintWriter out = response.getWriter();
		 * out.print(res); out.flush(); out.close();
		 */
	}

	/**
	 * 保存图片
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws SmartUploadException
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	private String savePic(HttpServletRequest request, HttpServletResponse response)
			throws SmartUploadException, IOException, ServletException, SQLException, FileNotFoundException {

		UploadUtil uploadUtil = new UploadUtil();
		PageContext context = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192,
				true);

		Map<String, String> map = uploadUtil.update(context);
		BASE64Decoder base64 = new BASE64Decoder();

		// 64位解码
		byte[] buffer = base64.decodeBuffer(map.get("imageData"));

		// 写进文件
		String filePath = "images/" + new Date().getTime() + "" + new Random().nextInt(100000) + ".png";
		// 这个获取路径的方法可能会因服务器的不同而获取不到正确的路径
		// filePath = this.getServletContext().getRealPath("/"+filePath);

		// 获取到classes目录的全路径
		String classesPath = this.getClass().getClassLoader().getResource("/").getPath();
		// 先获取classes的路径，在使用字符串截取、拼接，得到Tomcat本项目下的images绝对路径
		filePath = classesPath.substring(1, classesPath.indexOf("WEB-INF")) + filePath;
		System.out.println("======图片存放路径======" + filePath);

		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(buffer);
		fos.flush();
		fos.close();
		fos = null;
		return filePath;
	}

	/**
	 * 人脸注册
	 * 
	 * @param filePath
	 *            -- 图片路径
	 * @return
	 */
	private JSONObject facesetAddUser(String filePath) {
		// 初始化一个FaceClient
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// 用户ID
		String user_ID = "User_1001";
		// 用户信息
		String user_info = "覃璠科";
		// 要将用户加入组的ID（可将一个用户加入多个组）
		List<String> groupList = new ArrayList<>();
		groupList.add("group_01");

		//
		HashMap<String, String> options = new HashMap<String, String>();
		// | 参数 |是否必选 | 类型 | 说明 |
		// | action_type | 否 | string| 参数包含append、replace
		// 如果为“replace”，则每次注册时进行替换replace（新增或更新）操作，默认为append操作
		options.put("action_type", "append");

		// 参数："uid1", "test_user_info", Arrays.asList("group1", "group2"),
		// path,options
		JSONObject res = client.addUser(user_ID, user_info, groupList, filePath, options);
		return res;
	}

}
