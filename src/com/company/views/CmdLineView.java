package com.company.views;

import java.util.Scanner;

public class CmdLineView {


    public int promptContinue(){
        System.out.println("Would you like to continue: 1 = Yes or 0 = No?");
        Scanner con = new Scanner(System.in);
        int in =con.nextInt();
        return in;
    }

    public void greeting() {
        System.out.println("How much would you like to bet");
    }

    public String promptDecision(){
        System.out.println("What decision would you like to make? Hit, Stand, See Chart, See Count?");
        Scanner dec = new Scanner(System.in);
        String input= dec.nextLine();
        return input;
    }
    public void promptRaise(){System.out.println("How much would you like to raise:");}

    public void promptBankRoll(){
        System.out.println("Hello how much do you have in your bank roll?");
    }
    public int userCards(int user1,int user2,int uTotal){
        if(user1 ==11) {
            System.out.println("User Card: 1 or 11");
            uTotal = user1;
        }
        else{
            System.out.println("User Card: " + user1);
            uTotal = user1;
        }
        //hhh
        if(user2 ==11) {
            System.out.println("User Card: 1 or 11");
            uTotal += user2;
            if (uTotal == 22)
                uTotal = 2;
        }
        else {
            System.out.println("User Card: " + user2);
            uTotal += user2;
        }
        System.out.println("User Total: "+uTotal );
        return uTotal;

    }
    public int hitCards(int card,int total){
        if(card ==11) {
            System.out.println("Hit Card: 1 or 11");
            if ((total+card) > 21)
                total+=1;
            else
                total+=card;
        }
        else {
            System.out.println("Hit Card: " + card);
            total+=card;
        }
        return total;

    }
    public void houseCards(int house1){
        if(house1 ==11)
            System.out.println("House Card 1 or 11");
        else
            System.out.println("House Card: " + house1);

    }


}
