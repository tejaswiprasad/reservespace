package com.mrbs.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mrbs.model.Room;
import com.mrbs.model.ScheduleInfo;

public interface RoomRepository extends CrudRepository<Room, Long> {
	
	@Query(value="SELECT distinct region FROM room",nativeQuery=true)
	List<String> getRegions();
	
	@Query(value="SELECT distinct building FROM room WHERE region=?1",nativeQuery=true)
	public List<String> getBuildings(String region);
	
	@Query(value="SELECT distinct floor FROM room WHERE building=?1",nativeQuery=true)
	List<String> getFloors(String building);
	
	@Query(value="SELECT * FROM room WHERE region=?1 and building=?2 and floor=?3 and capacity=?4",nativeQuery=true)
	List<Room> getRooms(String region, String building,String floor, String capacity);
	
	@Query(value="SELECT * FROM scheduleinfo WHERE roomid=?1 and start_time>=?2 and end_time<=?3",nativeQuery=true)
	List<ScheduleInfo> getRoomSchedules(int roomId,Date startDateTime,Date endDateTime);

	
}

