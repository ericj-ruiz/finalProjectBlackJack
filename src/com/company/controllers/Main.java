package com.company.controllers;

import com.company.controllers.GetDeck;
import com.company.views.CmdLineView;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int bankRoll;
    public static int pot;
    public static String deck[];



    public static void main(String[] args) {
	int cont =1;
    CmdLineView view = new CmdLineView();
    Scanner input = new Scanner(System.in);
    view.promptBankRoll();
    bankRoll=input.nextInt();

    while(cont ==1){
        //break if bankroll is not enough
        view.greeting();
        pot= input.nextInt();
        if(pot<=bankRoll) {
            bankRoll -= pot;
            //if()
            int uTotal = 0;
            int hTotal = 0;
            int user1 = deal();
            int user2 = deal();
            uTotal = view.userCards(user1, user2, uTotal);

            int house1 = deal();
            hTotal = house1;
            view.houseCards(house1);

            int decision = view.promptDecision();
            do {
                uTotal = decision(decision, uTotal);

                if (uTotal > 21) {
                    view.showBust();
                    break;
                }
                if (decision != 2)
                    decision = view.promptDecision();

            } while (decision != 2);
            if (uTotal <= 21) {
                hTotal = dealerDeal(hTotal, house1);
                if (hTotal < 21) {//show totals
                    if (uTotal == hTotal)
                        view.tie();
                    else if (uTotal > hTotal)
                        view.win();
                    else
                        view.lose();

                }
            }
            //add or subtract winnings
            cont = view.promptContinue();
        }
        else
        {
            view.noMoney();
            cont=0;
        }
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
        {
            n=11;

        }
        else if(n ==9 || n ==22 || n==35 ||n==48)
        {
            n = 10;

        }
        else if(n ==49 || n ==36 || n==23 ||n==10)
        {
            n=10;

        }
        else if(n ==11 || n ==24 || n==37 ||n==50)
        {
            n=10;

        }
        else
        {
            n = Integer.parseInt(card);

        }
        return n;
    }

    public static int decision(int decis, int total) {
        CmdLineView view = new CmdLineView();
        int t=0;

        if (decis == 1) {
            int user3 = deal();
            total = view.hitCards(user3,total);
            t=total;
            view.showTotal(t);
        }
        else if(decis== 2){
            t=total;
        }


        return t;
    }

    public static int dealerDeal(int total,int house1){
        CmdLineView view = new CmdLineView();
        int house2=deal();
        total+=house2;
        while(total <17) {
            int house3 = deal();
            total+=house3;
            if(total > 21)
                view.houseBust();
        }
        //check first card if 1 or 11
        //add until 17 or bust
        //show totals
        return total;
    }

}
