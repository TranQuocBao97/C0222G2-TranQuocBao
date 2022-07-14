package program.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.app.model.Room;

public interface IRoomRepository extends JpaRepository<Room,Integer> {
}
