package program.service;

import program.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAll();
    Music findMusicById(Integer id);
    void create(Music music);
    void delete(Integer id);
    void update(Music music);
}
