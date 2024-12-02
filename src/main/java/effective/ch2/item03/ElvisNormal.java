package effective.ch2.item03;

public class ElvisNormal {
    private static final ElvisNormal INSTANCE = new ElvisNormal();
    private ElvisNormal() {

    }
    public static ElvisNormal getInstance() {
        return INSTANCE;
    }

    public String getMessage() {
        return "message";
    }
}
