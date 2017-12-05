package zk.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import zk.com.bean.Music;
import zk.com.service.MusicService;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private MusicService ms = new MusicService();
 private String username;
 private File uploadFile;
 private String uploadFileFileName;
 private String uploadFileContentType;
 private Music music;
 private String fileName;
 private InputStream filename_is;
 
 public String upload(){
     if(uploadFile!=null){
    	 try {
			InputStream is = new FileInputStream(uploadFile);
			String path = ServletActionContext.getServletContext().getRealPath("/upload");
			File filepath = new File(path);
			if(!filepath.exists()){
				filepath.mkdir();
			}
			String fileName=path+"/"+uploadFileFileName;
			OutputStream os = new FileOutputStream(fileName);
			byte[] bs = new byte[1024];
			int n = 0;
			while((n=is.read(bs))!=-1){
				os.write(bs, 0,n);
			}
			music = new Music();
			music.setName(uploadFileFileName);
			music.setUpload(fileName);
			int count = ms.add(music);
            if(count==0){
            	return INPUT;
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
		 String filepath=path+"/"+fileName;
		 try {
			filename_is = new FileInputStream(filepath);
			return "down";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 return SUCCESS;
 }

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public File getUploadFile() {
	return uploadFile;
}

public void setUploadFile(File uploadFile) {
	this.uploadFile = uploadFile;
}

public String getUploadFileFileName() {
	return uploadFileFileName;
}

public void setUploadFileFileName(String uploadFileFileName) {
	this.uploadFileFileName = uploadFileFileName;
}

public String getUploadFileContentType() {
	return uploadFileContentType;
}

public void setUploadFileContentType(String uploadFileContentType) {
	this.uploadFileContentType = uploadFileContentType;
}

public Music getMusic() {
	return music;
}

public void setMusic(Music music) {
	this.music = music;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}
public InputStream getFilename_is() {
	return filename_is;
}
public void setFilename_is(InputStream filename_is) {
	this.filename_is = filename_is;
}
 
 
 
 
}
