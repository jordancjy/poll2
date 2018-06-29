package com.briup.apps.poll.service;

import com.briup.apps.poll.bean.Survey;

public interface ISurveyService {
	void saveOrUpdate(Survey survey) throws Exception;

}
