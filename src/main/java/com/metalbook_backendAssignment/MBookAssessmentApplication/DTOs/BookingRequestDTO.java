package com.metalbook_backendAssignment.MBookAssessmentApplication.DTOs;

import jakarta.validation.constraints.*;

import java.time.ZonedDateTime;

public class BookingRequestDTO {
    @Pattern(regexp = "DELUXE|LUXURY", message = "Invalid room type. Allowed values: DELUXE and LUXURY")
    private String roomType;
    @Min(value = 1, message = "number of persons must be in 1 to 10")
    @Max(value = 10,message = "number of persons must be in 1 to 10")
    private int numberOfPersons;
    private boolean includeBreakfast;
    private boolean includeExcursion;
    private ZonedDateTime dateCreated;

    public BookingRequestDTO() {
    }

    public BookingRequestDTO(String roomType, int numberOfPersons, boolean includeBreakfast, boolean includeExcursion, ZonedDateTime dateCreated) {
        this.roomType = roomType;
        this.numberOfPersons = numberOfPersons;
        this.includeBreakfast = includeBreakfast;
        this.includeExcursion = includeExcursion;
        this.dateCreated = dateCreated;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public boolean isIncludeBreakfast() {
        return includeBreakfast;
    }

    public void setIncludeBreakfast(boolean includeBreakfast) {
        this.includeBreakfast = includeBreakfast;
    }

    public boolean isIncludeExcursion() {
        return includeExcursion;
    }

    public void setIncludeExcursion(boolean includeExcursion) {
        this.includeExcursion = includeExcursion;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
