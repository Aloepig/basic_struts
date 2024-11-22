package formtest.model;

public class CourseDto {

    private boolean courseStruts2 = false;
    private boolean courseSpringBoot = false;
    private boolean courseNodejs = false;
    private CourseState courseStateStruts;
    private CourseState courseStateSpringBoot;
    private CourseState courseStateNodejs;

    public boolean isCourseStruts2() {
        return courseStruts2;
    }

    public void setCourseStruts2(boolean courseStruts2) {
        this.courseStruts2 = courseStruts2;
        this.courseStateStruts = new CourseState(courseStruts2, "Struts2");
    }

    public boolean isCourseSpringBoot() {
        return courseSpringBoot;
    }

    public void setCourseSpringBoot(boolean courseSpringBoot) {
        this.courseSpringBoot = courseSpringBoot;
        this.courseStateSpringBoot = new CourseState(courseSpringBoot, "SpringBoot");
    }

    public boolean isCourseNodejs() {
        return courseNodejs;
    }

    public void setCourseNodejs(boolean courseNodejs) {
        this.courseNodejs = courseNodejs;
        this.courseStateNodejs = new CourseState(courseNodejs, "nodejs");
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
