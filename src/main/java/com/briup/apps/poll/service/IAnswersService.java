package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;

public interface IAnswersService {
	List<Answers>findAll() throws Exception;
	
	List<AnswersVM>findAllAnswersVM() throws Exception;
	
	List<Answers>query(String keywords) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void saveOrUpdate(Answers answers) throws Exception;
	
	
	void batchDelete(List<Long> ids) throws Exception;
	
}
