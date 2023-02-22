package bingo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class BoardGenerator {

    BingoCell[] bingoCells;

    public BoardGenerator() {
        loadCells();
    }

    public void loadCells() {
        ArrayList<BingoCell> bingoCellsList = new ArrayList<>();
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("bingorutor.json"));
        } catch (IOException | ParseException e) {
            System.out.println("JSON problem?");
            System.exit(0);
        }
        JSONObject jsonObject = (JSONObject) obj; // typecasting obj to JSONObject
        JSONArray jsonCells = (JSONArray) jsonObject.get("bingorutor");

        System.out.println("Totalt " + jsonCells.toArray().length + " rutor.");

        for (Object jsonCell : jsonCells) {
            JSONObject cell = (JSONObject) jsonCell;
            if(!(boolean) cell.get("disabled")) {
                String phrase = (String) cell.get("phrase");
                Players[] present = playersFromJSON(cell.get("present"));
                Players[] notOnBoard = playersFromJSON(cell.get("not on board"));
                bingoCellsList.add(new BingoCell(phrase, present, notOnBoard));
            }
        }

        bingoCells = new BingoCell[bingoCellsList.size()];
        bingoCells = bingoCellsList.toArray(bingoCells);
    }

    private Players[] playersFromJSON(Object obj) {
        JSONArray jsonCells = (JSONArray) obj;
        ArrayList<Players> playersList = new ArrayList<>();
        for (Object jsonCell : jsonCells) {
            String playerString = (String) jsonCell;
            // TODO: måste finnas bättre sätt att göra den här konverteringen
            if(playerString.equalsIgnoreCase("elin"))
                playersList.add(Players.ELIN);
            else if(playerString.equalsIgnoreCase("johan"))
                playersList.add(Players.JOHAN);
            else if(playerString.equalsIgnoreCase("kevin"))
                playersList.add(Players.KEVIN);
            else if(playerString.equalsIgnoreCase("patricia"))
                playersList.add(Players.PATRICIA);
            else if(playerString.equalsIgnoreCase("ville"))
                playersList.add(Players.VILLE);
        }
        Players[] playersArray = new Players[playersList.size()];
        playersArray = playersList.toArray(playersArray);
        return playersArray;
    }

    // TODO: funktioner för att göra personliga bingo-brickor
    public String[] boardStrings(int count)
    {
        String[] result = new String[count];
        int[] indicies = randomInts(count, bingoCells.length);
        for(int i = 0; i < count; i++)
        {
            result[i] = bingoCells[indicies[i]].phrase;
        }
        System.out.print("\n");
        return result;
    }
    
    private static int[] randomInts(int count, int length)
    {
        Random rnd = new Random();
        int[] random = new int[count];
        boolean ok;
        for(int i = 0; i < count; i++)
        {
            do {                
                random[i] = rnd.nextInt(length);
                ok = true;
                for(int j = 0; j < i; j++)
                {
                    if(random[i] == random[j])
                    {
                        ok = false;
                        break;
                    }
                }
            } while (!ok);
        }
        return random;
    }
    
}
