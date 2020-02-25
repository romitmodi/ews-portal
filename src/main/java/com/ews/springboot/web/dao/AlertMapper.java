package com.ews.springboot.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ews.springboot.web.model.Alerts;

@Mapper
public interface AlertMapper {

	@Select("select EWS_ID,Rundate,DSID,JobName,TestID,TestCaseDescription,PriorResult,MinResult,Result,MaxResult,"
			+ "TestStatus,Classification,Measure,Summary,DetailComments,Severity,RallyDefect,ServiceNowTix,Status,Owner,"
			+ "Resolution_PlanToClose\r\n" + " from  CommandCenter_EWS_EarlyWarningSystem\r\n"
			+ "	where rundate >= #{runDate}\r\n" + " and Classification is null\r\n"
			+ "	order by rundate desc, jobname, testid")
	List<Alerts> getAlertData(@Param("runDate") Date RunDate);

	@Select("select Jobname, JobDescription, rundate as createdate, status,  measure, summary, detailcomments, Owner,Resolution_PlanToClose,  count(*) as Teststeps  "
			+ "from  CommandCenter_EWS_EarlyWarningSystem\r\n" + "	where status not in ('Closed')\r\n"
			+ "	group by Jobname, JobDescription, rundate, status,  measure, summary, detailcomments, Owner,Resolution_PlanToClose\r\n"
			+ "	order by JobName")
	List<Alerts> getAlertDataBasedOnStatus();
}
