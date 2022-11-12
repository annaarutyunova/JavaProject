import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


// Class Scanner is one way to read a CSV file in java
public class App
{
    public static void main(String[] args) 
    {
        String row = "";
        String splitBy = ",";
        String[] transactions;
        ArrayList<Float> credit = new ArrayList<>();
        ArrayList<Float> debit = new ArrayList<>();
        DecimalFormat df = new DecimalFormat(".##");    
        
        
        try{


            BufferedReader reader = new BufferedReader(new FileReader("novemberTransactions.csv"));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            while((row = reader.readLine())!=null){
                transactions = row.split(splitBy, -1);
                if(transactions.length > 3){
                    String reducedCredit = transactions[6].replace("\"","");
                    String reducedDebit = transactions[7].replace("\"","");
                    String reducedDebitMinus = reducedDebit.replace("-", "");
                    if(reducedCredit != ""){
                        String item = reducedCredit;
                        // System.out.println(item);
                        credit.add(Float.parseFloat(item));
                    }
                    if(reducedDebitMinus != ""){
                        String d = reducedDebitMinus;
                        // System.out.println(d);
                        debit.add(Float.parseFloat(d));
                    }
                }
              else{
                        System.out.println("The row is empty");
                    }
            }

            double sumCredit = credit.stream().mapToDouble(n->n).sum();
            double sumDebit = debit.stream().mapToDouble(n->n).sum();
            System.out.println("Total amount earned: $" + df.format(sumCredit));
            System.out.println("Total amount spent: $" + df.format(sumDebit));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
}