package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionVM;

public interface QuestionVMMapper {

	List<QuestionVM>selectAll();
	//通过问卷id查找问卷下所有问题(包含选项)
	List<QuestionVM> selectByQuestionnaireId(long id);
}
