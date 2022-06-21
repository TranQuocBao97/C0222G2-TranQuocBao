package program.repository;

import program.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> getAll();
    void create(Music music);
    Music getMusicById(Integer id);
    void delete(Integer id);
    void update(Music music);
}
