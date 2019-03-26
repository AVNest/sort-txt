import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args){
    }
    public static int[] sort(int[] array){
        if(array.length <= 1){
            return array;
        }

        int middle = array.length/2;
        int[] left = sort(Arrays.copyOfRange(array, 0, middle));
        int[] right = sort(Arrays.copyOfRange(array, middle, array.length));

        return merge(left, right, 0);
    }

    public static int[] asort(int[] array){
        if(array.length <= 1){
            return array;
        }

        int middle = array.length/2;

        int[] left = asort(Arrays.copyOfRange(array, 0, middle));
        int[] right = asort(Arrays.copyOfRange(array, middle, array.length));

        return merge(left, right, 1);
    }

    public static String[] string_sort(String[] array){
        if(array.length <= 1){
            return array;
        }

        int middle = array.length/2;

        String[] left = string_sort(Arrays.copyOfRange(array, 0, middle));
        String[] right = string_sort(Arrays.copyOfRange(array, middle, array.length));

        return string_merge(left, right, 0);
    }

    public static String[] string_asort(String[] array){
        if(array.length <= 1){
            return array;
        }

        int middle = array.length/2;

        String[] left = string_asort(Arrays.copyOfRange(array, 0, middle));
        String[] right = string_asort(Arrays.copyOfRange(array, middle, array.length));

        return string_merge(left, right, 1);
    }

    private static String[] string_merge(String[] left, String[] right, int mode){
        List<String> result = new ArrayList<String>();

        int charIndex = 0;

        while(left.length > 0 && right.length > 0){
            if(mode == 0){
                if(charIndex < left[0].length() && charIndex < right[0].length()) {
                    if(left[0].charAt(charIndex) < right[0].charAt(charIndex)){
                        result.add(left[0]);
                        left = Arrays.copyOfRange(left, 1, left.length);
                        charIndex = 0;
                    }else if(left[0].charAt(charIndex) > right[0].charAt(charIndex)){
                        result.add(right[0]);
                        right = Arrays.copyOfRange(right, 1, right.length);
                        charIndex = 0;
                    }else{
                        charIndex++;
                    }
                }else{
                    result.add(right[0]);
                    right = Arrays.copyOfRange(right, 1, right.length);
                    charIndex = 0;
                }
            }else if(mode == 1){
                if(charIndex < left[0].length() && charIndex < right[0].length()) {
                    if(left[0].charAt(charIndex) > right[0].charAt(charIndex)){
                        result.add(left[0]);
                        left = Arrays.copyOfRange(left, 1, left.length);
                        charIndex = 0;
                    }else if(left[0].charAt(charIndex) < right[0].charAt(charIndex)){
                        result.add(right[0]);
                        right = Arrays.copyOfRange(right, 1, right.length);
                        charIndex = 0;
                    }else{
                        charIndex++;
                    }
                }else{
                    result.add(right[0]);
                    right = Arrays.copyOfRange(right, 1, right.length);
                    charIndex = 0;
                }
            }
        }

        if(left.length > 0){
            for(int i = 0; i < left.length; i++){
                result.add(left[i]);
            }
        }

        if(right.length > 0){
            for(int i = 0; i < right.length; i++){
                result.add(right[i]);
            }
        }

        String[] tmp = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            tmp[i] = result.get(i);
        }
        return tmp;
    }

    private static int[] merge(int[] left, int[] right, int mode){

        List<Integer> result = new ArrayList<Integer>();

        while(left.length > 0 && right.length > 0){
            if(mode == 1){
                if(left[0] >= right[0]){
                    result.add(left[0]);
                    left = Arrays.copyOfRange(left, 1, left.length);
                }else{
                    result.add(right[0]);
                    right = Arrays.copyOfRange(right, 1, right.length);
                }
            }else if(mode == 0){
                if(left[0] <= right[0]){
                    result.add(left[0]);
                    left = Arrays.copyOfRange(left, 1, left.length);
                }else{
                    result.add(right[0]);
                    right = Arrays.copyOfRange(right, 1, right.length);
                }
            }
        }

        if(left.length > 0){
            for(int i = 0; i < left.length; i++){
                result.add(left[i]);
            }
        }

        if(right.length > 0){
            for(int i = 0; i < right.length; i++){
                result.add(right[i]);
            }
        }

        int[] tmp = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            tmp[i] = result.get(i);
        }

        return tmp;
    }

}
