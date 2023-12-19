package com.library_entity_controllers;


public class RoomsReservation {

    private int reservationId;
    private int studyRoomId;
    private int userId;
    private String reservationDateTime;
    private String reservationEndDateTime;

    public String getReservationEndDateTime() {
        return reservationEndDateTime;
    }

    public void setReservationEndDateTime(String reservationEndDateTime) {
        this.reservationEndDateTime = reservationEndDateTime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getStudyRoomId() {
        return studyRoomId;
    }

    public void setStudyRoomId(int studyRoomId) {
        this.studyRoomId = studyRoomId;
    }

    public String getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(String reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public RoomsReservation(int reservationId, int studyRoomId, int userId, String reservationDateTime, String reservationEndDateTime) {
        this.reservationId = reservationId;
        this.studyRoomId = studyRoomId;
        this.reservationDateTime = reservationDateTime;
        this.userId = userId;
        this.reservationEndDateTime = reservationEndDateTime;
    }





}
