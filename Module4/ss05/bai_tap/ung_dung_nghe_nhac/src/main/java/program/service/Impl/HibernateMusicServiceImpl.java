package program.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Music;
import program.repository.IMusicRepository;
import program.service.IMusicService;

import java.util.List;


@Service
public class HibernateMusicServiceImpl implements IMusicService {

    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> getAll() {
        return iMusicRepository.getAll();
    }

    @Override
    public Music findMusicById(Integer id) {
        return iMusicRepository.getMusicById(id);
    }

    @Override
    public void create(Music music) {
        iMusicRepository.create(music);
    }

    @Override
    public void delete(Integer id) {
        iMusicRepository.delete(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }
}
