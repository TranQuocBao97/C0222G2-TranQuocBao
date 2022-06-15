package repository.interface_repository;

import modal.TheMuonSach;

import java.util.List;

public interface ITheMuonSachRepository {
    List<TheMuonSach> getListTheMuonSach();
    boolean addTheMuonSach(TheMuonSach theMuonSach);
}
