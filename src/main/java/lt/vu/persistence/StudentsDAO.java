package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Setter
public class StudentsDAO {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public List<Student> getAll(){
        return entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    @Transactional
    public void add(Student student){
        this.entityManager.persist(student);
    }

    @Transactional
    public Student getById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Transactional
    public void update(Student student){
        this.entityManager.merge(student);
    }

    @Transactional
    public void delete(Integer id) {
        Student studentDbResponse = this.getById(id);
        this.entityManager.remove(studentDbResponse);
    }
}