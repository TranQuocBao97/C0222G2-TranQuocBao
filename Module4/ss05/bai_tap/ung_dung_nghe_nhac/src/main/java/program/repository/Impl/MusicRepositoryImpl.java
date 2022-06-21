package program.repository.Impl;

import org.springframework.stereotype.Repository;
import program.model.Music;
import program.repository.BaseRepository;
import program.repository.IMusicRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class MusicRepositoryImpl implements IMusicRepository {

    @Override
    public List<Music> getAll() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery("select s from Music s", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void create(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music getMusicById(Integer id) {
        return BaseRepository.entityManager.find(Music.class,id);
    }

    @Override
    public void delete(Integer id) {
        Music music = getMusicById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public void update(Music music) {
        BaseRepository.entityManager.merge(music);
    }
}
