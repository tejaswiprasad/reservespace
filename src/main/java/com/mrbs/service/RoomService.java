package com.mrbs.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrbs.dto.BookRoomDTO;
import com.mrbs.dto.RoomScheduleDTO;
import com.mrbs.dto.RoomSearchCriteriaDTO;
import com.mrbs.jpa.RoomRepository;
import com.mrbs.jpa.ScheduleInfoRepository;
import com.mrbs.model.BookRoomInfo;
import com.mrbs.model.Room;
import com.mrbs.model.ScheduleInfo;


@Component
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private ScheduleInfoRepository scheduleInfoRepository;
	
	public List<String> getRegions() {
		
		return roomRepository.getRegions();
	}
	
	public List<String> getBuildings(String region)
	{
		return roomRepository.getBuildings(region);
	}

	public List<String> getFloors(String building) {
		// TODO Auto-generated method stub
		return roomRepository.getFloors(building);
	}
	
	public List<Room> getRooms(RoomSearchCriteriaDTO dto)
	
	{
		System.out.println("value1"+dto.getRegion());
		System.out.println("value2"+dto.getBuilding());
		System.out.println("value3"+dto.getFloor());
		System.out.println("value4"+dto.getCapacity());
		
		return roomRepository.getRooms(dto.getRegion(), dto.getBuilding(), dto.getFloor(), dto.getCapacity());
	}
	
	public List<ScheduleInfo> getRoomSchedules(int roomId,Date startDateTime,Date endDateTime)
	{
		return scheduleInfoRepository.getRoomSchedules(roomId,startDateTime,endDateTime);
	}

	

	public void saveScheduleInfo(int roomId,Date startDateTime,Date endDateTime)
	{
		
		ScheduleInfo scheduleInfo	=	new ScheduleInfo();
		scheduleInfo.setRoomId(roomId);
		scheduleInfo.setStartTime(startDateTime);
		scheduleInfo.setEndTime(endDateTime);
		
		System.out.println("********************** "+scheduleInfo);
		
		scheduleInfoRepository.save(scheduleInfo);
	}

}
