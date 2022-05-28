import java.util.Scanner;

public class Board {

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

    public void turn(Player player) {
        char turn;
        boolean valid = false;
        System.out.println("Player " + player.getNumber() + " (" + player.getSymbol() + "), enter column for your turn (1, 2, 3, 4, 5, 6, 7) and then press enter!");
        while(!valid) {
            turn = sc.next().charAt(0);
            if((turn == '1') || (turn == '2') || (turn == '3') || (turn == '4') || (turn == '5') || (turn == '6') || (turn == '7')) {
                int x = Character.getNumericValue(turn) - 1;
                for(int y = 0; y < fields.length; y++) {
                    if(fields[y][x].isOccupied()) {
                        if(y == 0) {
                            System.out.println("The column is full! Pick an empty one!");
                            break;
                        } else {
                            valid = true;
                            fields[y - 1][x].setStatus(player.getSymbol());
                            fields[y - 1][x].setOccupied(true);
                            break;
                        }
                    } else if(y == 5 && !fields[5][x].isOccupied()) {
                        valid = true;
                        fields[y][x].setStatus(player.getSymbol());
                        fields[y][x].setOccupied(true);
                    }
                }
            } else {
                System.out.println("Invalid input! Enter only 1, 2, 3, 4, 5, 6, or 7!");
            }
        }
    }

    public boolean winCheck(Player player) {
        int drawCheck = 0;
        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields[0].length; x++) {
                if (fields[y][x].isOccupied()) {
                    drawCheck++;
                }
                if(x <= 3) {
                    if((fields[y][x].getStatus() == player.getSymbol()) && (fields[y][x + 1].getStatus() == player.getSymbol()) && (fields[y][x + 2].getStatus() == player.getSymbol()) && (fields[y][x + 3].getStatus() == player.getSymbol())) {
                        fields[y][x].setStatus(Character.toUpperCase(fields[y][x].getStatus()));
                        fields[y][x + 1].setStatus(Character.toUpperCase(fields[y][x + 1].getStatus()));
                        fields[y][x + 2].setStatus(Character.toUpperCase(fields[y][x + 2].getStatus()));
                        fields[y][x + 3].setStatus(Character.toUpperCase(fields[y][x + 3].getStatus()));
                        System.out.println("Congratulations Player " + player.getNumber() + " (" + player.getSymbol() + "), you have won the game!");
                        return true;
                    }
                }
                if(y <= 2) {
                    if((fields[y][x].getStatus() == player.getSymbol()) && (fields[y + 1][x].getStatus() == player.getSymbol()) && (fields[y + 2][x].getStatus() == player.getSymbol()) && (fields[y + 3][x].getStatus() == player.getSymbol())) {
                        fields[y][x].setStatus(Character.toUpperCase(fields[y][x].getStatus()));
                        fields[y + 1][x].setStatus(Character.toUpperCase(fields[y + 1][x].getStatus()));
                        fields[y + 2][x].setStatus(Character.toUpperCase(fields[y + 2][x].getStatus()));
                        fields[y + 3][x].setStatus(Character.toUpperCase(fields[y + 3][x].getStatus()));
                        System.out.println("Congratulations Player " + player.getNumber() + " (" + player.getSymbol() + "), you have won the game!");
                        return true;
                    }
                }
                if((x <= 3) && (y <= 2)) {
                    if((fields[y][x].getStatus() == player.getSymbol()) && (fields[y + 1][x + 1].getStatus() == player.getSymbol()) && (fields[y + 2][x + 2].getStatus() == player.getSymbol()) && (fields[y + 3][x + 3].getStatus() == player.getSymbol())) {
                        System.out.println("Congratulations Player " + player.getNumber() + " (" + player.getSymbol() + "), you have won the game!");
                        fields[y][x].setStatus(Character.toUpperCase(fields[y][x].getStatus()));
                        fields[y + 1][x + 1].setStatus(Character.toUpperCase(fields[y + 1][x + 1].getStatus()));
                        fields[y + 2][x + 2].setStatus(Character.toUpperCase(fields[y + 2][x + 2].getStatus()));
                        fields[y + 3][x + 3].setStatus(Character.toUpperCase(fields[y + 3][x + 3].getStatus()));
                        return true;
                    }
                }
                if((x <=3) && (y >= 3)) {
                    if((fields[y][x].getStatus() == player.getSymbol()) && (fields[y - 1][x + 1].getStatus() == player.getSymbol()) && (fields[y - 2][x + 2].getStatus() == player.getSymbol()) && (fields[y - 3][x + 3].getStatus() == player.getSymbol())) {
                        System.out.println("Congratulations Player " + player.getNumber() + " (" + player.getSymbol() + "), you have won the game!");
                        fields[y][x].setStatus(Character.toUpperCase(fields[y][x].getStatus()));
                        fields[y - 1][x + 1].setStatus(Character.toUpperCase(fields[y - 1][x + 1].getStatus()));
                        fields[y - 2][x + 2].setStatus(Character.toUpperCase(fields[y - 2][x + 2].getStatus()));
                        fields[y - 3][x + 3].setStatus(Character.toUpperCase(fields[y - 3][x + 3].getStatus()));
                        return true;
                    }
                }
                if(drawCheck == 42) {
                    System.out.println("The game is a draw!");
                    return true;
                }
            }
        }
        return false;
    }
}