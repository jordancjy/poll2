package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;

import com.briup.apps.poll.bean.extend.OptionsVM;

import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	
	@ApiOperation(value="保存或修改选项信息",
			notes="如果参数中包含ID表示修改操作，否则表示保存操作")
	@PostMapping("saveOrUpdateOptions")
	public MsgResponse saveOrUpdateOptions(Options options){
		try {
			optionsService.saveOrUpdateOptions(options);
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="批量删除选项信息",
			notes="参数为数组")
	@PostMapping("batchDeleteOptions")
	public MsgResponse batchDeleteClazz(long[] ids){
		try {
			optionsService.batchDelete(ids);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID删除班级信息",
			notes="")
	@GetMapping("deleteOptionsById")
	public MsgResponse deleteClazzById(long id){
		try {
			optionsService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有选项",
			notes="问卷中携带选项信息")
	@GetMapping("findAllVM")
	public MsgResponse findAllVM(){
		try {
			List<OptionsVM> list = optionsService.findAllOptionsVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="查询所有选项",notes="单表")
	@GetMapping("findAll")
	public MsgResponse findAll(){
		try {
			List<Options> list = optionsService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

