package effective.item03;

public enum Elvis {
    INSTANCE;

    public String getMyself() {
        System.out.println("getMyself");
        return "getMyself";
    }
}