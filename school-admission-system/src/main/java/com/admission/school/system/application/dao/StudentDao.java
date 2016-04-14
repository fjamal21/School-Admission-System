package com.admission.school.system.application.dao;

import java.util.List;

import com.admission.school.system.application.domain.Student;
import com.admission.school.system.application.form.StudentSearchForm;

public interface StudentDao {
    public void addStudent(Student student);

    public List<Student> findStudent(StudentSearchForm studentSearchForm);

    public Student findStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(int rollNo);
}
