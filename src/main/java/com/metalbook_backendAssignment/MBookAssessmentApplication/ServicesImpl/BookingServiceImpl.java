package com.metalbook_backendAssignment.MBookAssessmentApplication.ServicesImpl;

import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingRequestDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingResponseDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Booking;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Room;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Repository.BookingRepository;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Repository.RoomRepository;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Services.BookingService;
import com.metalbook_backendAssignment.MBookAssessmentApplication.exceptions.MBookRoomNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private RoomRepository roomRepo;
    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO bookingDetails) {
        Room room = roomRepo.findById(bookingDetails.getRoomType()).get();
        if(room.getAvailableRooms()-bookingDetails.getNumberOfPersons() < 0) {
            throw new MBookRoomNotAvailableException(room.getAvailableRooms()==0? "No":"Only "+room.getAvailableRooms()+" Rooms are available");
        }
        int totalPrice = calculatePrice(room, bookingDetails.getNumberOfPersons(), bookingDetails.isIncludeBreakfast(), bookingDetails.isIncludeExcursion());

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setIncludeBreakfast(bookingDetails.isIncludeBreakfast());
        booking.setIncludeExcursion(bookingDetails.isIncludeExcursion());
        booking.setTotalPrice(totalPrice);
        booking.setDateCreated(ZonedDateTime.now());
        booking.setNumberOfPersons(bookingDetails.getNumberOfPersons());
        bookingRepo.save(booking);
        room.setAvailableRooms(room.getAvailableRooms()-bookingDetails.getNumberOfPersons());
        roomRepo.save(room);
         return new BookingResponseDTO(room, bookingDetails.getNumberOfPersons(),
                 totalPrice, bookingDetails.isIncludeBreakfast(), bookingDetails.isIncludeExcursion(), booking.getDateCreated());
    }

    private int calculatePrice(Room room, int noOfPersons, boolean includeBreakfast, boolean includeExcursion) {
        int roomPrice = room.getPrice();
        int breakfastPrice = includeBreakfast ? room.getBreakfast()*noOfPersons : 0;
        int excursionPrice = includeExcursion ? room.getExcursion()*noOfPersons : 0;
        return roomPrice + breakfastPrice + excursionPrice;
    }

    /*public void validateRoomType(String roomType) {
        if(!roomType.equals("DELUXE") && !roomType.equals("LUXURY")){
            throw new IllegalArgumentException("Invalid Room Type. Allowed values: DELUXE, LUXURY");
        }
    }*/
}

