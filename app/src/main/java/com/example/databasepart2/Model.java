package com.example.databasepart2;

public class Model {
    String roomDetail,complaint;
    Long otp;

    public Model() {
    }

    public Model(String roomDetail, String complaint, Long otp) {
        this.roomDetail = roomDetail;
        this.complaint = complaint;
        this.otp = otp;
    }

    public String getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Long getOtp() {
        return otp;
    }

    public void setOtp(Long otp) {
        this.otp = otp;
    }
}
