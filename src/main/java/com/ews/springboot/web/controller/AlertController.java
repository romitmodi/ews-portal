package com.ews.springboot.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ews.springboot.web.model.Alerts;
import com.ews.springboot.web.service.AlertService;
import com.fasterxml.jackson.databind.ser.PropertyBuilder;

@Controller
public class AlertController {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	AlertService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-alerts", method = RequestMethod.GET)
	public String getAlertList(ModelMap model, @ModelAttribute("runDate") String runDate,
			@ModelAttribute("jobName") String jobName) throws ParseException {
		model.put("alertDataList", service.getAlertListbyRunDate(jobName,
				(runDate == null || runDate.isEmpty() ? dateFormat2.parse("2020-01-31") : dateFormat2.parse(runDate))));
		model.put("alertDataListByStatus", service.getAlertListbyStatus());
		return "list-alerts";
	}

	@RequestMapping(value = "/update-alerts", method = RequestMethod.GET)
	public String updateAlertDetails(ModelMap modelMap, @ModelAttribute("alertData") Alerts alertData)
			throws ParseException {
		service.updateAlertDetails(alertData);
		this.getAlertList(modelMap, null, null);
		return "list-alerts";
	}
}
