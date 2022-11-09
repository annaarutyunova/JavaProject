import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int day = 4;
        switch(day){
            case 1:
                System.out.println("Saturday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("I don't know what day it is");
                break;
        }

        int i = 1;
        do {
            System.out.println(i);
            i++;
        }
        while(i<6);

        for(int a = 0; a <5; a++) {
            System.out.println("Yes");
        }

        // Create a new ArrayList
        ArrayList<String> arrList = new ArrayList<>();

        // Add items to it
        arrList.add("carrots");
        arrList.add("eggs");

        // Add item of index 0 (so, to the beginning of it). And print it line by line
        arrList.add(0,"meat");
        System.out.println("ArrayListElements: ");
        for (String str:arrList)
            System.out.println(str);
    
    }



}

