package ch3.model;

public class CourseState {
    final private boolean courseCheck;
    final private String courseName;
    final private String courseDesc;
    private String courseId;

    public CourseState(boolean isCheck, String courseName) {
        if (isCheck) {
            this.courseDesc = "선택";
        } else {
            this.courseDesc = "미선택";
        }

        this.courseCheck = isCheck;
        this.courseName = courseName;
    }

    public CourseState(String courseName, String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseDesc = "미선택";
        this.courseCheck = false;
    }

    public boolean isCourseCheck() {
        return courseCheck;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
