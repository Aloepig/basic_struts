package effective.ch11;

public class TestLazyInit {

    static private String computeFieldValue(){
        return "어떤 계산된 초기화 값";
    }

    /**
     * 지연 초기화 홀더 클래스
     */
    private static class FieldHolder {
        static public final String field = computeFieldValue();
    }

    // static 이므로 호출 될때 처음으로 fieldHolder 클래스가 로드 되면서 초기화 실행됨.
    private static String getField() {
        return FieldHolder.field;
    }

    /**
     * 이중검사
     */
    private volatile String instantField;

    private String getInstantField(){
        String result = instantField;
        if(result != null){
            return result;
        }

        synchronized (this){
            if(instantField == null){
                instantField = computeFieldValue();
            }
            return instantField;
        }
    }

}
