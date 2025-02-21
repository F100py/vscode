package HanoiSolver;

import java.util.Stack;

public class TowersOfHanoi {
    

    @SuppressWarnings("unchecked")
    static Stack<Integer>[] poles = new Stack[3];


    public static void main(String[] args) {
        int left = 0;
        int mid = 1;
        int right = 2;
        
        int n = 4;
        setup(n);
        int totalMoves = (int)(Math.pow(2, n) - 1);
        if (n % 2 != 0) {
            int temp = mid;
            mid = right;
            right = temp;
        }
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 0) {
                mover(mid, right);
            } else if (i % 3 == 1) {
                mover(left, right);
            } else {
                mover(left, mid);
            }
        }
    }
    
    public static void mover(int begin, int end) {
        if (poles[end].isEmpty() || (!poles[begin].isEmpty() && poles[begin].peek() < poles[end].peek())) {
            System.out.println(begin + " > " + end);
            poles[end].push(poles[begin].pop());
        } else {
            mover(end, begin);
        }
    }
    public static void setup(int n){
        for (int i = 0; i < 3; i++) {
            poles[i] = new Stack<>();
        }
        for (int i = n; i > 0; i--) {
            poles[0].push(i);
        }
    }

}
