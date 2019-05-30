package com.mrbs.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mrbs.model.ScheduleInfo;

public interface ScheduleInfoRepository extends CrudRepository<ScheduleInfo, Long> {

	@Query(value="SELECT * FROM scheduleinfo WHERE roomid=?1 and starttime>=?2 and endtime<=?3",nativeQuery=true)
	List<ScheduleInfo> getRoomSchedules(int roomId,Date startDateTime,Date endDateTime);
	
		
}

