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
            int user1=deal();
            int user2=deal();
           uTotal= view.userCards(user1,user2,uTotal);

            int house1=deal();
            view.houseCards(house1);

        String decision = view.promptDecision();
        do{
            uTotal+=decision(decision,uTotal);
            if(uTotal<=21)
                decision= view.promptDecision();
            //put bust prompt check if total is bust
        }while(decision!="Stand"//or total is bust);



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

    public static int decision(String decis, int total) {
        CmdLineView view = new CmdLineView();
        int t=0;
        if (decis == "Hit") {
            int user3 = deal();
            total += view.hitCards(user3,total);
            t=total;
        }
        else if(decis=="Stand"){
            t=total;
        }
        else if(decis=="See Chart")

        return t;
    }

}
