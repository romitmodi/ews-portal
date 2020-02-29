package com.ews.springboot.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ews.springboot.web.model.Alerts;

@Mapper
public interface AlertMapper {

	@Select("select EWS_ID AS EWSID,Rundate,DSID,JobName,TestID,TestCaseDescription,PriorResult,MinResult,Result,MaxResult,"
			+ "TestStatus,Classification,Measure,Summary,DetailComments,Severity,RallyDefect,ServiceNowTix,Status,Owner,"
			+ "Resolution_PlanToClose\r\n" + " from  CommandCenter_EWS_EarlyWarningSystem\r\n"
			+ "	where rundate >= #{runDate}\r\n" + " and Classification is null\r\n"
			+ "	order by rundate desc, jobname, testid")
	List<Alerts> getAlertData(@Param("runDate") Date RunDate);

	@Select("select EWS_ID AS EWSID,Rundate,DSID,JobName,TestID,TestCaseDescription,PriorResult,MinResult,Result,MaxResult,"
			+ "TestStatus,Classification,Measure,Summary,DetailComments,Severity,RallyDefect,ServiceNowTix,Status,Owner,"
			+ "Resolution_PlanToClose\r\n" + " from  CommandCenter_EWS_EarlyWarningSystem\r\n"
			+ "	where rundate >= #{runDate}\r\n" + " and Classification is null\r\n" + "AND JobName=#{jobName}"
			+ "	order by rundate desc, jobname, testid")
	List<Alerts> getAlertDataWithFilter(@Param("jobName") String jobName, @Param("runDate") Date RunDate);

	@Select("select Jobname, JobDescription, rundate as createdate, status,  measure, summary, detailcomments, Owner,Resolution_PlanToClose,  count(*) as Teststeps  "
			+ "from  CommandCenter_EWS_EarlyWarningSystem\r\n" + "	where status not in ('Closed')\r\n"
			+ "	group by Jobname, JobDescription, rundate, status,  measure, summary, detailcomments, Owner,Resolution_PlanToClose\r\n"
			+ "	order by JobName")
	List<Alerts> getAlertDataBasedOnStatus();

	@Update("update CommandCenter_EWS_EarlyWarningSystem\r\n" + "    set    Classification=#{alert.classification},\r\n"
			+ "           Measure=#{alert.measure},\r\n" + "           Summary=#{alert.summary},\r\n"
			+ "           DetailComments=#{alert.detailComments},\r\n" + "           Severity=#{alert.severity},\r\n"
			+ "           RallyDefect=#{alert.rallyDefect},\r\n"
			+ "           ServiceNowTix=#{alert.serviceNowTix},\r\n" + "           Status=#{alert.status},\r\n"
			+ "           Owner=#{alert.owner},\r\n"
			+ "           Resolution_PlanToClose=#{alert.resolutionPlanToClose}\r\n"
			+ "    where rundate = #{alert.rundate} and jobname = #{alert.jobName}")
	void updateAlertDetails(@Param("alert") Alerts alerts);
}