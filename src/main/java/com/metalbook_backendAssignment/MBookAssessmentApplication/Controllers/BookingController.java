package com.metalbook_backendAssignment.MBookAssessmentApplication.Controllers;

import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingRequestDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingResponseDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Services.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private BookingService bookingService;
    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    @PostMapping
    public ResponseEntity<BookingResponseDTO> createRoomBooking( @RequestBody @Valid BookingRequestDTO bookingDetails){
       // bookingService.validateRoomType(bookingDetails.getRoomType());
        BookingResponseDTO response = bookingService.createBooking(bookingDetails);
        return ResponseEntity.ok(response);
    }

}
