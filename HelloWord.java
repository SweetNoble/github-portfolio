import java.util.*;
public class JavaApplication3 {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Addition");
        System.out.println("Subtraction ");
        System.out.println("Multiplication");
        System.out.println("Division");
        System.out.print("Enter an operator: ");
        String ans = s.nextLine();
        if(ans.equalsIgnoreCase("Addition")){
            System.out.print("Enter number: ");
            float num1 = s.nextFloat();
            System.out.print("Enter second number: ");
            float num2 = s.nextFloat();
            System.out.println("The answer is "+(num1+num2));
        }else if(ans.equalsIgnoreCase("Subtraction")){
            System.out.print("Enter number: ");
            float num1 = s.nextFloat();
            System.out.print("Enter second number: ");
            float num2 = s.nextFloat();
            System.out.println("The answer is "+(num1-num2));
        }else if(ans.equalsIgnoreCase("Multiplication")){
            System.out.print("Enter number: ");
            float num1 = s.nextFloat();
            System.out.print("Enter second number: ");
            float num2 = s.nextFloat();
            System.out.println("The answer is "+(num1*num2));
            
        }else if(ans.equalsIgnoreCase("Division")){
           System.out.print("Enter number: ");
            float num1 = s.nextFloat();
            System.out.print("Enter second number: ");
            float num2 = s.nextFloat();
            System.out.println("The answer is "+(num1/num2));
            
        }else{
            System.out.println("Unknown error");
        }
        
        
        
        
    }
    
}