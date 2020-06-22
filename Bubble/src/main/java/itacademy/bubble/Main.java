package itacademy.bubble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] sequence = new int [] { 25,10,21,8,2,99,15 };

    public static void main(String ar[]){
        System.out.println(Arrays.toString(bubble(sequence)));
        orderedList(sequence);
    }



    static int[] bubble(int[] ints) {
        int i, j, aux;
        for (i = 0; i < ints.length - 1; i++) {
            for (j = 0; j < ints.length - i - 1; j++) {
                if (ints[j + 1] < ints[j]) {
                    aux = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = aux;
                }
            }
        }

        return ints;
    }

    static void orderedList(int... ints){

        Integer[] nums = Arrays.stream(ints).boxed().toArray(Integer[]::new);

        List<Integer> list = Arrays.asList(nums);

        Collections.sort(list);

        list.forEach(elem -> System.out.println(elem));

    }



}
