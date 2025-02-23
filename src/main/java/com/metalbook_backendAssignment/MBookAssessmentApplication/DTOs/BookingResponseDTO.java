package com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs;


import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Room;

import java.time.ZonedDateTime;

public class BookingResponseDTO {
    private Room roomDetails;
    private int noOfPersons;
    private boolean includeBreakfast;
    private boolean includeExcursion;
    private double totalPrice;
    private ZonedDateTime dateCreated;

    public BookingResponseDTO(Room room, int noOfPersons, double totalPrice,
                              boolean includeBreakfast, boolean includeExcursion, ZonedDateTime dateCreated) {
        this.roomDetails = room;
        this.noOfPersons = noOfPersons;
        this.totalPrice = totalPrice;
        this.includeBreakfast = includeBreakfast;
        this.includeExcursion = includeExcursion;
        this.dateCreated = dateCreated;
    }

    public Room getRoomDetails() {
        return roomDetails;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public boolean isIncludeBreakfast() {
        return includeBreakfast;
    }

    public boolean isIncludeExcursion() {
        return includeExcursion;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }
}
