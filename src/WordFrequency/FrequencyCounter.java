package WordFrequency;
import java.util.*;
import java.io.FileInputStream;

public class FrequencyCounter {

    public static void main(String args[]){
        try{
            Scanner file = new Scanner(new FileInputStream("C:\\Users\\Gopi Venkat Krishna\\IdeaProjects\\module15_assignment\\src\\WordFrequency\\tale.txt"));
            HashMap<String, Integer> wordsDict = new HashMap<String, Integer>();
            while (file.hasNextLine()){
                String words[] = file.nextLine().split("[ \\-\\(\\)!?\",;:_\\*\\[\\]\\n\\/\\.]+");
                for (String word : words) {
                    if (word.length() > 0) {
                        word = word.toLowerCase();
                        if (wordsDict.containsKey(word))
                            wordsDict.put(word, wordsDict.get(word) + 1);
                        else
                            wordsDict.put(word, 1);
                    }
                }
            }

            System.out.println("\nPrinting frequencies...");
            Set<String> set = wordsDict.keySet();
            Iterator<String> itr =  new HashSet<String>(set).iterator();
            while(itr.hasNext()){
                String key = itr.next();
                System.out.println(key+":"+wordsDict.get(key));
            }

            System.out.println("\nPrinting high frequencies...");
            itr =  new HashSet<String>(set).iterator();
            while(itr.hasNext()){
                String key = itr.next();
                if (wordsDict.get(key) > 1000)
                    System.out.println(key+":"+wordsDict.get(key));
            }

            System.out.println("\nPrinting highest frequency...");
            itr =  new HashSet<String>(set).iterator();
            while(itr.hasNext()){
                String key = itr.next();
                if (wordsDict.get(key) == Collections.max(wordsDict.values()))
                    System.out.println(key+":"+wordsDict.get(key));
            }
        }catch(Exception e){e.printStackTrace();}
    }

}
