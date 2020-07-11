package com.experiment.redis.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.experiment.redis.dao.SongsRepository;
import com.experiment.redis.dto.SongDetails;
import com.experiment.redis.entities.Songs;
import com.experiment.redis.service.SongsService;

@Service("SongsService")
public class SongsImpl implements SongsService{
	
	@Autowired
	private SongsRepository songsRepo;

	@Override
	public ResponseEntity<String> addSongs(SongDetails songDetails) {
		try {
			songsRepo.save(new Songs(UUID.randomUUID().toString(), songDetails.getName(), 
					songDetails.getArtists(), songDetails.getAlbum(), songDetails.getGenre()));
			return new ResponseEntity<>("song added successfully",HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Songs> findBySongName(String songName) {
		try {
			Optional<Songs> getSongDetails = songsRepo.findByName(songName);
			if(getSongDetails.isPresent())
				return new ResponseEntity<>(getSongDetails.get(),HttpStatus.FOUND);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Iterable<Songs>> getAll() {
		try {
			return new ResponseEntity<>(songsRepo.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> updateSongDetails(SongDetails songDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteSong(String id) {
		try {
			songsRepo.deleteById(id);
			return new ResponseEntity<>("song deleted successfully",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Songs> findBySongNameAndAlbum(String songName, String album) {
		try {
			Optional<Songs> getSongDetails = songsRepo.findByNameAndAlbum(songName, album);
			if(getSongDetails.isPresent())
				return new ResponseEntity<>(getSongDetails.get(),HttpStatus.FOUND);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
