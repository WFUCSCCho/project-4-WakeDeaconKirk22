/***************************************************************************
 @file: Proj4.java
 @description: This program implements the main class of the Project to run the seperate Chaining hashtable.
 @author:  Kennedy Kirk
 @date  Dec 3 ,2024
 // hello
 *******************************************************************************/
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;


public class Proj4 {
    public static void main(String[] args) throws IOException {
        ArrayList<NBAPlayer> NBAObject = new ArrayList<>();
        ArrayList<NBAPlayer>sortedArray  = new ArrayList<>();
        ArrayList<NBAPlayer> shuffledArray = new ArrayList<>();
        ArrayList<NBAPlayer> reversedArray = new ArrayList<>();


        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        // FINISH ME

        for (int i = 0; i < numLines; i++) {
            String temp = inputFileNameScanner.nextLine();
            String[] command = temp.split(",");
            NBAPlayer player = new NBAPlayer(Integer.parseInt(command[0]), // id
                    command[1],//name
                    command[2], // team
                    Double.parseDouble(command[3]), // age
                    Double.parseDouble(command[4]), // player height
                    Double.parseDouble(command[5]), // player weight
                    command[6], // college name
                    command[7], // country name
                    command[8], // draft year
                    command[9], // draft round
                    command[10], // draft number
                    command[11], // games played (gp)
                    Double.parseDouble(command[12]), // points
                    Double.parseDouble(command[13]), // rebounds
                    Double.parseDouble(command[14]), // assists
                    Double.parseDouble(command[15]), // net rating
                    Double.parseDouble(command[16]), // offensive rebound percentage
                    Double.parseDouble(command[17]), // defensive rebound percentage
                    Double.parseDouble(command[18]), // usage percentage
                    Double.parseDouble(command[19]), // assist percentage
                    Double.parseDouble(command[20]),
                    command[21]);
            NBAObject.add(player);
        }

         sortedArray.addAll(NBAObject);
        Collections.sort(sortedArray);

        shuffledArray.addAll(NBAObject);
        Collections.shuffle(shuffledArray);

        reversedArray.addAll(NBAObject);
        Collections.sort(reversedArray, Collections.reverseOrder());


hashTableOperations(sortedArray,"Sorted");
hashTableOperations(shuffledArray,"Shuffled");
hashTableOperations(reversedArray,"Reversed");


    }
    public static void writeToFile(String content, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(content);
        } catch (IOException e) {
            System.out.println("Error found while writing" + e.getMessage());
        }

    }

    public static void hashTableOperations(ArrayList<NBAPlayer>NbaPlayers, String list){
//A function to run the insertion,deletion, and search to a file.
        long startTime;
        long endTime;
        String fileWriter;
        SeparateChainingHashTable<NBAPlayer> hashTable = new SeparateChainingHashTable<>();

        startTime = System.nanoTime();
        for(int i = 0; i < NbaPlayers.size(); i++){
            NBAPlayer player = NbaPlayers.get(i);
            hashTable.insert(player);

        }
        endTime = System.nanoTime();
        long insertTime = endTime - startTime;

        startTime = System.nanoTime();
        for(int i = 0; i < NbaPlayers.size(); i++){

            NBAPlayer player = NbaPlayers.get(i);
            hashTable.contains(player);

        }
        endTime = System.nanoTime();
        long searchTime = endTime - startTime;

        startTime = System.nanoTime();
        for(int i = 0; i < NbaPlayers.size(); i++){
            NBAPlayer player = NbaPlayers.get(i);
            hashTable.remove(player);

        }
        System.out.println(hashTable.getCurrentSize());

        endTime = System.nanoTime();
        long deleteTime = endTime - startTime;


        System.out.println("Insert Time: " + insertTime + "ns" +"\n");
        System.out.println("Search Time: " + searchTime + "ns" +"\n");
        System.out.println("Delete Time: " + deleteTime + "ns" +"\n");

        fileWriter = "List:" + "\n" + list+ "Insert Time: " + insertTime + "ns" +"\n"+"Search Time: "
                + searchTime + "ns" +"\n"+"Delete Time: " + deleteTime + "ns" +"\n";

        writeToFile(fileWriter,"analysis.txt");


    }

}

