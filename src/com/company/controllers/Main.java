package com.company.controllers;

import com.company.controllers.GetDeck;
import com.company.views.CmdLineView;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int bankRoll;
    public static int pot;
    public static String deck[];
    public static int loopcheck;



    public static void main(String[] args) {
	int cont =1;
    CmdLineView view = new CmdLineView();
    Scanner input = new Scanner(System.in);
    view.promptBankRoll();
    bankRoll=input.nextInt();

    while(cont ==1){
        view.greeting();
        pot= input.nextInt();
        if(pot<=bankRoll) {
            int uTotal = 0;
            int hTotal = 0;
            int user1 = deal();
            int user2 = deal();
            uTotal = view.userCards(user1, user2, uTotal);

            int house1 = deal();
            hTotal = house1;
            view.houseCards(house1);
            loopcheck=0;
            int decision = view.promptDecision();
            do {
                uTotal = decision(decision, uTotal,user1,user2);

                if (uTotal > 21) {
                    view.showBust();
                    bankRoll-=pot;
                    view.lose(bankRoll,pot);
                    break;
                }
                if (decision != 2)
                    decision = view.promptDecision();

            } while (decision != 2);
            if (uTotal <= 21) {
                hTotal = dealerDeal(hTotal, house1);
                if (hTotal <= 21) {
                    if (uTotal == hTotal) {
                        view.totals(hTotal, uTotal);
                        view.tie(bankRoll,pot);

                    }
                    else if (uTotal > hTotal) {
                        view.totals(hTotal,uTotal);
                        bankRoll+=pot;
                        view.win(bankRoll,pot);
                    }
                    else {
                        view.totals(hTotal,uTotal);
                        bankRoll-=pot;
                        view.lose(bankRoll,pot);
                    }
                }
                else if(hTotal>21){
                    view.totals(hTotal,uTotal);
                    bankRoll+=pot;
                    view.win(bankRoll,pot);
                }

                }

            cont = view.promptContinue();
        }
        else
        {
            if(bankRoll==0){
                view.noMoney();
                cont=0;
            }
            else{
                view.notEnuffMoney(bankRoll);
                cont = view.promptContinue();
            }


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

    public static int decision(int decis, int total,int u1, int u2) {
        CmdLineView view = new CmdLineView();
        int t=0;

        if (decis == 1) {
            int user3 = deal();
            int check =total;
            check+=user3;
            if(check>21 && loopcheck==0)//once entered once it should stop
            {
                if(u1==11||u2==11){
                    total-=10;
                    loopcheck=1;
                }
//check once  with user 1 or 11last hit and stand to see if the total is accurate
            }
           // if(u1==11||u2==11)
               // loopcheck=1;
            total = view.hitCards(user3,total);
            t=total;

               // if (loopcheck==1&& total<21) {
                  //  view.showTotal2(t, t - 10);
                  //  if(check<21)
                     //   loopcheck=0;
                   // else
                    //    loopcheck=2;
               // }
                //else
                    view.showTotal(t);

        }
        else if(decis== 2){
            t=total;
        }


        return t;
    }

    public static int dealerDeal(int total,int house1){
        CmdLineView view = new CmdLineView();

        //check to see if hit card 11 changes
        int house2=deal();
        total+=house2;
        view.showHTotal(total,house2);
        while(total <17) {
            int house3 = deal();
            total+=house3;
            if(total>21)
            {
                if(house1==11) {
                    total -= 10;
                    house1=1;
                }
                if(house2==11) {
                    total -= 10;
                    house2=1;
                }
                if(house3==11) {
                    total -= 10;
                    house3=1;
                }
            }
            view.showHTotal(total,house3);
            if(total > 21)
                view.houseBust();
        }

        return total;
    }

}
