package com.briup.apps.poll.dao.extend;

import java.util.List;


import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.extend.SchoolVM;



public interface SchoolVMMapper {
	List<SchoolVM> selectAll();
	void save(School school);
	
	void update(School school);
	
	void deleteById(long id);
	
	void batchDelete(List<Long> ids);
}
