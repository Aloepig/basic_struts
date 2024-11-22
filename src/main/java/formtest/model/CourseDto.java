package formtest.model;

public class CourseDto {

    private CourseState courseStateStruts;
    private CourseState courseStateSpringBoot;
    private CourseState courseStateNodejs;

    public void setCourseStateStruts(boolean isCHeck) {
        this.courseStateStruts = new CourseState(isCHeck, "Struts2");
    }

    public void setCourseStateSpringBoot(boolean isCHeck) {
        this.courseStateSpringBoot = new CourseState(isCHeck, "SpringBoot");
    }

    public void setCourseStateNodejs(boolean isCHeck) {
        this.courseStateNodejs = new CourseState(isCHeck, "SpringBoot");
    }

    public CourseState getCourseStateStruts() {
        return courseStateStruts;
    }

    public CourseState getCourseStateSpringBoot() {
        return courseStateSpringBoot;
    }

    public CourseState getCourseStateNodejs() {
        return courseStateNodejs;
    }
}
