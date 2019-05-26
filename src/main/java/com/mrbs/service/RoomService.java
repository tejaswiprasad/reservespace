package com.mrbs.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrbs.dto.RoomScheduleDTO;
import com.mrbs.dto.RoomSearchCriteriaDTO;
import com.mrbs.jpa.RoomRepository;
import com.mrbs.model.Room;
import com.mrbs.model.ScheduleInfo;


@Component
public class RoomService {
	
	@Autowired
	private RoomRepository repository;
	
	public List<String> getRegions() {
		
		return repository.getRegions();
	}
	
	public List<String> getBuildings(String region)
	{
		return repository.getBuildings(region);
	}

	public List<String> getFloors(String building) {
		// TODO Auto-generated method stub
		return repository.getFloors(building);
	}
	
	public List<Room> getRooms(RoomSearchCriteriaDTO dto)
	{
		return repository.getRooms(dto.getRegion(), dto.getBuilding(), dto.getFloor(), dto.getCapacity());
	}
	
	public List<ScheduleInfo> getRoomSchedules(int roomId,Date startDateTime,Date endDateTime)
	{
		return repository.getRoomSchedules(roomId,startDateTime,endDateTime);
	}

	

}
