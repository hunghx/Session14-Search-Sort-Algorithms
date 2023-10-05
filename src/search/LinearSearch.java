package search;

import java.util.Objects;

public class LinearSearch {
    // tìm kiếm tuyến tính : lần luợt duyệt qua từng phân từ
    public static void main(String[] args) {
        String[] array = {"Một","Hai","Ba","Bốn","Năm","Sáu"};
        System.out.println(indexOf(array,"Năm"));
    }
    // mô tả thuật toán tìm kiếm tuyến tính (Array)
    public static <T> int indexOf(T[] array , T t){
        for (int i = 0; i < array.length; i++) {
            if(Objects.equals(array[i],t)){
                return i;
            }
        }
        return -1;
    }
}
