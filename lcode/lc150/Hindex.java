package lc150;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Hindex {
    public static int hIndex(int[] citations) {
//        Arrays.sort(citations, Collections.reverseOrder());
        citations = IntStream.of(citations)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(citations));

        for(int i =0; i <= citations.length -1; i++) {
            if(citations[i] <= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] citations = {3,0,6,1,5};

        System.out.println(hIndex(citations));
    }

}
