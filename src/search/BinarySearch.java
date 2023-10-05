package search;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinarySearch {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("helo");
//        Person p = new Person(45);
//        Person[] integers = {new Person(10),p,new Person(50),new Person(40)};
        List<Integer> list = Stream.generate(()->random.nextInt(1000000000)).distinct().limit(1000000).collect(Collectors.toList());
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array);


        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        long l1 = System.currentTimeMillis();
        LinearSearch.indexOf(array,999994308);
        long l2 = System.currentTimeMillis();
        System.out.println("thơiif gian thuc hiện tim kiem nhi phan ko de qui "+ (l2-l1));
        long l3 = System.currentTimeMillis();
        indexOfDeQuy(array,0,array.length-1,999994308);
        long l4 = System.currentTimeMillis();
        System.out.println("thơif gian thuc hiện tim kiem nhi phan co de qui "+ (l4-l3));
        System.out.println(array.length);
    }

//    mô tả thuật toán
    // ko sử dụng đệ qui

    public static <T extends Comparable<T>> int indexOfNoDeQuy(T[] array ,T t){

       // sau khi sắp xếp
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
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

        if (start<=end){
            int mid = start+(end-start)/2;
            if(Objects.equals(array[mid],t)){
                return mid;
            }
            if (array[mid].compareTo(t)<0){
               return indexOfDeQuy(array,mid+1,end,t);
            }else {
               return indexOfDeQuy(array,start,mid-1,t);
            }
        }
        return -1;
    }
}
