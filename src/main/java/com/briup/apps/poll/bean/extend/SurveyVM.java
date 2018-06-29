package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.User;

public class SurveyVM {
	private Long id;
	private String status;
	private String code;
	private String surveydate;
	//关系
	private Course course;
	private ClazzVM clazzVM;
	private User teacher;
	private QuestionnaireVM qnVM;
	//题库没做完，问卷没做完，下面没法做
	

}
