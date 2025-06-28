package lc150;

public class Candy {

    public static void main(String[] args) {

        int[] ratings = {1,2,87,87,87,2,1};
        //int[] ratings = {1,0,2};
        System.out.println(findCandyCount(ratings));

    }

    public static int findCandyCount(int[] ratings){

        int lowest = ratings[0];
        int lowestIndex = 0;
        int[] counts = new int[ratings.length];


        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] <= lowest) {

                lowest = ratings[i];
                lowestIndex = i;
            }
        }
//        System.out.println("Lowest rating found at " + lowestIndex);
        counts[lowestIndex]  = 1;

        int leftCount = 1;
        int leftSide = lowestIndex -1;
        while (leftSide >= 0 ) {
            if(ratings[leftSide] > ratings[leftSide + 1]) {
                counts[leftSide]  = counts[leftSide+1]+1;
//                System.out.println("Right side of left is "+ counts[leftSide+1]);
            } else {
                counts[leftSide] = 1;
            }

//            System.out.println("Left side is at " + leftSide);
            leftSide--;
        }


        int rightSide = lowestIndex + 1;
        while(rightSide < ratings.length) {
            if(ratings[rightSide] > ratings[rightSide -1]) {
                counts[rightSide] = counts[rightSide-1]+1;
            } else {
                counts[rightSide] = 1;
            }
//            System.out.println("Right side is at " + rightSide);
            rightSide++;
        }

        int total = 0;

        for(int c: counts) {
           total += c;
        }

        return total;
    }
}
