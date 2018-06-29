package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.briup.apps.poll.bean.Question;

import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="题目模块相关接口")
@RestController//继承controller
@RequestMapping("/question")//映射
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	
	@ApiOperation(value="保存或修改题目信息",
			notes="如果题目id不为空则为更新操作，如果id为空，则为插入操作，保存或更新题目时级联保存或更新选项")
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestion(QuestionVM question){
		try {
			//调用service层代码完成保存或更新操作
			questionService.saveOrUpdate(null);
			return MsgResponse.success("保存或更新成功", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="查询所有题目信息")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try {
			List<Question> list=questionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有题目信息",notes="每个题目信息中包含班级题目下所有选项信息")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){
		try {
			List<QuestionVM> list=questionService.findAllQuestionVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="删除id相关题目信息",
			notes="删除题目同时删除选项")
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id){
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="批量删除题目信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[]ids){
		try {
			List<Long>idList=new ArrayList<>();
			for(long id: ids)
				idList.add(id);
			questionService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="根据关键字查询题目信息")
	@GetMapping("queryQuestion")
	public MsgResponse queryQuestion(String keywords){
		try {
			List<Question> list=questionService.query(keywords);
			return MsgResponse.success("关键字查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
