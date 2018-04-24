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

	// ����APPID/AK/SK
	// ��Ӧ���б��в鿴����ϸ��ȡ�����뿴ʹ���ĵ���
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
		// �������
		response.setCharacterEncoding("UTF-8");

		// ͼƬ·��
		String filePath = null;
		try {
			// ����ͼƬ������
			filePath = savePic(request, response);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ==========================================================
		PrintWriter out = response.getWriter();
		JSONObject res = null;
		// ��ȡ���ͣ�ע�᣿ʶ��........��
		String type = request.getParameter("type");
		System.out.println("===type===" + type);

		if ("faceIdentify".equals(type)) {
			// ����ʶ��
			System.out.println("=======identify========");
			// ��ʼ��һ��FaceClient
			AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
			// ��ѡ�������������Ӳ���
			client.setConnectionTimeoutInMillis(2000);
			client.setSocketTimeoutInMillis(60000);

			// Ҫ����һ��ͼƬ��ָ����group_01 �ڸ��û����ƶ�(��ָ������)
			List<String> groupList = new ArrayList<>();
			groupList.add("group_01");

			// ��ѡ����
			HashMap<String, Object> options = new HashMap<String, Object>();
			// �����û�top����Ĭ��Ϊ1����෵��5��
			options.put("user_top_num", 1);

			// ����ʶ��ӿ�
			res = client.identifyUser(groupList, filePath, options);
			System.out.println("�ٶȻش�����=======" + res);

			if (res.has("result")) {
				JSONObject resultObj = res.getJSONArray("result").getJSONObject(0);
				// �û�id
				String uid = resultObj.getString("uid");
				// System.out.println("=====uid====="+uid.substring(5));
				int u_id = Integer.parseInt(uid.substring(5));
				// ���ƶ�����
				double scores = resultObj.getJSONArray("scores").getDouble(0);
				// ��id
				String group_id = resultObj.getString("group_id");
				// �û���Ϣ
				String user_info = resultObj.getString("user_info");

				System.out.println("�û�id��" + uid + "\n���ƶ����֣�" + scores + "\n��id��" + group_id + "\n�û���Ϣ" + user_info);

				IFaceService faceService = new FaceServiceImpl();
				User user = null;

				if (scores >= 80) {
					System.out.println("==============����80============");
					// ��������80�֣����ж����ݿ����Ƿ��ж�Ӧ���û�
					user = faceService.findByIdAndName(u_id, user_info);
					if (user != null) {
						// ��¼�ɹ�
						System.out.println("============���ݿ���ƥ���û�================");
						request.getSession().setAttribute("user", user);
						out.println(true);
					}

				} else {
					// ��¼ʧ��
					System.out.println("��¼ʧ��");
					out.println(false);
				}
			}

		} else if ("facesetAddUser".equals(type)) {
			// ����ע�ᣨע��ҳ��ûд��
			System.out.println("=======facesetAddUser========");
			res = facesetAddUser(filePath);
		}

		/*
		 * // ���ٶȷ��ؽ������ҳ�� PrintWriter out = response.getWriter();
		 * out.print(res); out.flush(); out.close();
		 */
	}

	/**
	 * ����ͼƬ
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

		// 64λ����
		byte[] buffer = base64.decodeBuffer(map.get("imageData"));

		// д���ļ�
		String filePath = "images/" + new Date().getTime() + "" + new Random().nextInt(100000) + ".png";
		// �����ȡ·���ķ������ܻ���������Ĳ�ͬ����ȡ������ȷ��·��
		// filePath = this.getServletContext().getRealPath("/"+filePath);

		// ��ȡ��classesĿ¼��ȫ·��
		String classesPath = this.getClass().getClassLoader().getResource("/").getPath();
		// �Ȼ�ȡclasses��·������ʹ���ַ�����ȡ��ƴ�ӣ��õ�Tomcat����Ŀ�µ�images����·��
		filePath = classesPath.substring(1, classesPath.indexOf("WEB-INF")) + filePath;
		System.out.println("======ͼƬ���·��======" + filePath);

		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(buffer);
		fos.flush();
		fos.close();
		fos = null;
		return filePath;
	}

	/**
	 * ����ע��
	 * 
	 * @param filePath
	 *            -- ͼƬ·��
	 * @return
	 */
	private JSONObject facesetAddUser(String filePath) {
		// ��ʼ��һ��FaceClient
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
		// ��ѡ�������������Ӳ���
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// �û�ID
		String user_ID = "User_1001";
		// �û���Ϣ
		String user_info = "���[��";
		// Ҫ���û��������ID���ɽ�һ���û��������飩
		List<String> groupList = new ArrayList<>();
		groupList.add("group_01");

		//
		HashMap<String, String> options = new HashMap<String, String>();
		// | ���� |�Ƿ��ѡ | ���� | ˵�� |
		// | action_type | �� | string| ��������append��replace
		// ���Ϊ��replace������ÿ��ע��ʱ�����滻replace����������£�������Ĭ��Ϊappend����
		options.put("action_type", "append");

		// ������"uid1", "test_user_info", Arrays.asList("group1", "group2"),
		// path,options
		JSONObject res = client.addUser(user_ID, user_info, groupList, filePath, options);
		return res;
	}

}
