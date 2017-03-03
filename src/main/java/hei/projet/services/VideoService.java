package hei.projet.services;

import hei.projet.dao.impl.VideoDaoImpl;
import hei.projet.entities.Video;


public class VideoService {

private VideoDaoImpl videoDao = new VideoDaoImpl();
	
	private static class VideoServiceHolder{
		private static VideoService instance = new VideoService();
	}
	
	public static VideoService getInstance(){
		return VideoServiceHolder.instance;
	}
	
	private VideoService(){
		
	}

	
	
	public void addVideo(Video video){
		videoDao.addVideo(video);
	}
	
	

}
