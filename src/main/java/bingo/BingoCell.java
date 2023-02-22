package bingo;
import java.util.Arrays;

public class BingoCell {
    String phrase;
    Players[] present;
    Players[] notOnBoard;

    public BingoCell(String phrase, Players[] present, Players[] notOnBoard) {
        this.phrase = phrase;
        this.present = present;
        this.notOnBoard = notOnBoard;
    }

    public String getPhrase() {
        return phrase;
    }

    public Players[] getPresent() {
        return present;
    }

    public Players[] getNotOnBoard() {
        return notOnBoard;
    }
}
