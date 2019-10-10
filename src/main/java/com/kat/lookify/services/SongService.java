package com.kat.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.lookify.models.Song;
import com.kat.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepo;
	
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	public Song createSong(Song s) {
		return songRepo.save(s);
	}
	
	public List<Song> topRated(){
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> findByArtist(String search){
		return songRepo.findByArtist(search);
	}
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	
}
