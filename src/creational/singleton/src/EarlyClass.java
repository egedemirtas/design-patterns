public class EarlyClass {
    private static EarlyClass obj = new EarlyClass();//Early, instance will be created at load time

    private EarlyClass() {
    }

    public static EarlyClass getA() {
        return obj;
    }
}
