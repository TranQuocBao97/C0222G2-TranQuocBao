package program.ung_dung_muon_sach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import program.ung_dung_muon_sach.exception.RentBookException;
import program.ung_dung_muon_sach.exception.ReturnBookException;
import program.ung_dung_muon_sach.model.Book;
import program.ung_dung_muon_sach.model.Detail;
import program.ung_dung_muon_sach.service.IBookService;
import program.ung_dung_muon_sach.service.IDetailService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IDetailService iDetailService;

    @GetMapping("/book-list")
    public String displayListBook(Model model) {
        List<Book> bookList = iBookService.getAllBook();
        List<Detail> detailList = iDetailService.getAllDetail();
        for (Book book : bookList) {
            Integer available = 0;
            for (Detail detail : detailList) {
                if (book.getId().equals(detail.getBook().getId()) && detail.getStatus().equals(false)) {
                    available++;
                }
            }
            book.setAmount(available);
        }
        model.addAttribute("bookList", bookList);

        return "library";
    }

    @GetMapping("/detail-list/{bookId}")
    public String displayListBookDetail(@PathVariable("bookId") Integer bookId,
                                        Model model) {
        List<Detail> detailList = iDetailService.getAllDetailByBookId(bookId);
        model.addAttribute("detailList", detailList);

        return "list-book-detail";
    }

    @PostMapping("/rent/{detailId}")
    public String updateRentStatusDetail(@PathVariable("detailId") Integer detailId) throws RentBookException {
        Detail detail = iDetailService.getDetailBookById(detailId);
        if (!detail.getStatus().equals(false)) {
            throw new RentBookException();
        }
        detail.setStatus(true);
        iDetailService.updateRentStatus(detail);
        return "redirect:/book/book-list";
    }

    @GetMapping("/display-return/{bookId}")
    public String displayReturnPage(@PathVariable("bookId") Integer bookId,
                                    Model model) {
        Book book = iBookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "return";
    }

    @PostMapping("/return/{bookId}")
    public String returnBookDetail(@PathVariable("bookId") Integer bookId,
                                   @RequestParam Integer detailId) throws ReturnBookException {
        List<Detail> detailList = iDetailService.getAllDetail();
        for (Detail detail : detailList) {
            if (detail.getBook().getId().equals(bookId) && detail.getId().equals(detailId) && detail.getStatus().equals(true)) {
                detail.setStatus(false);
                iDetailService.updateRentStatus(detail);
                return "redirect:/book/book-list";
            }
        }
        throw new ReturnBookException();

    }

    @ExceptionHandler(Exception.class)
    public String goError() {
        return "error";
    }

    @ExceptionHandler(RentBookException.class)
    public String rentError(){
        return "error-rent";
    }

    @ExceptionHandler(ReturnBookException.class)
    public String returnError(){
        return "error-return";
    }

}
