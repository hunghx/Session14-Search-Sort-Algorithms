package sort;

import search.LinearSearch;
import search.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BubbleSort {
    public static void main(String[] args) {
//        Random random = new Random();
//
//        List<Integer> list = Stream.generate(()->random.nextInt(10000000)).distinct().limit(10000).collect(Collectors.toList());
//
//        Integer[] array = list.toArray(new Integer[list.size()]);
//        Integer[] array1 = Arrays.copyOf(array,array.length);
//        Integer[] array2 = Arrays.copyOf(array,array.length);
//        Integer[] array3 = Arrays.copyOf(array,array.length);
//        long l10 = System.currentTimeMillis();
//        Arrays.sort(new Person[10]);
//        long l11 = System.currentTimeMillis();
//        System.out.println("Merge "+(l11-l10));
//        long l1 = System.currentTimeMillis();
//        bubbleSort(array1);
//        long l2 = System.currentTimeMillis();
//        System.out.println("Bubblesort "+(l2-l1));
//        long l3 = System.currentTimeMillis();
////        selectionSort(array2);
//        long l4 = System.currentTimeMillis();
//        System.out.println("Selectsort "+(l4-l3));
//        long l5 = System.currentTimeMillis();
//        insertSort(array3);
//        long l6 = System.currentTimeMillis();
//        System.out.println("Insertsort "+(l6-l5));
        Person p = new Person(45,"Nam");
        Person[] people = {new Person(10,"Hùng"),p,new Person(50,"Anh"),new Person(40,"Linh")};
        insertSort(people,(o1,o2)->o1.getName().compareTo(o2.getName()));
        insertSort(people,(o1,o2)->o2.getAge()-o1.getAge());
        System.out.println(Arrays.toString(people));


        Integer [] arr = {1,7,34,67,8,3,8};
        Arrays.sort(arr,(o1,o2)->o2-o1);
        System.out.println(Arrays.toString(arr));
    }
    public static <T extends Comparable<T>> void bubbleSort(T[] array){
        boolean flag = true; // 1,2,3,4,5,6,7,8,9; mảng có ít phần thử sai vị trí
        for (int i = 0; i <array.length-1 && flag ; i++) {
            flag = false;
            for (int j = 0; j <array.length-1-i; j++) {
                if(array[j].compareTo(array[j+1])>0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag =true;
                }
            }
        }
    }
    public static <T> void selectionSort(T[] array, Comparator<T> comparator){
        for (int i = 0; i < array.length-1; i++) {
//            Integer min = array[i];
            int indexMin = i;
            for (int j = i+1; j < array.length; j++) {
                if(comparator.compare(array[indexMin],array[j])>0){ // comparator.compare()-> int > 0
                    indexMin = j;
                }
            }
            // đổi chỗ phần tử min với vị trí đầu
            if (indexMin!=i) {
                T tem = array[i] ;
                array[i] = array[indexMin];
                array[indexMin] = tem;
            }
        }
    }
    public  static <T> void insertSort(T[] array,Comparator<T> comparator){
        for (int i = 1; i <array.length ; i++) {
            T insert = array[i];
            int j =i-1;
            while ( j >=0 && comparator.compare(insert,array[j])<0 ) {
                array[j+1] = array[j];
                j--;
            }
            // chèn giá trị insert vào nơi thuôcj về nó
            array[j+1] = insert;
        }
    }
}
