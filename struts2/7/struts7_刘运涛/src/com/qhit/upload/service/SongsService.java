package com.qhit.upload.service;

import java.util.List;

import com.qhit.upload.bean.Song;
import com.qhit.upload.dao.SongsDao;

public class SongsService {
     private SongsDao sd=new SongsDao();
     /**
      * 添加歌曲
      */
     public int add(Song song){
    	  return sd.addSong(song);
     } 
     /**
      * 更新歌曲 
      */
     public int upd(Song song){
    	  return sd.updSongs(song); 
     }
     /**
      * 根据歌曲名字查询路径 
      */
     public Song selPathForName(String name){
    	  return sd.selPathForName(name);
     } /**
      * 根据Id字查询路径 
      */
     public Song selPathForId(int sid){
    	  return sd.selPathForId(sid);
     }
     /**
      * 查询所有
      */
     public List<Song> selAllSong(){
    	  return sd.selAllSong();
     }
}
