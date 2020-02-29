package com.ews.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ews.springboot.web.model.Alerts;
import com.ews.springboot.web.service.AlertService;

@Controller
public class AlertController {

	@Autowired
	AlertService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-alerts", method = RequestMethod.GET)
	public String getAlertList(ModelMap model, @Valid Date runDate) {
		if (runDate == null) {
			runDate = new Date();
		}
		model.put("alertDataList", service.getAlertListbyRunDate(runDate));
		model.put("alertDataListByStatus", service.getAlertListbyStatus());
		return "list-alerts";
	}

	@RequestMapping(value = "/update-alerts", method = RequestMethod.POST)
	public String updateAlertDetails(ModelMap modelMap, @Valid Alerts alerts) {
		service.updateAlertDetails(alerts);
		return "list-alerts";
	}
}
