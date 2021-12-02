package com.company.views;

import java.util.Scanner;

public class CmdLineView {

    public void promptBankRoll(){
        System.out.println("How much $$$ do you have in your bankroll?");

    }


    public int promptContinue(){
        System.out.println("Would you like to continue: 1 = Yes or 0 = No?");
        Scanner con = new Scanner(System.in);
        int in =con.nextInt();
        return in;
    }

    public void greeting() {
        System.out.println("How much $$$ would you like to bet");
    }

    public int promptDecision(){
        System.out.println("What decision would you like to make? Enter 1 = Hit, 2 = Stand");
        Scanner dec = new Scanner(System.in);
        int input= dec.nextInt();
        return input;
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

    public void showTotal(int t){
        System.out.println("Total: "+t);
    }
    public void showBust(){
        System.out.println("You have busted! You LOST!");
    }
    public void houseBust(){
        System.out.println("House has busted! You WIN!");

    }
    public void tie(){
        System.out.println("You tied with the house");
    }
    public void win(){
        System.out.println("You Win!");
    }
    public void lose(){
        System.out.println("You Lost!");
    }
    public void noMoney(){
        System.out.println("You don't have enough $$$ in your Bankroll");
    }


}
