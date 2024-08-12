package j100xx;
/*public class j10038 {
    public static void main(String[] args) {
        Integer[] li = new Integer[] {100, 20, 32, 196, 85};
        Integer iv = CommonFun.getMax(li);   //返回iv值为196
        System.out.println(iv);

        Double[] ld = new Double[] {51.0, 10.6, 165.2, 12.0, 82.0};
        Double dv = CommonFun.getMax(ld);   //返回dv值为165.2
        System.out.println(dv);
    }
}*/

class CommonFun {
    public static <T extends Comparable<T>> T getMax(T[] array) {
        T maxElement = array[0];
        for (T element : array) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }
}