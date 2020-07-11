package com.experiment.redis.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "Songs")
public class Songs implements Serializable{

	private static final long serialVersionUID = -1147248554856571501L;

	@Id
	private String songId;
	
	@Indexed
	private String name;
	
	private List<String> artists;
	
	@Indexed
	private String album;
	
	private String genre;

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

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

	public Songs(String songId, String name, List<String> artists, String album, String genre) {
		super();
		this.songId = songId;
		this.name = name;
		this.artists = artists;
		this.album = album;
		this.genre = genre;
	}

	public Songs() {
		super();
	}

	@Override
	public String toString() {
		return "Songs [songId=" + songId + ", name=" + name + ", artists=" + artists + ", album=" + album + ", genre="
				+ genre + "]";
	}

	
}
