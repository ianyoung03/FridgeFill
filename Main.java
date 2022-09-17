/* This program takes in a fridge index (a representation 
of the order of the back fridge) and takes in a user inputted 
restock list, and reorganizes the restock list to match the 
order of the back fridge in order to make the fridge restocking 
process faster and easier
*/

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;
class Main
{

	 // taking in input of how the fridge is indexed
   public static void scanFile(HashMap<String, Integer> indexHash) throws IOException
   {
      File myFile = new File("FridgeIndex.txt");
      Scanner read = new Scanner(myFile);
      String drinkName;
      int locationNum;
      
      while (read.hasNextLine())
      {
         locationNum = Integer.parseInt(read.nextLine());
         drinkName = read.nextLine();
        
         indexHash.put(drinkName, locationNum);  
      }
      read.close();
   }

	 // taking input of what the restock list is
   public static void userInput(List<String> input) throws IOException
   {
      File myFile = new File("InputData.txt");
      Scanner read = new Scanner(myFile);
      
      while (read.hasNextLine())
      {
         input.add(read.nextLine());
      }
      read.close();   
      
   }

	 // sorting the restock list to match the order of the back fridge
   public static void inputReorder(TreeMap<Integer, String> outputTree, HashMap<String, Integer> indexHash, ArrayList<String> input)
   {
      for (int i = 0; i < input.size(); i++)
      {
         outputTree.put(indexHash.get(input.get(i).substring(input.get(i).indexOf(" ") + 1)), input.get(i));      
      }

   }

	 // outputting re-organized list to the terminal for user
   public static void output(TreeMap<Integer, String> outputTree)
   {
      for (String i : outputTree.values())
      {
         System.out.println(i);
      }
   }

	 // main method
   public static void main (String [] args) throws IOException
   {
      TreeMap<Integer, String> outputTree = new TreeMap<Integer, String>();
      HashMap<String, Integer> indexHash = new HashMap<String, Integer>();
      ArrayList<String> input = new ArrayList<String>();
      
      scanFile(indexHash);
      userInput(input);
      inputReorder(outputTree, indexHash, input);
      output(outputTree);
                
      
   }  
}