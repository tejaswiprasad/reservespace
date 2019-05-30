package com.mrbs.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mrbs.model.BookRoomInfo;
import com.mrbs.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	
	@Query(value="SELECT distinct region FROM room",nativeQuery=true)
	List<String> getRegions();
	
	@Query(value="SELECT distinct building FROM room WHERE region=?1",nativeQuery=true)
	public List<String> getBuildings(String region);
	
	@Query(value="SELECT distinct floor FROM room WHERE building=?1",nativeQuery=true)
	List<String> getFloors(String building);
	
	@Query(value="SELECT * FROM room WHERE region=?1 and building=?2 and floor=?3 and capacity=?4",nativeQuery=true)
	List<Room> getRooms(String region, String building,String floor, String capacity);

	
	

	
}

