package com.metalbook_backendAssignment.MBookAssessmentApplication.Entities;

import jakarta.persistence.*;


@Entity
public class Room {
    @Id
    @Column(name = "room_type")
   private String room_type;
   private int maxNumberOfPersons;
    private int price;
    private int breakfast;
    private int excursion;
    private int availableRooms;

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public Room(String room_type, int maxNumberOfPersons, int price, int breakfast, int excursion, int availableRooms) {
        this.room_type = room_type;
        this.maxNumberOfPersons = maxNumberOfPersons;
        this.price = price;
        this.breakfast = breakfast;
        this.excursion = excursion;
        this.availableRooms = availableRooms;
    }

    public String getRoomType() {
        return room_type;
    }
    public int getMaxNumberOfPersons() {
        return maxNumberOfPersons;
    }

    public int getPrice() {
        return price;
    }
    public int getBreakfast() {
        return breakfast;
    }

    public int getExcursion() {
        return excursion;
    }

}
