package com.admission.school.system.application.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admission.school.system.application.dao.CourseDao;
import com.admission.school.system.application.domain.Course;

@Service("courseDao")
@Transactional
public class CourseDaoImpl implements CourseDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Course> loadCourse() {
        Query query = entityManager.createQuery("FROM Course c order by c.name ASC");
        return query.getResultList();
    }

    public String loadCourse(int id) {
        List<Course> courseList = (List<Course>) entityManager.createQuery("FROM Course c WHERE c.id=" + id)
                .getResultList();
        for (Course c : courseList) {
            return (String) c.getName();
        }
        return "";
    }

    public List<Course> findCourse(int id) {
        return entityManager.createQuery("FROM Course c WHERE c.id=" + id).getResultList();
    }
}
