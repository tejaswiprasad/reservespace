package com.mrbs.dto;

import java.util.Date;

public class RoomScheduleResultDTO {
	private int roomId;
	private Date startTime;
	private Date endTime;
	@Override
	public String toString() {
		return "RoomScheduleResultDTO [roomId=" + roomId + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
