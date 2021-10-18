package com.company.controllers;

public class GetDeck {
    private int[] filledDeck;
    private int[] usedDeck;



    public void setFilledDeck(int[] filledDeck) {
        this.filledDeck = filledDeck;
    }

    public int[] getFilledDeck() {
        return filledDeck;
    }

    public int[] getUsedDeck() {
        return usedDeck;
    }

    public void setUsedDeck(int[] usedDeck) {
        this.usedDeck = usedDeck;
    }
}
