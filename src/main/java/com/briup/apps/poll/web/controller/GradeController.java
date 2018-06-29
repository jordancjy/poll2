package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	
	@ApiOperation(value="查询所有年级信息")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list=gradeService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有年级信息",notes="年级信息中包含的学校信息")
	@GetMapping("findAllGradeVM")
	public MsgResponse findAllGradeVM(){
		try {
			List<GradeVM> list=gradeService.findAllGradeVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="关键字查询年级信息")
	@GetMapping("queryGrade")
	public MsgResponse queryGrade(String keywords){
		try {
			gradeService.query(keywords);
			return MsgResponse.success("关键字查询成功",queryGrade(keywords));
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除年级信息")
	@GetMapping("deleteGradeById")
	public MsgResponse deleteGradeById(long id){
		try {
			gradeService.daleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="保存或修改年级信息"
			,notes="id为空则为保存操作，反之则为修改操作")
	@PostMapping("saveOrUpdateGrade")
	public MsgResponse saveOrUpdateGrade(Grade grade){
		try {
			if (grade!=null&& grade.getId()!=null) {
				gradeService.update(grade);
			} else {
				gradeService.save(grade);
			}
			return MsgResponse.success("保存或修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
	}
}
	
	@ApiOperation(value="批量删除年级信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[]ids){
		try {
			List<Long> idList=new ArrayList<>();
			for(long id:ids)
			idList.add(id);
			return MsgResponse.success("批量删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
		}
	}
}
