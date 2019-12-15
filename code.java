import java.util.HashMap;
import java.util.Scanner;

public class format {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String firstdocument[] = sc.nextLine().split(" ");
    String seconddocument[] = sc.nextLine().split(" ");

    HashMap<String, Integer> firstdictionary = new HashMap<String, Integer>();
    HashMap<String, Integer> seconddictionary = new HashMap<String, Integer>();

    for(int i=0; i<firstdocument.length ;i++) {
        if(!firstdictionary.containsKey(firstdocument[i])) { //word is not in firstdictionary yet
            firstdictionary.put(firstdocument[i], 1);
        }
        else if(firstdictionary.containsKey(firstdocument[i])) { //word is in firstdictionary 
            firstdictionary.put(firstdocument[i], firstdictionary.get(firstdocument[i]) + 1);
        }

        if(!seconddictionary.containsKey(firstdocument[i])) { //word is not in seconddictionary yet
            seconddictionary.put(firstdocument[i], 0);
        }


    }

    for(int i=0; i<seconddocument.length ;i++) {
        if(!seconddictionary.containsKey(seconddocument[i])) { \
            seconddictionary.put(seconddocument[i], 1);
        }
        else if(seconddictionary.containsKey(seconddocument[i])) { 
            seconddictionary.put(seconddocument[i], seconddictionary.get(seconddocument[i]) + 1);
        }

        if(!firstdictionary.containsKey(seconddocument[i])) {
            firstdictionary.put(seconddocument[i], 0);
        }


    }

    int dotProduct =0;
    int firstdocumentsq = 0;
    int seconddocumentsq = 0;
    for(int i=0; i<firstdocument.length ;i++) {
        dotProduct = dotProduct + (firstdictionary.get(firstdocument[i])) * (seconddictionary.get(firstdocument[i]));
        firstdocumentsq = firstdocumentsq +  (firstdictionary.get(firstdocument[i])) *  (firstdictionary.get(firstdocument[i]));
        seconddocumentsq = seconddocumentsq +  (seconddictionary.get(firstdocument[i])) *  (seconddictionary.get(firstdocument[i]));    
    }

    double similarity = dotProduct / Math.sqrt(firstdocumentsq*seconddocumentsq);
    System.out.print("similarity = "+ similarity);

}

}
