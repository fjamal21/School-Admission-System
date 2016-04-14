package com.admission.school.system.application.dao;

import java.util.List;

import com.admission.school.system.application.domain.Course;

public interface CourseDao {
    public List<Course> loadCourse();

    public String loadCourse(int id);

    public List<Course> findCourse(int id);
}
