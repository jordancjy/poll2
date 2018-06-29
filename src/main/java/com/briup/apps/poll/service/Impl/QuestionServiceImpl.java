package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;



@Service
public class QuestionServiceImpl  implements IQuestionService{
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	@Override
	public List<Question> findAll() throws Exception {
		QuestionExample example=new QuestionExample();
		
		return questionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		
		return questionVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
		//1.从questionVM中拆分出来question options
		Question question=new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		List<Options>options=questionVM.getOptions();
		//2.判断是更新操作还是保存操作
		
		if(question.getId()!=null){
			//2.1修改操作
			//2.1.1修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.1.2处理题目下选项信息(以删代修)
			//通过question_id删除选项信息
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//新接收到的options数据插入到数据可中
			long id=question.getId();
			//2.2.2保存选项信息
			for(Options option:options){
				option.setQuestionId(id);
				optionsMapper.insert(option);
		}
			
			
		}else{
			//2.2保存操作
			if(question.getQuestiontype().equals("简答题")){
				questionMapper.insert(question);
			}else{
				//2.2.1保存问题信息
				questionMapper.insert(question);
				//获取问题的主键
				long id=question.getId();
				//2.2.2保存选项信息
				for(Options option:options){
					option.setQuestionId(id);
					optionsMapper.insert(option);
			}
				
			}
		}
		
	}

	@Override
	
		public List<Question> query(String keywords) throws Exception {
			QuestionExample example=new QuestionExample();
			example.createCriteria().andNameLike(keywords);
			return questionMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for (long id:ids){
			questionMapper.deleteByPrimaryKey(id);
		}
		
	}

	

	


}
