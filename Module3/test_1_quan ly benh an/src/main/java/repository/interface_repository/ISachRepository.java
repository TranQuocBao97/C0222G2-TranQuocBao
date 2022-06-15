package repository.interface_repository;

import modal.Sach;
import modal.TheMuonSach;

import java.util.List;

public interface ISachRepository {

    List<Sach> getAllSach();

    void updateTruSoLuongSach(String sachId);
}
