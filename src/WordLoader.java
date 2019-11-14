import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class WordLoader {
  static   ArrayList<String> words = new ArrayList<String>();
    public String getRandomWord() throws IOException {
                File file = new File("Words.txt");
        Scanner reader = new Scanner (file);
        while (reader.hasNextLine()){
            String d =reader.nextLine();
            words.add(d);
        }

        return words.get((int) Math.round( Math.random()*(words.size()-1)));}
    }


