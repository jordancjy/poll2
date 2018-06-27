package com.briup.apps.poll.service;

import java.util.List;


import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.extend.SchoolVM;

public interface ISchoolService {
List<School> findAll() throws Exception;
List<School> query(String keywords) throws Exception;

void save(School school) throws Exception;

void update(School school) throws Exception;

void deleteById(long id) throws Exception;

void batchDelete(long[] ids) throws Exception;
List<SchoolVM> findAllSchoolVM() throws Exception;
}
