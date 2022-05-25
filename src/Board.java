import java.util.Scanner;

public class Board {

    private final char player1 = 'x';
    private final char player2 = 'o';
    private final char empty = ' ';

    private Field[][] fields;

    Scanner sc = new Scanner(System.in);

    public Board() {
        fields = new Field[6][7];
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                fields[y][x] = new Field();
            }
        }
    }

    public void draw() {
        System.out.println();
        System.out.println(" 1 2 3 4 5 6 7");
        for(int y = 0; y < fields.length; y++) {
            System.out.print("|");
            for(int x = 0; x < fields[0].length; x++) {
                System.out.print(fields[y][x].getStatus() + "|");
            }
            System.out.println();
        }
    }

    public void turnP1() {
        char turn;
        System.out.println("Player 1 (x, red), enter column for your turn (1, 2, 3, 4, 5, 6, 7) and then press enter!");
        while(!input(turn = sc.next().charAt(0))) {
            if((turn == '1') || (turn == '2') || (turn == '3') || (turn == '4') || (turn == '5') || (turn == '6') || (turn == '7')) {
                int x = Character.getNumericValue(turn);
                for(int y = 0; y < fields.length; y++) {
                    if(!fields[y][x].isOccupied()) {
                        if(!fields[y + 1][x].isOccupied()) {
                            fields[y][x].setStatus(player1);
                            fields[y][x].setOccupied(true);
                        }
                    }
                }
            }
        }

    }

    public boolean input(char turn) {
        if((turn == '1') || (turn == '2') || (turn == '3') || (turn == '4') || (turn == '5') || (turn == '6') || (turn == '7')) {
            return true;
        } else {
            System.out.println("Error, invalid input!");
            return false;
        }
    }
    public char getPlayer1() {
        return player1;
    }

    public char getPlayer2() {
        return player2;
    }

    public char getEmpty() {
        return empty;
    }

    public Field[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }
}
