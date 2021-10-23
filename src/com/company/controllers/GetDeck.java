package com.company.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetDeck {
    private String[] filledDeck;
    private int[] usedDeck;
    private BufferedReader in;

    public GetDeck(){
        try{
            Path thePath = Paths.get("src/" + "blackjack.txt");

            FileReader fileReader = new FileReader(String.valueOf(thePath));
            in = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<>();
            String line=null;
            try{
                line =in.readLine();
                while(line !=null){
                    lines.add(line);
                    line=in.readLine();
                }
                in.close();
                filledDeck = lines.toArray(new String[lines.size()]);



            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

}


    public void setFilledDeck(String[] filledDeck) {
        this.filledDeck = filledDeck;
    }

    public String[] getFilledDeck() {
        return filledDeck;
    }

    public int[] getUsedDeck() {
        return usedDeck;
    }

    public void setUsedDeck(int[] usedDeck) {
        this.usedDeck = usedDeck;
    }
}
