package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Course;
import lt.vu.entities.Student;
import lt.vu.persistence.CoursesDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class CourseStudents implements Serializable {
    private Integer courseId;
    private Course course; // Assume Course has a List<Student>
    private List<Student> students;

    @Inject
    private CoursesDAO coursesDAO; // Service to interact with course data

    @PostConstruct
    public void init() {
        try {
            courseId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("courseId"));
            loadStudentsForCourse();
        } catch (NumberFormatException e) {
            // Handle the case where courseId is not properly provided
            courseId = null;
        }
    }

    public void loadStudentsForCourse() {
        if (courseId != null) {
            this.course = coursesDAO.getById(courseId);
            this.students = course.getStudents();
        }
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Course getCourse() {
        return course;
    }
}