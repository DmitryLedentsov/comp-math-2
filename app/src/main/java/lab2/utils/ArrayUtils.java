package lab2.utils;

public class ArrayUtils {
    public static <T> boolean contains(T[] arr, T el){
        for(T o: arr) if(o==el) return true;
        return false;
    }
}
