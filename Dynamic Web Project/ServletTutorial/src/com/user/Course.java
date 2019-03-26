package com.user;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
	private String courseName,professor;
	private List<WeekDay> weekdays = new ArrayList<>();
	private String time;
	private int roomNum;
	private String startDate;
	
	public Course() {}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public List<WeekDay> getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(List<WeekDay> weekdays) {
		this.weekdays = weekdays;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String date) {
		
		this.startDate = date;
		
	}
}
