package code;
////This is the solution the the knapsack 0-1 problem



public class knapsack01 {

    public static int knapscak(int capacity, int[] W, int[] V){

        if( W == null || V == null || W.length != V.length || capacity < 0)
            throw new IllegalArgumentException("Invalid input, please try again");

        final int N = W.length;

        //create a table where individual rows represent items and columns represent weight
        //of the knapsack. DP stands for dyanmic programming

        int[][] DP = new int[N+1][capacity+1];

        for(int i = 1; i <= N; i++){

            int w = W[i-1], v = V[i-1];

            for(int sz = 1; sz <= capacity; sz++) {

                //consider not picking element
                DP[i][sz] = DP[i-1][sz];

                //consider including element and see if it is profitable
                //compared to not picking the element
                if(sz >= w && DP[i-1][sz-w] + v > DP[i][sz])
                    DP[i][sz] = DP[i-1][sz-w] + v;
            }
        }

        int sz = capacity;
        java.util.List<Integer> itemsSelected = new java.util.ArrayList<>();


        // Using the information inside the table we can backtrack and determine
        // which items were selected during the dynamic programming phase. The idea
        // is that if DP[i][sz] != DP[i-1][sz] then the item was selected

        for(int i = N; i > 0; i--){
            if(DP[i][sz] != DP[i-1][sz]){
                int itemIndex = i-1;
                itemsSelected.add(itemIndex);
                sz -= W[itemIndex];
            }
        }

        //option to return items that were selected
        //java.util.Collections.reverse(itemsSelected);

        //return max profit
        return DP[N][capacity];

    }

    public static void main(String[] args){
        int capacity = 180;
        int[] V = {44,55,66,77,22,34,78,90};
        int[] W = {23,42,43,56,75,79,32,67};
        System.out.println(knapscak(capacity,W,V));
    }
}
