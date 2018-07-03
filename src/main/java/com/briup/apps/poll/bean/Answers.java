package com.briup.apps.poll.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="答卷信息")
public class Answers {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answers.id
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */

	@ApiModelProperty(value="答卷编号")

    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answers.selections
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */

	@ApiModelProperty(value="单选题答案,格式为第一题分数|第二题分数，eg5|1|4|3")

    private String selections;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answers.checkes
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
	@ApiModelProperty(value="复选题答案,格式为第一题分数|第二题分数，eg：5，3|1，2|4，3|3，3")
    private String checkes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answers.content
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
	@ApiModelProperty(value="简答题答案,格式为第一题答案|第二题答案，eg：Java数据类型没听明白|老师语速太快")
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answers.survey_id
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
	@ApiModelProperty(value="问卷编号,答卷的外键")
    private Long surveyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answers.id
     *
     * @return the value of poll_answers.id
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answers.id
     *
     * @param id the value for poll_answers.id
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answers.selections
     *
     * @return the value of poll_answers.selections
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public String getSelections() {
        return selections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answers.selections
     *
     * @param selections the value for poll_answers.selections
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public void setSelections(String selections) {
        this.selections = selections == null ? null : selections.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answers.checkes
     *
     * @return the value of poll_answers.checkes
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public String getCheckes() {
        return checkes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answers.checkes
     *
     * @param checkes the value for poll_answers.checkes
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public void setCheckes(String checkes) {
        this.checkes = checkes == null ? null : checkes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answers.content
     *
     * @return the value of poll_answers.content
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answers.content
     *
     * @param content the value for poll_answers.content
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answers.survey_id
     *
     * @return the value of poll_answers.survey_id
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public Long getSurveyId() {
        return surveyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answers.survey_id
     *
     * @param surveyId the value for poll_answers.survey_id
     *
     * @mbg.generated Mon Jun 25 10:19:42 CST 2018
     */
    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
}