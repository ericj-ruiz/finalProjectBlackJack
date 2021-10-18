package com.company.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetChart {
    private BufferedReader in;
    private String[] chart;

    public GetWord() {
        try{
            Path thePath = Paths.get("src/" + "bsChart.txt");

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
                chart = lines.toArray(new String[lines.size()]);



            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


}
