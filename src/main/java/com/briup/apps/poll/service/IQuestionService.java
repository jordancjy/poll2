package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface IQuestionService {
	List<Question> findAll() throws Exception;
	
	List<QuestionVM> findAllQuestionVM() throws Exception;
	
	void saveOrUpdate(QuestionVM question) throws Exception;
	
	List<Question> query(String keywords) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void batchDelete(List<Long> ids) throws Exception;
}
