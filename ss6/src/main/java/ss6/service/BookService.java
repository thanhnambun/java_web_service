package ss6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss6.entity.Book;
import ss6.reopo.BookRepository;

import java.util.List;

@Service
public class BookService  {
    @Autowired
    private BookRepository bookRepository;
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
    public Book updateBook(Book book, Integer id) {
        Book updatedBook = bookRepository.findById(id).orElse(null);
        updatedBook.setId(book.getId());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPrice(book.getPrice());
        return bookRepository.save(book);
    }
}
