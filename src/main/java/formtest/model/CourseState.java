package formtest.model;

public class CourseState {
    final private boolean courseCheck;
    final private String courseName;
    final private String courseDesc;

    public CourseState(boolean isCheck, String courseName){
        if(isCheck){
            this.courseDesc = "선택";
        } else {
            this.courseDesc = "미선택";
        }

        this.courseCheck = isCheck;
        this.courseName = courseName;
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

}
