package com.admission.school.system.application.service;

import java.util.List;

import com.admission.school.system.application.domain.Course;
import com.admission.school.system.application.domain.Student;
import com.admission.school.system.application.form.StudentForm;
import com.admission.school.system.application.form.StudentSearchForm;

public interface SchoolService {
    public void addSudent(StudentForm studentForm);

    public List<Course> loadCourse();

    public List<Student> findStudent(StudentSearchForm studentSearchForm);

    public String loadCourse(int id);

    public StudentForm findStudent(int rollNo);

    public void updateStudent(StudentForm studentForm);

    public void deleteStudent(int rollNo);

    public List<Course> findCourse(int id);
}
