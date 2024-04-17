package lt.vu.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import lombok.Setter;
import lt.vu.entities.Course;

import java.util.List;

@ApplicationScoped
@Setter
public class CoursesDAO {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public List<Course> getAll() {
        return entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();
    }

    @Transactional
    public void add(Course course){
        this.entityManager.persist(course);
    }

    @Transactional
    public Course getById(Integer id){
        return entityManager.find(Course.class, id);
    }

    @Transactional
    public void update(Course course){
        this.entityManager.merge(course);
    }
}