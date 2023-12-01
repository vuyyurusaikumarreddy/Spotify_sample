package com.example.Spotify_sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.Playlists;
import com.example.Spotify_sample.repositories.PlaylistsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MainController {
    
    @Autowired
    PlaylistsRepository playlistsRepository;

    @GetMapping("/playlists/genre/{genre_name}")
    public List<Playlists> getPlaylistsByGenre(@PathVariable String genre_name) {
        List<Playlists> playlists = playlistsRepository.findByGenre(genre_name);
        return playlists;
    
    }

    @GetMapping("/playlists/subgenre/{subgenre_name}")
    public JsonNode getPlaylistsBySubGenre(@PathVariable String subgenre_name) throws JsonMappingException, JsonProcessingException {
        List<Object> playlists = playlistsRepository.findBySubGenre(subgenre_name);
        List<String> jsonString = convertListToJson(playlists);
        System.out.println(jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(jsonString.get(0));
        return node;
    
    }

    private static List<String> convertListToJson(List<Object> objectList) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectList.stream()
                .map(myObject -> {
                    try {
                        return objectMapper.writeValueAsString(myObject);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace(); // Handle the exception based on your requirements
                        return null;
                    }
                })
                .toList();
    }

}