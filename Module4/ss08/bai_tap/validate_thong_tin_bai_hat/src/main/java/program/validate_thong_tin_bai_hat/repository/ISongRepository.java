package program.validate_thong_tin_bai_hat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.validate_thong_tin_bai_hat.model.Song;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {

    @Query(value = " SELECT * FROM song ",nativeQuery = true)
    List<Song> getAllSong();

    Song save(Song song);

    @Query(value = " SELECT * FROM Song WHERE id= :idToFind ",nativeQuery = true)
    Song findSongById(@Param("idToFind") Integer id);
}
