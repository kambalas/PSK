package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.University;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Setter
public class UniversitiesDAO {

    @Inject
    private EntityManager entityManager;

    public List<University> getAll(){
        return entityManager.createNamedQuery("University.findAll", University.class).getResultList();
    }

    public void add(University university){
        this.entityManager.persist(university);
    }

    public University getById(Integer id){
        return entityManager.find(University.class, id);
    }
}