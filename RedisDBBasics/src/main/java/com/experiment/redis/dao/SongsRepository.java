package com.experiment.redis.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.experiment.redis.entities.Songs;

public interface SongsRepository extends CrudRepository<Songs, String>{

	Optional<Songs> findByName(String name);
	
	Optional<Songs> findByNameAndAlbum(String name, String album);
}
