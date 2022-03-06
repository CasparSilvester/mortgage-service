package com.example.mortgageservice.controller;
import com.example.mortgageservice.model.Book;
import com.example.mortgageservice.model.MortgageCheckData;
import com.example.mortgageservice.model.MortgageCheckResult;
import com.example.mortgageservice.model.MortgageRate;
import com.example.mortgageservice.service.BookService;
import com.example.mortgageservice.service.MortgageCheckDataService;
import com.example.mortgageservice.service.MortgageRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
public class MortgageController {
    @Autowired
    BookService bookService;
    @Autowired
    MortgageRateService mortgageRateService;
    @Autowired
    MortgageCheckDataService mortgageCheckDataService;


    Logger logger = LoggerFactory.getLogger(MortgageController.class);

    @GetMapping("/get-books")
    private List<Book> getAllBooks(){
        logger.info("retrieving list of all books");
        return bookService.list();
    }

    @GetMapping("/interest-rates")
    private List<MortgageRate> getAllMortgageRates(){
        logger.info("retrieving list of all interest rates");
        return mortgageRateService.list();
    }

    @PostMapping("/post-book")
    private long postBook(@RequestBody Book book){
        logger.info("posting a book");
        bookService.saveBook(book);
        return book.getId();
    }

    @PostMapping("/mortgage-check")
    private MortgageCheckResult checkMortgage(@RequestBody MortgageCheckData mortgageCheckData){
        logger.info("received POST at:\t/mortgage-check");
        return mortgageCheckDataService.saveMortgageCheckData(mortgageCheckData);
    }
}
