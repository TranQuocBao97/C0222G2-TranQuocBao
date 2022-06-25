package program.validate_thong_tin_bai_hat.service;


import program.validate_thong_tin_bai_hat.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAllSong();
    void addNewSong(Song song);

    Song getSongById(Integer id);
}
