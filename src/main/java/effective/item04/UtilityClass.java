package effective.item04;

public class UtilityClass {

    // 인스턴스화를 막음.
    private UtilityClass() {
        throw new AssertionError();
    }

    public String getMessage(){
        return "UtilityClass";
    }
}
