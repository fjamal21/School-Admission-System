package com.admission.school.system.application.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admission.school.system.application.service.SchoolService;

@SuppressWarnings("unchecked")
@Controller
public class UserController {

    @Resource(name = "addmissionService")
    private SchoolService service;

    @RequestMapping(value = "/load-home-page")
    public String loadHomePage(Map model) {
        return "user/index";
    }

    @RequestMapping(value = "/view-cources")
    public String loadCources(Map<String, List<?>> model, HttpServletRequest request) {
        int id = 0;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
            model.put("courseList", service.findCourse(id));
            return "user/view-courses";
        }
        model.put("courseList", service.loadCourse());
        return "user/view-courses";
    }
}
