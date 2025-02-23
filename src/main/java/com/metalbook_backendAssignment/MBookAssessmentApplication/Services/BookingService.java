package com.metalbook_backendAssignment.MBookAssessmentApplication.Services;

import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingRequestDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingResponseDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Booking;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;


public interface BookingService {
  public BookingResponseDTO createBooking(BookingRequestDTO bookingDetails);
 // public void validateRoomType(String roomType);
}