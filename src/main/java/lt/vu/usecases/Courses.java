package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Course;
import lt.vu.persistence.CoursesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
@Getter
@Setter
public class Courses implements Serializable {

    @Inject
    private CoursesDAO coursesDAO;

    private Course course;


    private Course courseCreate = new Course();


    private List<Course> courses;

    @PostConstruct
    public void init() {
        loadAllCourses();
//        Map<String, String> requestParameters =
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        Integer universityId = Integer.parseInt(requestParameters.get("universityId"));
//        this.course = coursesDAO.getById(universityId);
    }

    @Transactional
    public void createCourse(){
        this.coursesDAO.add(courseCreate);
    }

    private void loadAllCourses(){
        this.courses = coursesDAO.getAll();
    }
}