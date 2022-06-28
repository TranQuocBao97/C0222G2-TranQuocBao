package program.ung_dung_muon_sach.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.ung_dung_muon_sach.model.Book;
import program.ung_dung_muon_sach.repository.IBookRepository;
import program.ung_dung_muon_sach.service.IBookService;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> getAllBook() {
        return iBookRepository.selectAllBook();
    }

    @Override
    public Book getBookById(Integer id) {
        return iBookRepository.selectBookById(id);
    }


}
