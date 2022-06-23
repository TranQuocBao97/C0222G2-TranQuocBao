package program.quan_ly_khach_hang_phan_trang_tim_kiem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Province;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.repository.IProvinceRepository;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.service.IProvinceService;

import java.util.List;


@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> getAllProvince() {
        return iProvinceRepository.selectAllProvince();
    }
}
