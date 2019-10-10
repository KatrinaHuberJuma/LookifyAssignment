package com.kat.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kat.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	
	public List<Song> findAll();
	
	public List<Song> findByArtist(String Artist);
	
	public List<Song> findTop10ByOrderByRatingDesc();
	
	public Long deleteByTitleStartingWith(String search);
	
	public void deleteById(Long id);

}
