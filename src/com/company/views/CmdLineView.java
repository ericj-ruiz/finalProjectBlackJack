package com.company.views;

import java.util.Scanner;

public class CmdLineView {

    public void promptBankRoll(){
        System.out.println("How much $$$ do you have in your bankroll?");

    }


    public int promptContinue(){
        System.out.println(".............................................................");
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
        System.out.println("-------------------");
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
        System.out.println("-------------------");

        if(user1==11 || user2==11){
            int t;
            if(user1==11 && user2==11)
                t=22;
            else
                t=uTotal-10;
            System.out.println("User Total: "+uTotal+" or "+t);

        }
        else
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
        System.out.println("-------------------");
        System.out.println("User Total: "+t);
        System.out.println("-------------------");
    }
    public void showTotal2(int t,int t2){
        System.out.println("-------------------");
        System.out.println("User Total: "+t +" or "+t2);
        System.out.println("-------------------");
    }
    public void showHTotal(int t,int card){
        System.out.println("Hit Card: "+card);
        System.out.println("-------------------");
        System.out.println("House Total: "+t);
        System.out.println("-------------------");
    }
    public void showBust(){
        System.out.println("You have busted! You LOST!");
    }
    public void houseBust(){
        System.out.println("House has busted!");

    }
    public void tie(int br,int bet){
        System.out.println("You tied with the house." + " Your bankroll total is still: $"+br);
    }
    public void win(int br,int bet){
        System.out.println("You Win! $" + bet + " Your bankroll total is now: $"+br);
    }
    public void lose(int br, int bet){
        System.out.println("You Lost! $" + bet + " Your bankroll total is now: $"+br);
    }
    public void notEnuffMoney(int br){
        System.out.println("You don't have enough $$$ in your Bankroll to make that bet, You have $"+br +" in your bankroll make the reasonable bet.");
    }
    public void totals(int ht, int ut){
        System.out.println("House Total: "+ht +" VS User Total: "+ut);
    }
    public void noMoney(){
        System.out.println("You don't have any $$$, YOU ARE BROKE GO MAKE SOME MONEY THEN COME BACK HAVE A NICE DAY!");
    }



}
