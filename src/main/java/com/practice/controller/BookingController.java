package com.practice.controller;

import com.practice.entity.Booking;
import com.practice.repository.BookingRepository;
import com.practice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> addData(@RequestBody Booking booking){
        bookingService.saveBooking(booking);
        return new ResponseEntity<>("Booking Data Saved Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Booking>> getAllData(){
        List<Booking> bookingList = bookingService.getAllBooking();
        return  new ResponseEntity<>(bookingList,HttpStatus.OK);
    }

    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Booking> getDataById(@PathVariable("id") int id){
        Booking booking = bookingService.getBookingById(id);
        return new ResponseEntity<>(booking,HttpStatus.OK);
    }

    @DeleteMapping("/deleteDataById/{id}")
    public ResponseEntity<String> deleteBookingById(@PathVariable("id")int id){
        bookingService.deleteBookingById(id);
        return new ResponseEntity<>("Booking deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("/updateDataById/{id}")
    public ResponseEntity<Booking> updateBookingById(@PathVariable("id")int id, @RequestBody Booking booking){
        Booking updateBooking = bookingService.upadateBookingById(id,booking);
        return new ResponseEntity<>(updateBooking,HttpStatus.OK);
    }

    @PostMapping("/addListOfData")
    public ResponseEntity<List<Booking>> saveListOfBooking(@RequestBody List<Booking> bookingList){
        bookingService.saveListOfBooking(bookingList);
        return new ResponseEntity<>(bookingList,HttpStatus.CREATED);
    }
}
