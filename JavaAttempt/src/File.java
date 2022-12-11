import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class File {
    private String filename = "octoberTransactions.csv";
    String row = "";
    String splitBy = ",";
    String[] transactions;
    ArrayList<Float> credit = new ArrayList<>();
    ArrayList<Float> debit = new ArrayList<>();
    DecimalFormat df = new DecimalFormat(".##");  
    
    public File(String filename)
    {
        this.filename = filename;
    }

    public Object Parse()
    {   
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            while((row = reader.readLine())!=null)
            {
                transactions = row.split(splitBy, -1);
                if(transactions.length > 3)
                {
                    String reducedCredit = transactions[6].replace("\"","");
                    String reducedDebit = transactions[7].replace("\"","");
                    String reducedDebitMinus = reducedDebit.replace("-", "");
                    if(reducedCredit != "")
                    {
                        String item = reducedCredit;
                        // System.out.println(item);
                        credit.add(Float.parseFloat(item));
                        
                    }
                    if(reducedDebitMinus != "")
                    {
                        String d = reducedDebitMinus;
                        // System.out.println(d);
                        debit.add(Float.parseFloat(d));
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        Object object = new Object(credit, debit); 
        return object;   

    }
    
    public void Report(){
        double sumCredit = credit.stream().mapToDouble(n->n).sum();
        double sumDebit = debit.stream().mapToDouble(n->n).sum();
        System.out.println("Total amount earned: $" + df.format(sumCredit));
        System.out.println("Total amount spent: $" + df.format(sumDebit));
    }
}

