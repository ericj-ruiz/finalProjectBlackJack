package com.company;

import com.company.controllers.GetDeck;
import com.company.views.CmdLineView;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int bankRoll;
    public static int pot;
    public static String usedDeck[];
    public static String deck[];



    public static void main(String[] args) {
	int cont =1;
    CmdLineView view = new CmdLineView();
    Scanner input = new Scanner(System.in);
    //view.promptBankRoll();
    //bankRoll=input.nextInt();
    while(cont ==1){
        view.greeting();
        pot= input.nextInt();
        bankRoll-=pot;
        int uTotal=0;
        int hTotal=0;
        for(int i =0;i<2;i++){
            int user=deal();
            uTotal+=user;
            view.userCards(user);
            int house=deal();
            hTotal+=house;
            view.houseCards(house);
        }
        //String decision = view.promptDecision();




       // cont= view.promptContinue();
    }
    }

    private static int deal(){
        GetDeck d =new GetDeck();

        deck= d.getFilledDeck();
        Random rand = new Random();
        int n = rand.nextInt(52);
        String card;
        card =deck[n];
        if(n == 12|| n==51||n==38||n==25 )
            n=11;
        else if(n ==9 || n ==22 || n==35 ||n==48)
            n = 10;
        else if(n ==49 || n ==36 || n==23 ||n==10)
            n=10;
        else if(n ==11 || n ==24 || n==37 ||n==50)
            n=10;
        else
            n = Integer.parseInt(card);
        return n;
    }
}
