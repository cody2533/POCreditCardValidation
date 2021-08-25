import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Enter Card Number Here");
        System.out.println(validateCard(sb));

    }

    public static boolean validateCard(StringBuilder card){
        if(card.length() < 14 || card.length() > 19){
            return false;
        }

        int check = Integer.parseInt(card.substring(card.length()-1));
        card.deleteCharAt(card.length()-1);
        card.reverse();
        int sum = 0;
        for(int i = 0; i < card.length(); i++){
            int temp = Integer.parseInt(card.substring(i, i+1));
            if(i%2 == 0){
                temp *= 2;
                if(temp >= 10){
                    temp = (temp%10) + (temp/10);
                }
            }
            sum += temp;
        }

        return check == (10 - (sum%10));
    }

}
