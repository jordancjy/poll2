package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
//throws exception(“抛异常”)
	List<Course>findAll() throws Exception;
	//根据关键字查询
	List<Course> query(String keywords) throws Exception;
	
	void deleteById(Long id) throws Exception;
	
	void save(Course course) throws Exception;
	
	void update(Course course) throws Exception;
	//批量删除
	void batchDelete(List<Long>ids) throws Exception;
}
