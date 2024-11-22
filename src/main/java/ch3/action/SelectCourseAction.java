package ch3.action;

import com.opensymphony.xwork2.ActionSupport;
import ch3.model.CourseState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCourseAction extends ActionSupport {

    final private List<String> listCourse = new ArrayList<>();
    private List<String> listCheck;

    final private List<CourseState> courseStates = new ArrayList<>();
    private String courseId;

    final private Map<String,String> mapCourse = new HashMap<>();
    private String courseName;

    public SelectCourseAction() {
        this.listCourse.add("spring1");
        this.listCourse.add("spring2");
        this.listCourse.add("spring3");

        this.mapCourse.put("M1", "Spring1");
        this.mapCourse.put("M2", "Spring2");
        this.mapCourse.put("M3", "Spring3");

        this.courseStates.add(new CourseState("spring1", "CH1"));
        this.courseStates.add(new CourseState("spring2", "CH22"));
        this.courseStates.add(new CourseState("spring3", "CH33"));
    }

    public List<CourseState> getCourseStates() {
        return courseStates;
    }

    public List<String> getListCourse() {
        return listCourse;
    }

    public List<String> getListCheck() {
        return listCheck;
    }

    public void setListCheck(List<String> listCheck) {
        this.listCheck = listCheck;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Map<String, String> getMapCourse() {
        return mapCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
