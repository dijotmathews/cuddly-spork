
package lc150;

public class CandyDistribution {

  public static int candy(int[] ratings) {
    int[] child = new int[ratings.length];

    for (int i = 0; i < child.length; i++) {
      child[i] = 1;
    }

    for (int i = 1; i < child.length; i++) {
//      System.out.println("rating at i %d and rating at i -1 %d", ratings[i], ratings[i - 1]);
      if (ratings[i] > ratings[i - 1]) {
        child[i] = child[i - 1] + 1;
      }
    }

    for (int i = child.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {

        child[i] = Math.max(child[i], child[i + 1] + 1);
      }

    }
    int result = 0;
    for (int j : child) {
      result += j;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] ratings = { 1, 2, 2 };

    System.out.println(candy(ratings));
  }
}
