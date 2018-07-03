package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService answersService;
	
	@ApiOperation(value="审核课调",notes="返回课调信息及答案")
	@GetMapping("toCheckSurvey")
	public MsgResponse toCheckSurvey(long id){
		try {
			SurveyVM surveyVM =surveyService.findById(id);
			List<Answers> answers=answersService.findAnswersBySurvey(id);
			double total=0.0;
			for(Answers answer:answers){
				String selectStr=answer.getSelections();
				if(selectStr!=null){
					String[] arr=selectStr.split("[|]");
					double singleTotal=0.0;
					for(String a:arr){
						int select=Integer.parseInt(a);
						singleTotal+=select;
					}
					double singleAverage=singleTotal/arr.length;
					total+=singleAverage;
				}
			}
			double average=total/answers.size();
			surveyVM.setAverage(average);
			return MsgResponse.success("success", surveyVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="登录课调",notes="code表示课调编号")
	@GetMapping("loginSurvey")
	public MsgResponse loginSurvey(long code){
		try {			
			SurveyVM surveyVM=surveyService.findById(code);
			if(surveyVM.getStatus().equals(Survey.STATUS_BEGIN)){
				return MsgResponse.success("success", surveyVM);
			}else{
				return MsgResponse.error("课调状态："+surveyVM.getStatus());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="审核课调",
			notes="id表示课调编号，status表示审核状态，0表示审核不通过，1表示审核通过")
	@GetMapping("checkSurvey")
	public MsgResponse checkSurvey(long id,int status){
		try {		
			
			Survey survey=surveyService.findSurveyById(id);
			String message="审核通过";
			
			if(survey.getStatus().equals(Survey.STATUS_NO_CHECK)){
				if(status==0){
					message="审核不通过";
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
				}else{
					survey.setStatus(Survey.STATUS_CHECK_PASS);
				}	
			}else{
				message="课调状态不合法！";
			}
					
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success(message, null);			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过状态查询课调")
	@GetMapping("findSurveyByStatus")
	public MsgResponse findSurveyByStatus(String status){
		try {			
			List<SurveyVM> list=surveyService.findByStatus(status);
			return MsgResponse.success("sucess", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="关闭课调")
	@GetMapping("stopSurvey")
	public MsgResponse stopSurvey(long id){
		try {
			Survey survey=surveyService.findSurveyById(id);
			survey.setStatus(Survey.STATUS_NO_CHECK);
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success("成功关闭课调", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="开启课调")
	@GetMapping("startSurvey")
	public MsgResponse startSurvey(long id){
		try {
			Survey survey=surveyService.findSurveyById(id);
			//Long大写的为包装器类型
			survey.setStatus(Survey.STATUS_BEGIN);
			String code=survey.getId().toString();
			survey.setCode(code);			
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success("开启课调", null);					
		} catch ( Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	

	@ApiOperation(value="保存或更新课调",notes="只需要输入各类id即可")
	@PostMapping("saveOrUpdateSurvey")
	public MsgResponse saveOrUpdateSurvey(Survey survey) {
		try {
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所用课调",notes="级联查询课程，班级，讲师，问卷")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey() {
		try {
			List<SurveyVM> list=surveyService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="通过ID查询课调",notes="级联查询课程，班级，讲师，问卷")
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(long id) {
		try {
			SurveyVM surveyVM=surveyService.findById(id);
			return MsgResponse.success("success", surveyVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
