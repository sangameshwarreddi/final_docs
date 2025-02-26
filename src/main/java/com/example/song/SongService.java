
package com.example.song;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(playlist.values());
    }

    @Override
    public Song save(Song newSong) {
        int nextId = playlist.size() + 1;
        newSong.setSongId(nextId);
        playlist.put(nextId, newSong);
        return newSong;
    }

    @Override
    public Song findById(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found");
        }
        return song;
    }

    @Override
    public Song update(int songId, Song updatedSong) {
        Song existingSong = playlist.get(songId);
        if (existingSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found");
        }
        if (updatedSong.getSongName() != null) {
            existingSong.setSongName(updatedSong.getSongName());
        }
        if (updatedSong.getLyricist() != null) {
            existingSong.setLyricist(updatedSong.getLyricist());
        }
        if (updatedSong.getSinger() != null) {
            existingSong.setSinger(updatedSong.getSinger());
        }
        if (updatedSong.getMusicDirector() != null) {
            existingSong.setMusicDirector(updatedSong.getMusicDirector());
        }
        return existingSong;
    }

    @Override
    public void delete(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found");
        }
        playlist.remove(songId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "");
    }
}
