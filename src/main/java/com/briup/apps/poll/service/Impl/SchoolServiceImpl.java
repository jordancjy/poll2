package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;

import com.briup.apps.poll.bean.extend.SchoolVM;

import com.briup.apps.poll.dao.SchoolMapper;
import com.briup.apps.poll.dao.extend.SchoolVMMapper;
import com.briup.apps.poll.service.ISchoolService;




@Service
public class SchoolServiceImpl implements ISchoolService{

	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private SchoolVMMapper schoolVMMapper;
	
	@Override
	public List<School> findAll() throws Exception {
		SchoolExample example = new SchoolExample();
		return schoolMapper.selectByExampleWithBLOBs(example);
	}

	@Override
public List<SchoolVM> findAllSchoolVM() throws Exception {
		
		return schoolVMMapper.selectAll();
	}

	@Override
	public List<School> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(School school) throws Exception {
		// TODO Auto-generated method stub
		schoolMapper.insert(school);
	}

	@Override
	public void update(School school) throws Exception {
		// TODO Auto-generated method stub
		schoolMapper.updateByPrimaryKey(school);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		schoolMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id:ids){
			schoolMapper.deleteByPrimaryKey(id);
			
		}
	}
	}