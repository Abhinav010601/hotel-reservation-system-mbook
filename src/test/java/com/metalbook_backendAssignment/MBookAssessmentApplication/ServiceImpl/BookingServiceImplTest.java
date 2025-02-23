package com.metalbook_backendAssignment.MBookAssessmentApplication.ServiceImpl;

import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingRequestDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs.BookingResponseDTO;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Room;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Repository.BookingRepository;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Repository.RoomRepository;
import com.metalbook_backendAssignment.MBookAssessmentApplication.Services.BookingService;
import com.metalbook_backendAssignment.MBookAssessmentApplication.ServicesImpl.BookingServiceImpl;
import com.metalbook_backendAssignment.MBookAssessmentApplication.exceptions.MBookRoomNotAvailableException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {
    @Mock
    BookingRepository bookingRepository;
    @Mock
    RoomRepository roomRepository;
    @InjectMocks
    BookingServiceImpl bookingService;
    private Room room;
    private BookingRequestDTO bookingRequest;

    @Before
    public void setup(){
        room = new Room("DELUXE", 5, 100, 20, 30,15);
        bookingRequest = new BookingRequestDTO();
        bookingRequest.setRoomType("DELUXE");
        bookingRequest.setNumberOfPersons(2);
        bookingRequest.setIncludeBreakfast(true);
        bookingRequest.setIncludeExcursion(false);
    }
    @Test
    public void testCreateBooking_Success() {
        when(roomRepository.findById("DELUXE")).thenReturn(Optional.of(room));
        BookingResponseDTO response = bookingService.createBooking(bookingRequest);

        assertEquals(room.getRoomType(), response.getRoomDetails().getRoomType());
        assertEquals(5, response.getRoomDetails().getMaxNumberOfPersons());
        assertEquals(140, response.getTotalPrice()); // 100+(20*2)=140
        assertEquals(true, response.isIncludeBreakfast());
        assertEquals(false, response.isIncludeExcursion());
    }
    @Test
    public void testCreateBooking_RoomNotAvailable() {
        room.setAvailableRooms(1); // Assuming Room has a method to set available rooms
        when(roomRepository.findById("DELUXE")).thenReturn(Optional.of(room));
        bookingRequest.setNumberOfPersons(2);

        MBookRoomNotAvailableException exception = assertThrows(
                MBookRoomNotAvailableException.class,
                () -> bookingService.createBooking(bookingRequest)
        );
        assertEquals("Only 1 Rooms are available", exception.getMessage());
    }


}
