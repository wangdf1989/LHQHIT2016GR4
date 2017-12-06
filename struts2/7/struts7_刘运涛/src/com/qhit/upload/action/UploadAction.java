package com.qhit.upload.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.upload.bean.Song;
import com.qhit.upload.service.SongsService;

public class UploadAction extends ActionSupport {
     private SongsService ss=new SongsService();
     private String songName;
     private int sid;
     private File uploadFile;
     private String uploadFileFileName;
     private String uploadFileContentType;
     private Song song;
     private List<Song> list;
     private InputStream fileName_is;
     private String fileName;
     /**
      * 文件上传
      * @return
      */
     public String upload(){
       if(uploadFile!=null){
		  try {
		    //执行添加方法
		    song=new Song(songName,uploadFileFileName);
		    int count=ss.add(song);
		    if(count==1){
		        //根据歌曲名字进行查询 	
		    	Song s_song=ss.selPathForName(songName);
		    	if(s_song!=null){
	    		  //从查出来的对象里边取数据
	    		  int s_sid=s_song.getSid();
	    		  String s_name=s_song.getName();
	    		  String s_path=s_sid+"."+s_song.getPath();
	    		  InputStream fis=new FileInputStream(uploadFile);
	  		      String path=ServletActionContext.getServletContext().getRealPath("/upload");
	  		      File filePath=new File(path);
	  		      if(!filePath.exists()){
	  			     filePath.mkdir();
	  		      }
	    	      //进行上传
	    		  //s_song.getPath()==uploadFileFileName
	    		  String fileName=path+"/"+s_sid+"."+uploadFileFileName;
	 		      OutputStream fos=new FileOutputStream(fileName);
	 		      byte[] bs=new byte[1024];
	 		      int i=0;
	 		      while((i=fis.read(bs))!=-1){
	 		    	  fos.write(bs, 0, i);
	 		      }
	 		       fos.close();
	 		       fis.close();
	 		      //更新歌曲的路径
	 		      Song u_song=new Song(s_sid, s_name, s_path); 
	 		      int u_count=ss.upd(u_song); 
	 		      if(u_count==1){
	 		    	  list=ss.selAllSong();
	 		    	  return SUCCESS;
	 		      }
		    	}
		    }  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
          addActionError("服务器中断,请稍后再试");
          return INPUT; 
     }
     //文件下载
     public String downLoad(){
    	  if(sid!=0){
    		  //查询文件路径
    		  Song s_song=ss.selPathForId(sid);
    		  String s_path=ServletActionContext.getServletContext().getRealPath("/upload");
    		  String filename=s_song.getPath();
    		  String d_path=s_path+"/"+filename;
    		  try {
				 fileName_is=new FileInputStream(d_path);
				 return "download";
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	  }
    	  return SUCCESS;
    }   
   
	public void setSid(int sid) {
		this.sid = sid;
	}
	public InputStream getFileName_is() {
		return fileName_is;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public String getFileName() {
		return fileName;
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
	public List<Song> getList() {
		return list;
	}   
}
