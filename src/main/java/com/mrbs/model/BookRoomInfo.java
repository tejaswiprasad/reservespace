package com.mrbs.model;

public class BookRoomInfo {
	
	private int roomId;
	private String startTime;
	private String endTime;
	private String Date;
	@Override
	public String toString() {
		return "BookRoomDTO [roomId=" + roomId + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", Date=" + Date + "]";
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}



}
