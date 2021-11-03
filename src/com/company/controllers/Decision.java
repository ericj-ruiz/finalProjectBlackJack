package com.company.controllers;

import com.company.views.CmdLineView;

import java.util.Scanner;

public class Decision extends GetDeck {
    private String decision;
    public int bankRoll;
    public int pot;

    public Decision(String decision, int bankRoll, int pot) {
        Scanner deci =new Scanner(System.in);
        if (decision == "raise"){
            CmdLineView view =new CmdLineView();
            view.promptRaise();
            int raise = deci.nextInt();
            bankRoll-=raise;
            pot+=raise;
        }
        else if(decision == "hit"){

        }

    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public int getBankRoll() {
        return bankRoll;
    }

    public void setBankRoll(int bankRoll) {
        this.bankRoll = bankRoll;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }
}

