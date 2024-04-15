package demo;

public class demo0411 {
    public static void main(String[] args) {
        System.out.println(0.1);
    }
    public <T>T func(Class<T> t) throws InstantiationException, IllegalAccessException {
        T t1 = t.newInstance();
        return t1;
    }
}
