package edu.cugb.xg.javaee.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Upload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// �ж��ύ���������Ƿ�Ϊmultipart/form-data
				if (!upload.isMultipartContent(request)) {
					return;
				}
				List list;
				try {
					list = upload.parseRequest(request);

					Iterator it = list.iterator();

					while (it.hasNext()) {
						FileItem item = (FileItem) it.next();// ÿһ��item�ʹ���һ���������

						if (item.isFormField()) {// �ж�input�Ƿ�Ϊ��ͨ��������

							String name = item.getFieldName();// input������

							String value = item.getString();// input��ֵ
						} else {// �ж�input�Ƿ�Ϊ�ļ���������

							// �õ��ϴ��ļ�������,����ȡ
							String filename = item.getName();
							int index = filename.lastIndexOf(File.separator);
							if(index >0){
								filename = filename.substring(index+1,filename.length());
							}
							// �õ��ϴ��ļ�Ҫд���Ŀ¼
							String filedir = this.getServletContext().getRealPath("/upload");
							// ����Ŀ¼���ļ����������
							//filename = path + "\";
							StringBuffer path = new StringBuffer();
							path.append(filedir);
							path.append("\\");	
							path.append(filename);
							FileOutputStream out = new FileOutputStream(path.toString());

							InputStream in = item.getInputStream();
							byte buffer[] = new byte[1024];
							int len = 0;
							while ((len = in.read(buffer)) > 0) {
								out.write(buffer, 0, len);
							}
							in.close();
							out.close();
						}
					}

				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
