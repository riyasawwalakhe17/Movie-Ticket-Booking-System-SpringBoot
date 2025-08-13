package com.practice.service;

import com.practice.entity.Booking;

import java.util.List;

public interface BookingService {

    String saveBooking(Booking booking);

    List<Booking> getAllBooking();

    Booking getBookingById(int id);

    String deleteBookingById(int id);

    Booking upadateBookingById(int id, Booking newBooking);

    List<Booking> saveListOfBooking(List<Booking> bookingList);
}
