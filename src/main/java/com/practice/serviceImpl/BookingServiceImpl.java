package com.practice.serviceImpl;

import com.practice.entity.Booking;
import com.practice.repository.BookingRepository;
import com.practice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public String saveBooking(Booking booking) {
        bookingRepository.save(booking);
        return "Booking Data Saved Successfully";
    }

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> bookingList = bookingRepository.findAll();
        return bookingList;
    }

    @Override
    public Booking getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()->new NullPointerException("Booking for id does not found"+id));
        return booking;
    }

    @Override
    public String deleteBookingById(int id) {
        bookingRepository.deleteById(id);
        return "Booking deleted successfully";
    }

    @Override
    public Booking upadateBookingById(int id, Booking newBooking) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()->new NullPointerException("Updated Booking in db does not found with id "+id));
        System.err.println("Old Booking from db"+booking);
        System.err.println("Booking object with value to be updated"+newBooking);

        booking.setMovieName(newBooking.getMovieName());
        booking.setCustomerName(newBooking.getCustomerName());
        booking.setSeatsBooked(newBooking.getSeatsBooked());
        booking.setShowTime(newBooking.getShowTime());


        Booking updateBooking = bookingRepository.save(booking);
        System.err.println("Booking with updated value"+updateBooking);
        return updateBooking ;
    }

    @Override
    public List<Booking> saveListOfBooking(List<Booking> bookingList) {
        bookingRepository.saveAll(bookingList);
        return bookingList;
    }
}
