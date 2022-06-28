package program.ung_dung_muon_sach.service;

import program.ung_dung_muon_sach.model.Detail;

import java.util.List;

public interface IDetailService {

    List<Detail> getAllDetailByBookId(Integer bookId);

    void updateRentStatus(Detail detail);

    Detail getDetailBookById(Integer id);

    List<Detail> getAllDetail();
}
