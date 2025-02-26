package com.example.song;

import java.util.List;
import com.example.song.Song;

public interface SongRepository {

    List<Song> findAll(); // Fetch all songs

    Song findById(int songId); // Fetch a song by songId

    Song save(Song song); // Save a new song

    Song update(int songId, Song song); // Update song details

    void delete(int songId); // Delete a song by songId
}
