package com.presman.chess.Misc;

import com.presman.chess.Main;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

public class ConfigReader {
    public static void getConfigDetails(){
        try{
            File myObj = new File("src/config.txt");
            Scanner reader = new Scanner(myObj);
            while (reader.hasNext()){
                String data = reader.nextLine().split(";")[0];

                //key is property name, value is value of property
                Main.configProperties.put(data.split("=")[0].trim(), data.split("=")[1].trim());

            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
