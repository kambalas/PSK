package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Student;
import lt.vu.entities.University;

import lt.vu.persistence.StudentsDAO;
import lt.vu.persistence.UniversitiesDAO;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@Getter
@Setter
public class StudentsInUniversity implements Serializable {

    @Inject
    private UniversitiesDAO universitiesDAO;

    @Inject
    private StudentsDAO studentsDAO;


    private University university;


    private Student studentCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer universityId = Integer.parseInt(requestParameters.get("universityId"));
        this.university = universitiesDAO.getById(universityId);
    }

    @Transactional
    public void createStudent() {
        studentCreate.setUniversity(this.university);
        studentsDAO.add(studentCreate);
    }
}