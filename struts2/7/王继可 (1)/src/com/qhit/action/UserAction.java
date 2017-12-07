package com.qhit.action;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.bean.User;
import com.qhit.service.UserService;

public class UserAction  extends ActionSupport{
	private String username;
	private File uploadFile;	//��ҳ��file�ļ�������һ��
	private String uploadFileFileName;	//file�ļ�����+FileName
	private String uploadFileContentType;	//�ϴ��ļ�mime���ͣ�file�ļ�����+ContentType
	private String fileName;
	private InputStream fileName_is;
	
	private UserService ss=new UserService();
	public String upload(){
		if(uploadFile!=null){
			System.out.println("�û�����"+username);
			System.out.println("�ļ�����"+uploadFileFileName);
			System.out.println("�ļ���С��"+uploadFile.length());
			System.out.println("�ļ�mime��"+uploadFileContentType);
		
			try {
				InputStream is = new FileInputStream(uploadFile);
				String path = ServletActionContext.getServletContext().getRealPath("/upload");
				File filePath = new File(path);
				
				if(!filePath.exists()){	//���Ŀ¼������
					filePath.mkdir();	//�����ϴ��ļ���
				}
				String fileName = path+"/"+uploadFileFileName;	//�ϴ��ļ���ȫ��������������ŵĵ�ַ��
				User user = new User(uploadFileFileName,fileName);
				int count=ss.add(user);
				OutputStream os=null;
				if(count>0){
			       os = new FileOutputStream(fileName);	//���������
				byte[] bs = new byte[1024];
				int n = 0;
				while((n = is.read(bs))!=-1){
					os.write(bs, 0, n);
				}
				}
				os.close();
				is.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	public String download(){
		if(fileName!=null){
			String path = ServletActionContext.getServletContext().getRealPath("/upload");
			String filePath = path+"/"+fileName;
			try {
				fileName_is = new FileInputStream(filePath);
				return "download";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileName_is(InputStream fileName_is) {
		this.fileName_is = fileName_is;
	}
	public String getFileName() {
		return fileName;
	}
	public InputStream getFileName_is() {
		return fileName_is;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
		}

