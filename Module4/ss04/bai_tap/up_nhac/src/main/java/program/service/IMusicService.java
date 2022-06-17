package program.service;

import program.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getListMusic();
    void addMusicToList(Music music);
    Music getDetailMusic(Integer id);
}
