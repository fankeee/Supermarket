package com.glut.supermarket.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * �ļ��ϴ�����
 * 
 * @author Fk
 *
 */
public class UploadUtil {
	private static final String PATH = "images"; // ����ͼƬ��·��
	private static final String ALLOWED = "gif,jpg,png,jpeg"; // �����ϴ����ļ���ʽ
	private static final String DENIED = "exe,bat,jsp,html,com"; // �������ϴ����ļ���ʽ
	private static final int TOTALMAXSIZE = 20 * 1024 * 1024; // ���ļ���С
	private static final int SINGLEFILESIZE = 1024 * 1024; // �����ļ���С

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, String> update(PageContext context)
			throws SmartUploadException, IOException, ServletException, SQLException {

		Map<String, String> params = new HashMap<String, String>();

		SmartUpload su = new SmartUpload();
		su.initialize(context); // ��ʼ��

		// ���ò���
		su.setMaxFileSize(SINGLEFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWED);
		su.setDeniedFilesList(DENIED);
		su.setCharset("utf-8");

		su.upload(); // ��ʼ�ϴ�

		// ��ȡ�����е���Ϣ
		Request request = su.getRequest();

		Enumeration et = request.getParameterNames();
		String str;

		while (et.hasMoreElements()) { // �����е���ͨ��Ԫ����Ϣ
			str = String.valueOf(et.nextElement());
			params.put(str, request.getParameter(str));
		}

		Files fls = su.getFiles();
		String fileName; // �ļ���
		String picPath = "";
		if (fls != null && fls.getCount() > 0) { // ˵�����ļ�
			Collection<File> cols = fls.getCollection();
			for (File fl : cols) {
				if (!fl.isMissing()) { // �ж��ϴ����ļ���û�ж�ʧ����
					fileName = PATH + "/" + new Date().getTime() + "" + new Random().nextInt(100000) + "."
							+ fl.getFileExt(); // ��ȡ��չ��

					// ��ͼƬд�������
					fl.saveAs(fileName, SmartUpload.SAVE_VIRTUAL);
					picPath += fileName + ",";
				}
			}
			picPath = picPath.substring(0, picPath.lastIndexOf(","));
			params.put("photo", picPath); // �����ݿ���ͼƬ·����Ϣ
		}
		return params;
	}
}
