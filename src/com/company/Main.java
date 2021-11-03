package com.company;

import com.company.views.CmdLineView;

import java.util.Scanner;

public class Main {
    public static CmdLineView view;
    public static int bankRoll;
    public static int pot;

    public static void main(String[] args) {
	int cont =1;
    bankRoll=100;
        Scanner input = new Scanner(System.in);
    while(cont ==1){
        view.greeting();
        pot= input.nextInt();
        bankRoll-=pot;

    }
    }
}
