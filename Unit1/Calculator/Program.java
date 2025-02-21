package Calculator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an equation with spaces between numbers and operators, quit or exit to leave: ");
        String thing = "";
        while (!(thing.equalsIgnoreCase("quit")||thing.equalsIgnoreCase("exit"))){
            try{
                thing = s.nextLine();
                @SuppressWarnings("unused")
                NumCalc actual = new NumCalc(thing);
                System.out.print("Enter an equation with spaces between numbers and operators, quit or exit to leave: ");
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.print("Enter an equation with spaces between numbers and operators, quit or exit to leave: ");
            }
        }
        s.close();
    }
}
