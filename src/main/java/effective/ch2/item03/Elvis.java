package effective.ch2.item03;

public enum Elvis {
    INSTANCE;

    public String getMyself() {
        System.out.println("getMyself");
        return "getMyself";
    }
}