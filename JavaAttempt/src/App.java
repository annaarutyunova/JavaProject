import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// public class App {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");

//         int day = 4;
//         switch(day){
//             case 1:
//                 System.out.println("Saturday");
//                 break;
//             case 2:
//                 System.out.println("Tuesday");
//                 break;
//             case 5:
//                 System.out.println("Friday");
//                 break;
//             default:
//                 System.out.println("I don't know what day it is");
//                 break;
//         }

//         int i = 1;
//         do {
//             System.out.println(i);
//             i++;
//         }
//         while(i<6);

//         for(int a = 0; a <5; a++) {
//             System.out.println("Yes");
//         }

//         // Create a new ArrayList
//         ArrayList<String> arrList = new ArrayList<>();

//         // Add items to it
//         arrList.add("carrots");
//         arrList.add("eggs");

//         // Add item of index 0 (so, to the beginning of it). And print it line by line
//         arrList.add(0,"meat");
//         System.out.println("ArrayListElements: ");
//         for (String str:arrList)
//             System.out.println(str);
    
//     }



// }

// Class Scanner is one way to read a CSV file in java
public class App
{
    public static void main(String[] args) 
    {
        String row = "";
        String splitBy = ",";
        String[] transactions;
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<ArrayList<String>> records = new ArrayList<>();

        try{


            BufferedReader reader = new BufferedReader(new FileReader("octoberTransactions.csv"));
            while((row = reader.readLine())!=null){
                transactions = row.split(splitBy);
                if(transactions.length == 8){
                    if(transactions[6].replace("\"","") != ""){
                        String item = transactions[6];
                        System.out.println(item);
                        numbers.add(item);
                        System.out.println(numbers.get(0));
                    }
                }
              else{
                        System.out.println("The row is empty");
                    }

            // if((row = reader.readLine()) != null){
            //     transactions = row.split(splitBy);
            //     System.out.println(transactions.length);
            // }

            
           
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
}