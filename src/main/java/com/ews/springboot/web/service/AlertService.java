package com.ews.springboot.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ews.springboot.web.dao.AlertMapper;
import com.ews.springboot.web.model.Alerts;

@Service
public class AlertService {

	@Autowired
	private AlertMapper alertMapper;

	public List<Alerts> getAlertListbyRunDate(String jobName, Date runDate) {
		if (jobName == null || jobName.isEmpty() || jobName.equalsIgnoreCase("")) {
			return alertMapper.getAlertData(runDate);
		}
		return alertMapper.getAlertDataWithFilter(jobName, runDate);
	}

	public List<Alerts> getAlertListbyStatus() {
		return alertMapper.getAlertDataBasedOnStatus();
	}

	public Alerts getAlertDetails(int ewsId) {
		return alertMapper.getAlertDetails(ewsId);
	}

	public void updateAlertDetails(Alerts alerts) {
		alertMapper.updateAlertDetails(alerts);
	}

	public Alerts getAlertDetail(String jobName, String jobDescription, String status, String measure, String summary,
			String detailComments, String owner, String resolutionPlanToClose, int executionStep, Date runDate) {
		return alertMapper.getAlertDetail(jobName, jobDescription, status, measure, summary, detailComments, owner,
				resolutionPlanToClose, executionStep,runDate);
	}
	
	public void updateAlertDetail(Alerts alerts) {
		alertMapper.updateAlertDetail(alerts);
	}

}