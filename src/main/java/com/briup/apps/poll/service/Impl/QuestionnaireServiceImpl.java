package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;
	@Override
	public QuestionnaireVM findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireVMMapper.selectById(id);
	}

	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example=new QuestionnaireExample();
		
		return questionnaireMapper.selectByExample(example);
	}

}
