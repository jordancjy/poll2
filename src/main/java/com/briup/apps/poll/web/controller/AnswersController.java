package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="答案相关接口")
@RestController
@RequestMapping("/answers")//映射


public class AnswersController {
	@Autowired//注入接口
	private IAnswersService answersService;
	
	@ApiOperation(value="提交答卷，每个学生提交一份")
	@PostMapping("submitAnswers")
	public MsgResponse submitAnswers(Answers answers){
		try {
			//1.判断用户是否有答卷权限（是否提交过）
			
			//2.保存答卷信息
			answersService.saveOrUpdate(answers);
			return MsgResponse.success("提交成功！你的意见是我们的改进方向", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	@ApiOperation(value="查询所有答案信息")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers(){
		try {
			List<Answers>list=answersService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="关键字答案信息查找")
	@GetMapping("queryAnswers")
	public MsgResponse queryAnswers(String keywords){
		try {
			answersService.query(keywords);
			return MsgResponse.success("关键字答案查询成功", queryAnswers(keywords));
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除id相关答案信息")
	@GetMapping("deleteAnswersById")
	public MsgResponse deleteAnswersById(long id){
		try {
			answersService.deleteById(id);
			return MsgResponse.success("删除id相关答案", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	
	@ApiOperation(value="查询所有答案信息",notes="答案信息中包括课调详细信息（不确定）")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM(){
		try {
			List<AnswersVM> list=answersService.findAllAnswersVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="根据id批量删除答案信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[]ids){
		try {
			List<Long> idList=new ArrayList<>();
			for (long id:ids)
				idList.add(id);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

