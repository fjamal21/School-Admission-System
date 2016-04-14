package com.admission.school.system.application.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admission.school.system.application.form.StudentForm;
import com.admission.school.system.application.form.StudentSearchForm;
import com.admission.school.system.application.service.SchoolService;

@SuppressWarnings("unchecked")
@Controller
public class AdminCotroller {

    @Resource(name = "addmissionService")
    private SchoolService service;

    @RequestMapping(value = "/admin/load-home-page")
    public String loadHomePage(Map<?, ?> model) {
        return "admin/index";
    }

    @RequestMapping(value = "/admin/load-student-form")
    public String loadStudentForm(Map<String, Object> model, StudentForm studentForm, HttpServletRequest request) {
        if (request.getParameter("id") != null) {
            int rollNo = Integer.parseInt(request.getParameter("id"));
            studentForm = service.findStudent(rollNo);
        }
        if (request.getParameter("courseId") != null) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            studentForm.setCourse(courseId);
        }
        model.put("studentForm", studentForm);
        model.put("courseList", service.loadCourse());
        return "admin/student-form";
    }

    @RequestMapping(value = "/admin/add-update-student")
    public String addUpdateStudent(Map<String, Object> model, StudentForm studentForm) {
        model.put("studentForm", studentForm);
        model.put("courseList", service.loadCourse());
        if (studentForm.getRollNo() != null) {
            System.out.println("Updating Records to the Database");
            service.updateStudent(studentForm);
            return "forward:/admin/search";
        } else {
            System.out.println("Saving Records to the Database");
            service.addSudent(studentForm);
            return "forward:/admin/load-home-page";
        }
    }

    @RequestMapping(value = "/admin/search-student")
    public String searchStudent(Map<String, Object> model, StudentSearchForm studentSearchForm) {
        model.put("courseList", service.loadCourse());
        model.put("studentSearchForm", studentSearchForm);
        return "admin/student-search-form";
    }

    @RequestMapping(value = "/admin/search")
    public String search(Map<String, Object> model, StudentSearchForm studentSearchForm) {
        model.put("courseList", service.loadCourse());
        model.put("studentSearchForm", studentSearchForm);
        model.put("studentList", service.findStudent(studentSearchForm));
        return "admin/student-search-form";
    }

    @RequestMapping(value = "/admin/delete-student")
    public String delete(Map<String, StudentSearchForm> model, StudentSearchForm studentSearchForm,
            HttpServletRequest request) {
        model.put("studentSearchForm", studentSearchForm);
        int rollNo = 0;
        if (request.getParameter("id") != null) {
            rollNo = Integer.parseInt(request.getParameter("id"));
            service.deleteStudent(rollNo);
        }
        return "forward:/admin/search-student";
    }

}
