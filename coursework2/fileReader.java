package coursework2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class fileReader {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new FileReader("/Users/huyf/Desktop/java/src/coursework2/data.txt"));
        ArrayList<String> wordArrayList = new ArrayList<>();
        while (inFile.hasNext()) {
            String temp = inFile.next();
            int length = temp.length();
            char suffix = temp.charAt(length - 1);
            if ((suffix >= 'a' && suffix <= 'z') || (suffix >= 'A' && suffix <= 'Z')) {
                wordArrayList.add(temp.toLowerCase());
            }
            else if (suffix >= '0' && suffix <= '9') {
                continue;
            }
            else {
                //System.out.println(temp.substring(0, length - 1));
                wordArrayList.add(temp.substring(0, length - 1).toLowerCase());
            }
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> keyList = new ArrayList<>();
        for(String item: wordArrayList){
            if(map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }else{
                keyList.add(item);
                map.put(item, 1);
            }
        }
        Collections.sort(keyList);
        System.out.println(keyList);

//        for (int i = 0; i <= wordArrayList.size() - 1; i ++) {
//            wordArrayList.get(i).toLowerCase();
//            System.out.println(wordArrayList);
////            for (int j = 0; j <= wordArrayList.get(i).length() - 1; j++) {
////                System.out.println(wordArrayList.get(i).split("")[j]);
////            }
//        }
        PrintWriter outFile = new PrintWriter("/Users/huyf/Desktop/java/src/coursework2/results.txt");
        for (String key : keyList) {
            System.out.printf("%-15s %10s", key, map.get(key) + "\n");
            outFile.printf("%-15s %10s", key, map.get(key) + "\n");
        }
        outFile.close();
    }
//    private static boolean isNumeric(String inputString) {
//        //boolean boolResult = true;
//        //ArrayList<String> stringList = new ArrayList<>();
////        String[] stringList;
////        stringList = inputString.split("");
//        for (int i = 0; i <= inputString.length() - 2; i++) {
//            if ('0' <= inputString.charAt(i) || inputString.charAt(i) <= '9') {
//
//            }
//        }
//        return true;
//    }
}
