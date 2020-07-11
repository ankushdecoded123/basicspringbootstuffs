package com.experiment.redis.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SongDetails {

	@NotEmpty(message = "Song's name can't be null or blank")
	private String name;

	@NotNull(message = "Must be atleast one artist")
	private List<String> artists;

	@NotEmpty(message = "Album name is mandatory")
	private String album;
	
	@NotEmpty(message = "Mention the genre")
	private String genre;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
