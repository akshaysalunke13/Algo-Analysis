import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class DataGenerator {

    public int generateRandInt (int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max-min) + 1) + min;
    }

    public static void main(String[] args) {
        int max;
        ArrayList l = new ArrayList();

        if (args.length > 1){
            System.out.println("Invalid number of tokens.");
            return;
        }
        
        try {
            max = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Only integers.");
            return;
        }
        
        

        for (int i = 1; i <= max; i++) {
            l.add(i);
        }

        Collections.shuffle(l);

        String s = (arrangeNodes(l));
        PrintWriter pw;

        try{
            pw = new PrintWriter(new FileWriter("set2.txt"));
            pw.print(s);
        System.out.println(s);
        pw.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String arrangeNodes(ArrayList l){
        String toReturn;
        toReturn = l.get(0) + "\n";

        int lChild, rChild = 0;
        int parent = 0;

        for(int i = 1; i < l.size(); i++) {
            lChild = i;
            rChild = ++i;

            if ( lChild >= l.size() || rChild >= l.size())
                break;
    
                System.out.println("Progress: " + i + " of " + l.size());
            toReturn += l.get(parent) + " " + l.get(lChild) + " " + l.get(rChild) + "\n";
            parent++;
        }

        return toReturn;
    }
}