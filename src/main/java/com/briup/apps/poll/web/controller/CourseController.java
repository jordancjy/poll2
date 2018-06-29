package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "课程相关接口")
@RestController
@RequestMapping("/course") // 映射地址
public class CourseController {
	@Autowired
	private ICourseService courseService;

	@ApiOperation(value = "查询所有课程信息")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse() {
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查询成功", list);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "关键字查询课程信息")
	@GetMapping("queryCourse")
	public MsgResponse queryCourse(String keywords) {
		try {
			List<Course> list = courseService.query(keywords);
			return MsgResponse.success("关键字查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "删除id相关课程信息")
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id) {
		try {
			courseService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新课程信息",notes="如果参数中包含了id，说明这是一个更新操作，反之则为保存操作")
	@PostMapping("saveOrUpdateCourse")
	public MsgResponse saveOrUpdateCourse(Course course) {
		try {
			if(course!=null && course.getId()!=null){
			courseService.update(course);
			}else{
				courseService.save(course);
			}
			
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}


	@ApiOperation(value = "批量删除课程信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids)
				idList.add(id);
			courseService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
