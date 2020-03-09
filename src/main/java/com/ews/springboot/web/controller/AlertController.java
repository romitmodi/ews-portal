package com.ews.springboot.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ews.springboot.web.model.Alerts;
import com.ews.springboot.web.service.AlertService;

@Controller
public class AlertController {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateFormat3 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
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

	@RequestMapping(value = "/update-alert", method = RequestMethod.GET)
	public String updateAlertDetails(ModelMap modelMap, @RequestParam int ewsId) {
		modelMap.put("alertData", service.getAlertDetails(ewsId));
		return "alertDetails";
	}

	@RequestMapping(value = "/update-alert", method = RequestMethod.POST)
	public String updateAlertDetails(ModelMap modelMap, @Valid Alerts alertData, BindingResult result) {
		service.updateAlertDetails(alertData);
		return "redirect:/list-alerts";
	}

	@RequestMapping(value = "/get-Details", method = RequestMethod.GET)
	public String getAlertDetail(ModelMap modelMap, @RequestParam String jobName, @RequestParam String jobDescription,
			@RequestParam String status, @RequestParam String measure, @RequestParam String summary,
			@RequestParam String detailComments, @RequestParam String owner, @RequestParam String resolutionPlanToClose,
			@RequestParam int executionStep, @RequestParam String runDate) throws ParseException {
		Alerts alerts = service.getAlertDetail(jobName, jobDescription, status, measure, summary, detailComments, owner,
				resolutionPlanToClose, executionStep, dateFormat3.parse(runDate));
		modelMap.put("alertData", alerts == null ? new Alerts() : alerts);
		return "alertDetailsByStatus";
	}
	
	@RequestMapping(value = "/get-Details", method = RequestMethod.POST)
	public String getAlertDetail(ModelMap modelMap, @Valid Alerts alertData, BindingResult result) {
		service.updateAlertDetail(alertData);
		return "redirect:/list-alerts";
	}
}
