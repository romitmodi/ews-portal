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

	public List<Alerts> getAlertListbyRunDate(Date runDate) {
		return alertMapper.getAlertData(runDate);
	}

	public List<Alerts> getAlertListbyStatus() {
		return alertMapper.getAlertDataBasedOnStatus();
	}

	public void updateAlertDetails(Alerts alerts) {
		alertMapper.updateAlertDetails(alerts);
	}

}