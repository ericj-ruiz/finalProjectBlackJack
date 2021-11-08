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
        System.out.println("What decision would you like to make?");
        Scanner dec = new Scanner(System.in);
        String input= dec.nextLine();
        return input;
    }
    public void promptRaise(){System.out.println("How much would you like to raise:");}

    public void promptBankRoll(){
        System.out.println("Hello how much do you have in your bank roll?");
    }
    public void userCards(int user){
        System.out.println("User Card: "+ user);
    }
    public void houseCards(int house){
        System.out.println("House Card: " + house);
    }

}
