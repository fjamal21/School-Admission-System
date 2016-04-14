package com.admission.school.system.application.service.serviceImpl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.admission.school.system.application.dao.CourseDao;
import com.admission.school.system.application.dao.StudentDao;
import com.admission.school.system.application.domain.Course;
import com.admission.school.system.application.domain.Student;
import com.admission.school.system.application.form.StudentForm;
import com.admission.school.system.application.form.StudentSearchForm;
import com.admission.school.system.application.service.SchoolService;

@Service("addmissionService")
public class ServiceImpl implements SchoolService {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Resource(name = "courseDao")
    private CourseDao courseDao;

    public void addSudent(StudentForm studentForm) {
        Timestamp time = new Timestamp(System.currentTimeMillis());

        Student student = new Student();
        //student.setRollNo(studentForm.getRollNo());
        student.setName(studentForm.getName());
        student.setCourse(studentForm.getCourse());
        student.setAddress(studentForm.getAddress());
        student.setPhoneNo(studentForm.getPhoneNo());
        student.setAdmissinDate(time);
        studentDao.addStudent(student);
    }

    public List<Course> loadCourse() {
        return courseDao.loadCourse();
    }

    public List<Student> findStudent(StudentSearchForm studentSearchForm) {
        return studentDao.findStudent(studentSearchForm);
    }

    public String loadCourse(int id) {
        return courseDao.loadCourse(id);
    }

    public StudentForm findStudent(int rollNo) {
        Student student = studentDao.findStudent(rollNo);
        StudentForm studentForm = new StudentForm();

        studentForm.setRollNo(student.getRollNo());
        studentForm.setName(student.getName());
        studentForm.setCourse(student.getCourse());
        studentForm.setAddress(student.getAddress());
        studentForm.setPhoneNo(student.getPhoneNo());

        return studentForm;
    }

    public void updateStudent(StudentForm studentForm) {

        Student student = new Student();
        student.setRollNo(studentForm.getRollNo());
        student.setName(studentForm.getName());
        student.setCourse(studentForm.getCourse());
        student.setAddress(studentForm.getAddress());
        student.setPhoneNo(studentForm.getPhoneNo());
        //student.setAdmissinDate(time);
        studentDao.updateStudent(student);
    }

    public void deleteStudent(int rollNo) {
        studentDao.deleteStudent(rollNo);
    }

    public List<Course> findCourse(int id) {
        return courseDao.findCourse(id);
    }
}
