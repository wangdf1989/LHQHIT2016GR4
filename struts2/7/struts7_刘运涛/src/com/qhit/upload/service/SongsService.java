package com.qhit.upload.service;

import java.util.List;

import com.qhit.upload.bean.Song;
import com.qhit.upload.dao.SongsDao;

public class SongsService {
     private SongsDao sd=new SongsDao();
     /**
      * ��Ӹ���
      */
     public int add(Song song){
    	  return sd.addSong(song);
     } 
     /**
      * ���¸��� 
      */
     public int upd(Song song){
    	  return sd.updSongs(song); 
     }
     /**
      * ���ݸ������ֲ�ѯ·�� 
      */
     public Song selPathForName(String name){
    	  return sd.selPathForName(name);
     } /**
      * ����Id�ֲ�ѯ·�� 
      */
     public Song selPathForId(int sid){
    	  return sd.selPathForId(sid);
     }
     /**
      * ��ѯ����
      */
     public List<Song> selAllSong(){
    	  return sd.selAllSong();
     }
}
