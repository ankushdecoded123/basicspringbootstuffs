package com.experiment.redis.service;

import org.springframework.http.ResponseEntity;

import com.experiment.redis.dto.SongDetails;
import com.experiment.redis.entities.Songs;

public interface SongsService {

	ResponseEntity<String> addSongs(SongDetails songDetails);
	
	ResponseEntity<Songs> findBySongName(String songName);
	
	ResponseEntity<Iterable<Songs>> getAll();
	
	ResponseEntity<String> updateSongDetails(SongDetails songDetails);
	
	ResponseEntity<String> deleteSong(String id);
	
	ResponseEntity<Songs> findBySongNameAndAlbum(String songName, String album);
}
