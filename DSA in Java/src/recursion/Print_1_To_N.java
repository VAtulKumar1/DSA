package recursion;

public class Print_1_To_N {

    public static void printNumbersReverse(int n){
        // base condition
        if(n == 1){
            System.out.println(n);
            return;
        }
        // induction
        System.out.println(n);
        // hypothesis
        printNumbers(n-1);

    }

    public static void printNumbers(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        printNumbers(n-1);
        System.out.println(n);
    }

    public static void main(String[] args){
        int n = 10;
        printNumbers(n);
    }
}
