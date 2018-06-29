package com.briup.apps.poll.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.service.ISurveyService;
@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	@Override
	public void saveOrUpdate(Survey survey) throws Exception {
		//初始化
		survey.setStatus(Survey.STATUS_INIT);
		survey.setCode("");
		
		Date surveyDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=sdf.format(surveyDate);
		survey.setSurveydate(s);
		surveyMapper.insert(survey);
		
	}

}
