package search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("helo");
        Person p = new Person(45);
        Person[] integers = {new Person(10),p,new Person(50),new Person(40)};
        System.out.println(indexOfNoDeQuy(integers,p));
        System.out.println(Arrays.toString(integers));
    }

//    mô tả thuật toán
    // ko sử dụng đệ qui

    public static <T extends Comparable<T>> int indexOfNoDeQuy(T[] array ,T t){
       Arrays.sort(array);
       // sau khi sắp xếp
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = start/2+end/2;
            if(Objects.equals(array[mid],t)){
                return mid;
            }
            if (array[mid].compareTo(t)<0){
                start = mid+1;
            }else {
                end =mid-1;
            }
        }
        return -1;
    }
    public static <T extends Comparable<T>> int indexOfDeQuy(T[] array,int start,int end ,T t){
        while (start<=end){
            int mid = start+(end-start)/2;
            if(Objects.equals(array[mid],t)){
                return mid;
            }
            if (array[mid].compareTo(t)<0){
              return indexOfDeQuy(array,mid+1,end,t);
            }else {
                indexOfDeQuy(array,start,mid-1,t);
            }
        }
        return -1;
    }
}
