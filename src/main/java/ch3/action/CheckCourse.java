package ch3.action;

import com.opensymphony.xwork2.ActionSupport;
import ch3.model.CourseDto;

public class CheckCourse extends ActionSupport {

    private CourseDto courseDto;

    public String execute() throws Exception {

        return SUCCESS;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }
}
