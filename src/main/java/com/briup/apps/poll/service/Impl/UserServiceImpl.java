package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public List<User> findAll() throws Exception {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public User findById(long id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(User user) throws Exception {
		if(user.getId()!=null) {
			userMapper.updateByPrimaryKey(user);
		} else {
			userMapper.insert(user);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	}


}

