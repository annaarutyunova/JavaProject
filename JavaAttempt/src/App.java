// Class Scanner is one way to read a CSV file in java
public class App
{
    public static void main(String[] args) 
    {
        File file = new File("novemberTransactions.csv");
        Object o = file.Parse();
        // System.out.println(o.a);
        file.Report();
    }
}