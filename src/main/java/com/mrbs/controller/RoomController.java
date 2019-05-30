package com.mrbs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrbs.dto.BookRoomDTO;
import com.mrbs.dto.BookRoomResultDTO;
import com.mrbs.dto.RoomScheduleDTO;
import com.mrbs.dto.RoomScheduleResultDTO;
import com.mrbs.dto.RoomSearchCriteriaDTO;
import com.mrbs.dto.RoomSearchResultDTO;
import com.mrbs.model.BookRoomInfo;
import com.mrbs.model.Room;
import com.mrbs.model.ScheduleInfo;
import com.mrbs.service.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping(path="/regions",  produces = "application/json")
	public List<String> getRegions() {
		return roomService.getRegions();
	}
	
	@GetMapping(path="/buildings/{region}", produces="application/json")
	public List<String> getBuildings(@PathVariable String region) {
		System.out.println("region" +region);
		return roomService.getBuildings(region);
	}

	@GetMapping("/floors/{building}")
	public List<String> getFloors(@PathVariable String building) {
		
		return roomService.getFloors(building);
	}
	
	@PostMapping("/rooms")
	public List<RoomSearchResultDTO> getRooms(@RequestBody RoomSearchCriteriaDTO dto) {
		
		System.out.println("dto "+dto);
		
		List<Room> roomList	=	roomService.getRooms(dto);
		List<RoomSearchResultDTO> roomResultList = new ArrayList<RoomSearchResultDTO>();
		
		for(Room room:roomList)
		{
			RoomSearchResultDTO resultDTO	=	new RoomSearchResultDTO();
			resultDTO.setRoomId(room.getId());
			resultDTO.setRoomName(room.getName());
			roomResultList.add(resultDTO);
		}
		
		return roomResultList;
	}
	
/*	@PostMapping("/schedules")
	public List<RoomScheduleResultDTO> getRoomSchedules(@RequestBody RoomScheduleDTO dto) throws Exception {
		
	    SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    
	    Date startDateTime	=	FORMATTER.parse(dto.getStartTime());
	    Date endDateTime	=	FORMATTER.parse(dto.getEndTime());
		
		List<ScheduleInfo> roomScheduleList	=	roomService.getRoomSchedules(dto.getRoomId(),startDateTime,endDateTime);
		List<RoomScheduleResultDTO> roomScheduledResultList = new ArrayList<RoomScheduleResultDTO>();
		
		for(ScheduleInfo scheduleinfo:roomScheduleList)
		{
			RoomScheduleResultDTO resultscheduleDTO	=	new RoomScheduleResultDTO();
			resultscheduleDTO.setRoomId(scheduleinfo.getRoomId());
			resultscheduleDTO.setStartTime(scheduleinfo.getStartTime());
			resultscheduleDTO.setEndTime(scheduleinfo.getEndTime());
			roomScheduledResultList.add(resultscheduleDTO);
		}
		
		return roomScheduledResultList;
	}
*/	
	
		
	@PostMapping("/schedules")
	public void saveSchedule(@RequestBody RoomScheduleDTO dto) throws Exception {
		
	    SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    
	    Date startDateTime	=	FORMATTER.parse(dto.getStartTime());
	    Date endDateTime	=	FORMATTER.parse(dto.getEndTime());
		
	    roomService.saveScheduleInfo(dto.getRoomId(),startDateTime,endDateTime);
		}
	
//	public static void main(String[] args) throws Exception {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		RoomSearchCriteriaDTO criteriaDTO	=	new RoomSearchCriteriaDTO();
//		criteriaDTO.setBuilding("building");
//		criteriaDTO.setRegion("region");
//		criteriaDTO.setFloor("floor");
//		criteriaDTO.setCapacity("capacity");
//		
//		String jsonString = mapper.writeValueAsString(criteriaDTO);
//		
//		RoomScheduleDTO scheduleDTO	=	new RoomScheduleDTO();
//		scheduleDTO.setRoomId(1);
//		scheduleDTO.setStartTime("2019-05-26 13:00");
//		scheduleDTO.setEndTime("2019-05-26 14:00");
//		
//
//		System.out.println(mapper.writeValueAsString(scheduleDTO));
//	}

	
	/*@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(
			@PathVariable String studentId, @RequestBody Course newCourse) {

		Course course = roomService.addCourse(studentId, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(course.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		return roomService.retrieveCourse(studentId, courseId);
	}

*/}
