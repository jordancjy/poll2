package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.User;

public class SurveyVM {
	private Long id;
	private String status;
	private String code;
	private String surveydate;
	private Double average;
	
	//关系
	private Course course;
	private ClazzVM clazzVM;
	private User teacher;
	private QuestionnaireVM qnVM;
	public Long getId() {
		return id;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSurveydate() {
		return surveydate;
	}
	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public ClazzVM getClazzVM() {
		return clazzVM;
	}
	public void setClazzVM(ClazzVM clazzVM) {
		this.clazzVM = clazzVM;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public QuestionnaireVM getQnVM() {
		return qnVM;
	}
	public void setQnVM(QuestionnaireVM qnVM) {
		this.qnVM = qnVM;
	}
	
	//题库没做完，问卷没做完，下面没法做
	

}
