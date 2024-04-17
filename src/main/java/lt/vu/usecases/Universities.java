package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.University;

import lt.vu.persistence.UniversitiesDAO;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
@Getter
@Setter
public class Universities implements Serializable {

    @Inject
    private UniversitiesDAO universitiesDAO;

    private University universityCreate = new University();

    private List<University> universities;

    @PostConstruct
    public void init(){
        loadAllUniversities();
    }

    @Transactional
    public void createUniversity(){
        this.universitiesDAO.add(universityCreate);
    }

    private void loadAllUniversities(){
        this.universities = universitiesDAO.getAll();
    }
}