package ra.edu.ss4.service;

import ra.edu.ss4.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
    List<Book> findByCategoryBookId(Long cateBookId);
}