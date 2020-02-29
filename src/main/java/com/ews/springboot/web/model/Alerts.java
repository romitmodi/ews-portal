package com.ews.springboot.web.model;

import java.util.Date;

public class Alerts {

	private int ewsId;
	private int dsId;
	private String jobName;
	private String jobDescription;
	private String executionStep;
	private int testId;
	private String testCaseDescription;
	private String testScriptActual;
	private String priorResult;
	private String minResult;
	private String result;
	private String maxResult;
	private Date rundate;
	private int lastJobRunId;
	private String testStatus;
	private String measure;
	private String summary;
	private String detailComments;
	private String classification;
	private String severity;
	private String rallyDefect;
	private String serviceNowTix;
	private String status;
	private String owner;
	private String resolutionPlanToClose;

	public int getEwsId() {
		return ewsId;
	}

	public void setEwsId(int ewsId) {
		this.ewsId = ewsId;
	}

	public int getDsId() {
		return dsId;
	}

	public void setDsId(int dsId) {
		this.dsId = dsId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getExecutionStep() {
		return executionStep;
	}

	public void setExecutionStep(String executionStep) {
		this.executionStep = executionStep;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestCaseDescription() {
		return testCaseDescription;
	}

	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}

	public String getTestScriptActual() {
		return testScriptActual;
	}

	public void setTestScriptActual(String testScriptActual) {
		this.testScriptActual = testScriptActual;
	}

	public String getPriorResult() {
		return priorResult;
	}

	public void setPriorResult(String priorResult) {
		this.priorResult = priorResult;
	}

	public String getMinResult() {
		return minResult;
	}

	public void setMinResult(String minResult) {
		this.minResult = minResult;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(String maxResult) {
		this.maxResult = maxResult;
	}

	public Date getRundate() {
		return rundate;
	}

	public void setRundate(Date rundate) {
		this.rundate = rundate;
	}

	public int getLastJobRunId() {
		return lastJobRunId;
	}

	public void setLastJobRunId(int lastJobRunId) {
		this.lastJobRunId = lastJobRunId;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetailComments() {
		return detailComments;
	}

	public void setDetailComments(String detailComments) {
		this.detailComments = detailComments;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getRallyDefect() {
		return rallyDefect;
	}

	public void setRallyDefect(String rallyDefect) {
		this.rallyDefect = rallyDefect;
	}

	public String getServiceNowTix() {
		return serviceNowTix;
	}

	public void setServiceNowTix(String serviceNowTix) {
		this.serviceNowTix = serviceNowTix;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getResolutionPlanToClose() {
		return resolutionPlanToClose;
	}

	public void setResolutionPlanToClose(String resolutionPlanToClose) {
		this.resolutionPlanToClose = resolutionPlanToClose;
	}

}
