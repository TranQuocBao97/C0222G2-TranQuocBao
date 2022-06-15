package repository.interface_customer_repository;

import model.TotalPrice;

import java.util.List;

public interface ITotalPriceRepository {
    List<TotalPrice> getListTotalPrice();
}
