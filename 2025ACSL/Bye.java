import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;




class Result {


   /*
    * Complete the 'buildTree' function below.
    *
    * The function is expected to return a STRING.
    * The function accepts STRING word as parameter.
    */
   private static int leftNode(int i, int size) {
       int left = 2 * i + 1;
       return (left < size) ? left : -1;
   }
   private static int rightNode(int i, int size) {
       int right = 2 * i + 2;
       return (right  < size ) ? right : - 1;
   }
   private static int searchTree(int[] array, int value) {
       int pos = 0;
       while (pos >= 0 && array[pos] >= 0) {
           if (array[pos] == value) {
               break;              
           } else if (value < array[pos]) {
               pos = leftNode(pos, array.length);
           } else {
               pos = rightNode(pos, array.length);
                  
           }
       }
       if (pos >= 0 && array[pos] < 0 ) {
           pos = -1;
       }
       return pos;
   }
   private static int findInsertPos(int[] array, int value) {
       int pos = 0;
       while (pos >= 0 && array[pos] >= 0) {
           if (value <= array[pos]) {
               pos = leftNode(pos, array.length);
           } else {
               pos = rightNode(pos, array.length);
           }
       }
       return pos;
   }
   public static String buildTree(String word) {
       int[] asciiArray = new int[word.length()];
       for (int i = 0; i < word.length(); i++) {
           asciiArray[i] = (int) word.charAt(i);  // Convert each char to its ASCII int value
       }
      
       int[] treeArray = new int[1024*1024]; // word.length<=20;
       for(int i=0; i< treeArray.length; i++){
           treeArray[i] = -1;
       }
       for(int i = 0;i < asciiArray.length;i++) {
           int value = asciiArray[i];
           int pos = findInsertPos(treeArray, value);
           treeArray[pos] = value;
       }
       int[] distArray = new int[asciiArray.length - 1];
       int j = 0;
       int lastCharPos = -1;
       for (int i = 0; i < treeArray.length; i++) {
           if (treeArray[i] >= 0) {  // Found a character
               if (lastCharPos >= 0) {
                   distArray[j] = i - lastCharPos - 1;  // gap between chars
                   j++;
                   if (j >= distArray.length){
                       break;
                   }
               }
               lastCharPos = i;
           }
       }
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < distArray.length; i++) {
           sb.append(distArray[i]);
           if (i != distArray.length - 1) {
               sb.append(" ");
           }
       }
       String dist = sb.toString();
       return dist;
   }
}
public class Solution {
   public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


       String word = bufferedReader.readLine();


       String result = Result.buildTree(word);


       bufferedWriter.write(result);
       bufferedWriter.newLine();


       bufferedReader.close();
       bufferedWriter.close();
   }
}

