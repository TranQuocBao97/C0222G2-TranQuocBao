package repository.interface_repository;

import connection.ConnectionSQL;
import model.Land;

import java.util.List;
import java.util.Map;

public interface ILandRepository {
    List<Land> getLandList();

    boolean insertLand(Land land);
}
