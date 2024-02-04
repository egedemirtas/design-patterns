public class LazyClass {
    private static LazyClass obj;
    private LazyClass(){}

    public static LazyClass getLazyClass(){
        if (obj == null){
            obj = new LazyClass();
        }
        return obj;
    }
}
