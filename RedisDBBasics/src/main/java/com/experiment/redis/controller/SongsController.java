package com.experiment.redis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.redis.dto.SongDetails;
import com.experiment.redis.entities.Songs;
import com.experiment.redis.service.SongsService;

@RestController
@RequestMapping(value = "/song")
public class SongsController {

	@Autowired
	private SongsService songService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addSong(@Valid @RequestBody SongDetails songObject)
	{
		return songService.addSongs(songObject);
	}
	
	@GetMapping(value = "/get-details")
	public ResponseEntity<Songs> getSongDetails(@RequestParam String songName)
	{
		return songService.findBySongName(songName);
	}
	
	@GetMapping(value = "/get-all")
	public ResponseEntity<Iterable<Songs>> getAllSongsDetails()
	{
		return songService.getAll();
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteSong(@RequestParam String id)
	{
		return songService.deleteSong(id);
	}
	
	@GetMapping(value = "/get-details-by-album")
	public ResponseEntity<Songs> getSongDetailsByAlbum(@RequestParam String songName, @RequestParam String album)
	{
		return songService.findBySongNameAndAlbum(songName, album);
	}
}
