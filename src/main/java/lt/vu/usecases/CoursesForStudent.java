package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Course;
import lt.vu.entities.Student;
import lt.vu.entities.University;
import lt.vu.persistence.CoursesDAO;
import lt.vu.persistence.StudentsDAO;
import lt.vu.persistence.UniversitiesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
@Getter
@Setter
public class CoursesForStudent implements Serializable {

    @Inject
    private CoursesDAO coursesDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Inject
    private UniversitiesDAO universitiesDAO;


    private Integer courseId;


    private University university;

    private Student student;


    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer universityId = Integer.parseInt(requestParameters.get("universityId"));
        this.university = universitiesDAO.getById(universityId);
        Integer studentId = Integer.parseInt(requestParameters.get("studentId"));
        this.student = studentsDAO.getById(studentId);
    }

    @Transactional
    public void assignCourse(){
        Course course = coursesDAO.getById(this.courseId);
        course.getStudents().add(this.student);
        coursesDAO.update(course);
        student.getCourses().add(course);
        studentsDAO.update(student);
    }
}
