package com.example.song;

import com.example.song.Song;
import com.example.song.SongService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//helloworld
@RestController
public class SongController {

    SongService songService = new SongService();

    // API 1: Get all songs
    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songService.findAll();
    }

    // API 2: Create a new song
    @PostMapping("/songs")
    public Song createSong(@RequestBody Song newSong) {
        return songService.save(newSong);
    }

    // API 3: Get song by songId
    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable int songId) {
        return songService.findById(songId);
    }

    // API 4: Update song details by songId
    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable int songId, @RequestBody Song updatedSong) {
        return songService.update(songId, updatedSong);
    }

    // API 5: Delete song by songId
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable int songId) {
        songService.delete(songId);
    }
}
