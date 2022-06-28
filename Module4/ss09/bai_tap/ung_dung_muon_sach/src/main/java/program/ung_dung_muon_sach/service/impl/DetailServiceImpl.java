package program.ung_dung_muon_sach.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.ung_dung_muon_sach.model.Detail;
import program.ung_dung_muon_sach.repository.IDetailRepository;
import program.ung_dung_muon_sach.service.IDetailService;

import java.util.List;

@Service
public class DetailServiceImpl implements IDetailService {
    @Autowired
    IDetailRepository iDetailRepository;

    @Override
    public List<Detail> getAllDetailByBookId(Integer bookId) {
        return iDetailRepository.selectAllDetailByBookId(bookId);
    }

    @Override
    public void updateRentStatus(Detail detail) {
        iDetailRepository.save(detail);
    }

    @Override
    public Detail getDetailBookById(Integer id) {
        return iDetailRepository.selectDetailById(id);
    }

    @Override
    public List<Detail> getAllDetail() {
        return iDetailRepository.selectAllDetail();
    }


}
