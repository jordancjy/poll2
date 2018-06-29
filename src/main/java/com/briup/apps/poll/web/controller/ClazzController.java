package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController//继承controller
@RequestMapping("/clazz")//映射
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	
	@ApiOperation(value="查询所有班级信息")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try {
			List<Clazz> list=clazzService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有班级信息",notes="每个班级信息中包含班级所属年级和班级所属的班主任信息")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){
		try {
			List<ClazzVM> list=clazzService.findAllClazzVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="保存或更新班级信息",
			notes="如果id不为空，为保存操作，反之则为修改操作")
	@PostMapping("saveOrUpdateClazz")
	public MsgResponse saveOrUpdateClazz(Clazz clazz){
		try {
			if (clazz!=null && clazz.getId()!=null) {
				clazzService.update(clazz);
				
			} else {
				clazzService.save(clazz);
				
			}
			return MsgResponse.success("保存或修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="删除id相关班级信息")
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id){
		try {
			clazzService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="批量删除班级信息")
	@PostMapping("batchdelete")
	public MsgResponse batchdelete(long[]ids){
		try {
			List<Long>idList=new ArrayList<>();
			for(long id: ids)
				idList.add(id);
			clazzService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过关键字查询班级信息")
	@GetMapping("queryClazz")
	public MsgResponse queryClazz(String keywords){
		try {
			List<Clazz> list=clazzService.query(keywords);
			return MsgResponse.success("关键字查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
