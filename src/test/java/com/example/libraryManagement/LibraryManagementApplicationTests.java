
package com.example.libraryManagement;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Users;
import com.example.libraryManagement.repository.UserRepository;
import com.example.libraryManagement.services.BorrowRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class libraryManagementApplicationApplicationTests {
    @Autowired
    private BorrowRecordService borrowRecordService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testBorrowRecordList(){
        System.out.println(">>> Running testBorrowRecordList...");
        Users users = userRepository.findById(2L).orElseThrow();
        List<BorrowRecord> records = users.getBorrowRecords();
        System.out.println("Records count = " + records.size());


        System.out.println("Borrowed books:");
        records.forEach(r -> System.out.println(r.getBook().getTitle()));
    }
}

