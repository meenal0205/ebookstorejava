package com.ebookstoreProject.ebookstore.controller;


import com.ebookstoreProject.ebookstore.entity.BookEntity;
import com.ebookstoreProject.ebookstore.model.Book;
import com.ebookstoreProject.ebookstore.model.User;
import com.ebookstoreProject.ebookstore.services.BookService;
import com.ebookstoreProject.ebookstore.services.UserService;
import jakarta.persistence.Index;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:3000/")
public class   combinedController {
    private final BookService bookService;
    private final UserService userService;
    public combinedController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService=userService;
    }

    @PutMapping("/addtocart/{id1}/{id2}")
    public ResponseEntity<User> AddToCart(@PathVariable("id1") Integer id1,
                                          @PathVariable("id2") Integer id2
                                          ){
        User user=userService.getUserById(id1);
        user=userService.updateBasket(id1,id2,user);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/increase/{id1}/{id2}")
    public ResponseEntity<User> Increase(@PathVariable("id1") Integer id1,
                                         @PathVariable("id2") Integer id2){
        User user = userService.getUserById(id1);
        user=userService.addquantity(id1,id2,user);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/decrease/{id1}/{id2}")
    public ResponseEntity<User> decrease(@PathVariable("id1") Integer id1,
                                         @PathVariable("id2") Integer id2){
        User user = userService.getUserById(id1);
        user=userService.reducequantity(id1,id2,user);
        return ResponseEntity.ok(user);
    }
    @PutMapping("purchaseItem/{id2}/{amount}")
    public String PurchaseProduct(
                                  @PathVariable("id2") Integer id2,
                                  @PathVariable("amount") Integer amount){
        Book book=bookService.getBookEntityById(id2);
        Integer response=bookService.purchaseBook(id2,book,amount);
        if(response==-1){
            return "Out of Stock";
        }
        else{
            return "Cost of Book "+book.getPrice()*amount+"Rs" +" Thank you for Purchasing";
        }
    }
    @PutMapping("PurchaseCart/{id1}")
    public String PurchaseCart(@PathVariable int id1){
        User user=userService.getUserById(id1);
        HashMap<Integer,Integer> basket=user.getBasket();
        int amount=0;
        int flag=1;
        int ind=-1;
        for(Integer id: basket.keySet()) {
            Book book=bookService.getBookEntityById(id);

            if(book.getStock()<basket.get(id)){
                flag=-1;
                ind=id;
                break;
            }

        }
        if(flag==-1){
            return "Book "+bookService.getBookEntityById(ind).getName()+"Can not be purchased as it is out of stock";
        }
        else{
            for(Integer id: basket.keySet()) {
                Book book=bookService.getBookEntityById(id);
                    amount+=book.getPrice()*basket.get(id);
                    book.setStock(book.getStock()-basket.get(id));
            }
            user.getBasket().clear();
            userService.updateUser(id1,user);
            return "Thank you for purchasing your total is "+amount;
        }
    }









}
