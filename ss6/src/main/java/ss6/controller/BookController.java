package ss6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss6.entity.Book;
import ss6.entity.DataResponse;
import ss6.service.BookService;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<Book>>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok().body(new DataResponse<>(books, HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<DataResponse<Book>> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(new DataResponse<>(bookService.save(book),HttpStatus.ACCEPTED), HttpStatus.CREATED);
    }
    @PutMapping("/{bookId}")
    public ResponseEntity<DataResponse<Book>> updateBook(@RequestBody Book book,@PathVariable Integer bookId) {
        return new ResponseEntity<>(new DataResponse<>(bookService.updateBook(book,bookId),HttpStatus.OK), HttpStatus.OK);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }
}
