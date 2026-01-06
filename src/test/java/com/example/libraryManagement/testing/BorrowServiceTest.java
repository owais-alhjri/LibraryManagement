

package com.example.libraryManagement.testing;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Users;
import com.example.libraryManagement.repository.BookRepository;
import com.example.libraryManagement.repository.UserRepository;
import com.example.libraryManagement.services.BorrowRecordService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class BorrowServiceTest {
    /*
    @Autowired
    private BorrowRecordService borrowRecordService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testBorrowRecordList(){
        System.out.println(">>> Running testBorrowRecordList...");
        Users users = userRepository.findById(1L).orElseThrow();
        List<BorrowRecord> records = users.getBorrowRecords();
        System.out.println("Records count = " + records.size());

        System.out.println("Book by author");
        //List<Book> book = bookRepository.findByAuthorOrTitle("Robert C. owais","");
        //List<Book> books = book;
        //books.forEach(b ->System.out.println(b.getTitle()));


        System.out.println("Borrowed books:");
        records.forEach(r -> System.out.println(r.getBook().getAuthor()));
    }

     */
}

