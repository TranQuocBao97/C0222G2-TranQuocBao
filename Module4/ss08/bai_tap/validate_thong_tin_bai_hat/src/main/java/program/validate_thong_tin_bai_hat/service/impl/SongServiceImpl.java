package program.validate_thong_tin_bai_hat.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.validate_thong_tin_bai_hat.model.Song;
import program.validate_thong_tin_bai_hat.repository.ISongRepository;
import program.validate_thong_tin_bai_hat.service.ISongService;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    ISongRepository iSongRepository;

    @Override
    public List<Song> getAllSong() {
        return iSongRepository.getAllSong();
    }

    @Override
    public void addNewSong(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song getSongById(Integer id) {
        return iSongRepository.findSongById(id);
    }


}
