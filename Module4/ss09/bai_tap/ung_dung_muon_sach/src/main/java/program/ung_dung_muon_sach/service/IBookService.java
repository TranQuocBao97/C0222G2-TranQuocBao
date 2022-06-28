package program.ung_dung_muon_sach.service;

import program.ung_dung_muon_sach.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBook();

    Book getBookById(Integer id);
}
