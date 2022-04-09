import java.util.HashMap;
import java.io.File;
import java.util.*;
import java.io.*; 
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
//import javafx.util.*;

public class assign1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> optab = new HashMap<String, ArrayList<String>>();
        HashMap<String, String> registertable = new HashMap<String, String>();
        HashMap<String, String> bctable = new HashMap<String, String>();

        HashMap<String, String> symtab = new HashMap<String, String>();
        HashMap<String, String> literaltab = new HashMap<String, String>();

        optab.put("STOP", new ArrayList<String>(Arrays.asList("(IS,00)")));
        optab.put("ADD", new ArrayList<String>(Arrays.asList("(IS,01)")));
        optab.put("SUB", new ArrayList<String>(Arrays.asList("(IS,02)")));
        optab.put("MULT", new ArrayList<String>(Arrays.asList("(IS,03)")));
        optab.put("MOVER", new ArrayList<String>(Arrays.asList("(IS,04")));
        optab.put("MOVEM", new ArrayList<String>(Arrays.asList("(IS,05)")));
        optab.put("COMP", new ArrayList<String>(Arrays.asList("(IS,06)")));
        optab.put("BC", new ArrayList<String>(Arrays.asList("(IS,07)")));
        optab.put("DIV", new ArrayList<String>(Arrays.asList("(IS,08)")));
        optab.put("READ", new ArrayList<String>(Arrays.asList("(IS,09)")));
        optab.put("PRINT", new ArrayList<String>(Arrays.asList("(IS,10)")));
        optab.put("DC", new ArrayList<String>(Arrays.asList("(DL,01)")));
        optab.put("DS", new ArrayList<String>(Arrays.asList("(DL,02)")));
        optab.put("START", new ArrayList<String>(Arrays.asList("(AD,01)")));
        optab.put("END", new ArrayList<String>(Arrays.asList("(AD,02)")));
        optab.put("ORIGIN", new ArrayList<String>(Arrays.asList("(AD,03)")));
        optab.put("EQU", new ArrayList<String>(Arrays.asList("(AD,04)")));
        optab.put("LTORG", new ArrayList<String>(Arrays.asList("(AD,05)")));
        
        registertable.put("AREG", "01");
        registertable.put("BREG", "02");
        registertable.put("CREG", "03");
        registertable.put("DREG", "04");

        bctable.put("LT", "01");
        bctable.put("LE", "02");
        bctable.put("EQ", "03");
        bctable.put("GT", "04");
        bctable.put("GE", "05");
        bctable.put("ANY","06");

        File file = new File("input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        ArrayList<ArrayList<String>> ictab = new ArrayList<ArrayList<String>>();
        LinkedHashMap<String, String> symtab1 = new LinkedHashMap<String, String>();
        for (int i = 0; i < lines.size(); i++) {
            String command = lines.get(i);
            ArrayList<String> words = new ArrayList<String>();
            StringTokenizer tokenizer = new StringTokenizer(command, " ");
            while (tokenizer.hasMoreTokens()) {
                words.add(tokenizer.nextToken());
            }
            for (int j = 0; j < words.size(); j++) {
                System.out.println(words.get(j));
            }
            for (int j = 0; j < words.size(); j++) {
                if(words.get(words.size()-1) == ",")
                {
                    words.remove(words.size()-1);
                }
            }
            //System.out.println(words.get(0) + words.get(1) + "---------------------------------\n");
            if (words.get(0).equals("START")) {
                if (words.size() == 2) {
                    ictab.add(new ArrayList<String>(Arrays.asList("-", "(AD,01)", words.get(1))));
                } else {
                    ictab.add(new ArrayList<String>(Arrays.asList("-", "(AD,01)", "-")));
                }
            }
            else if (optab.containsKey(words.get(0)) == false) {
                
            }
        }
        
        for (int i = 0; i < ictab.size(); i++) {
            for (int j = 0; j < ictab.get(i).size(); j++) {
                System.out.print(ictab.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}