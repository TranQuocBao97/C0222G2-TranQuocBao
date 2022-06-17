package program.service;

import org.springframework.stereotype.Service;
import program.model.Music;

import java.util.ArrayList;
import java.util.List;


@Service
public class MusicServiceImpl implements IMusicService{

    static List<Music> musicList = new ArrayList<>();

    @Override
    public List<Music> getListMusic() {
        return musicList;
    }

    @Override
    public void addMusicToList(Music music) {
        musicList.add(music);
    }

    @Override
    public Music getDetailMusic(Integer id) {
        for (Music music : musicList){
            if(music.getId().equals(id)){
                return music;
            }
        }
        return null;
    }

}
