package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;

import lt.vu.mybatis.dao.UniversityMapper;
import lt.vu.mybatis.model.University;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

@Model
@Getter @Setter
public class UniversitiesMyBatis {

    @Inject
    private UniversityMapper universityMapper;

    private List<University> universities;


    private University universityCreate = new University();

    @PostConstruct
    public void init() {
        this.loadAllUniversities();
    }

    private void loadAllUniversities() {
        this.universities = universityMapper.selectAll();
    }

    @Transactional
    public String createUniversity() {
        universityMapper.insert(universityCreate);
        return "/mybatis/universities?faces-redirect=true";
    }
}