import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.*;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.text.DecimalFormat;


// Class Scanner is one way to read a CSV file in java
public class App
{
    public static void main(String[] args) 
    {
        String row = "";
        String splitBy = ",";
        String[] transactions;
        ArrayList<Float> numbers = new ArrayList<>();
        ArrayList<ArrayList<String>> records = new ArrayList<>();
        DecimalFormat df = new DecimalFormat(".##");    
        
        
        try{


            BufferedReader reader = new BufferedReader(new FileReader("octoberTransactions.csv"));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            while((row = reader.readLine())!=null){
                transactions = row.split(splitBy, -1);
                if(transactions.length == 8){
                    String reduced = transactions[6].replace("\"","");
                    if(reduced != ""){
                        String item = reduced;
                        System.out.println(item);
                        numbers.add(Float.parseFloat(item));
                    }
                }
              else{
                        System.out.println("The row is empty");
                    }
            }

            double sum = numbers.stream().mapToDouble(n->n).sum();
            System.out.println(df.format(sum));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
}