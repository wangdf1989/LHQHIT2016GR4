package zk.com.service;

import zk.com.bean.Music;
import zk.com.dao.MusicDao;

public class MusicService {
private MusicDao md = new MusicDao();
public int add(Music music){
	return md.addmusic(music);
}
}
