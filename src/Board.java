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
        boolean valid = false;
        System.out.println("Player 1 (x, red), enter column for your turn (1, 2, 3, 4, 5, 6, 7) and then press enter!");
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
                            fields[y - 1][x].setStatus(player1);
                            fields[y - 1][x].setOccupied(true);
                            break;
                        }
                    } else if(y == 5 && !fields[5][x].isOccupied()) {
                        valid = true;
                        fields[y][x].setStatus(player1);
                        fields[y][x].setOccupied(true);
                    }
                }
            } else {
                System.out.println("Invalid input! Enter only 1, 2, 3, 4, 5, 6, or 7!");
            }
        }
    }

    public void turnP2() {
        char turn;
        boolean valid = false;
        System.out.println("Player 2 (o, yellow), enter column for your turn (1, 2, 3, 4, 5, 6, 7) and then press enter!");
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
                            fields[y - 1][x].setStatus(player2);
                            fields[y - 1][x].setOccupied(true);
                            break;
                        }
                    } else if(y == 5 && !fields[5][x].isOccupied()) {
                        valid = true;
                        fields[y][x].setStatus(player2);
                        fields[y][x].setOccupied(true);
                    }
                }
            } else {
                System.out.println("Invalid input! Enter only 1, 2, 3, 4, 5, 6, or 7!");
            }
        }
    }

    public boolean winCheck() {
        int drawCheck = 0;
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                if(fields[y][x].isOccupied()) {
                    drawCheck++;
                }
                if((x <= 3) && (fields[y][x].isOccupied() && fields[y][x + 1].isOccupied() && fields[y][x + 2].isOccupied() && fields[y][x + 3].isOccupied())) {
                    if((fields[y][x].getStatus() == 'x') && (fields[y][x + 1].getStatus() == 'x') && (fields[y][x + 2].getStatus() == 'x') && (fields[y][x + 3].getStatus() == 'x')) {
                        System.out.println("Congratulations player 1 (x, red), you have won the game!");
                        return true;
                    } else if((fields[y][x].getStatus() == 'o') && (fields[y][x + 1].getStatus() == 'o') && (fields[y][x + 2].getStatus() == 'o') && (fields[y][x + 3].getStatus() == 'o')) {
                        System.out.println("Congratulations player 2 (o, yellow), you have won the game!");
                        return true;
                    }
                } else if((x > 3) && (fields[y][x].isOccupied() && fields[y][x - 1].isOccupied() && fields[y][x - 2].isOccupied() && fields[y][x - 3].isOccupied())) {
                    if((fields[y][x].getStatus() == 'x') && (fields[y][x - 1].getStatus() == 'x') && (fields[y][x - 2].getStatus() == 'x') && (fields[y][x - 3].getStatus() == 'x')) {
                        System.out.println("Congratulations player 1 (x, red), you have won the game!");
                        return true;
                    } else if((fields[y][x].getStatus() == 'o') && (fields[y][x - 1].getStatus() == 'o') && (fields[y][x - 2].getStatus() == 'o') && (fields[y][x - 3].getStatus() == 'o')) {
                        System.out.println("Congratulations player 2 (o, yellow), you have won the game!");
                        return true;
                    }
                } else if((y <= 2) && (fields[y][x].isOccupied() && fields[y + 1][x].isOccupied() && fields[y + 2][x].isOccupied() && fields[y + 3][x].isOccupied())) {
                    if((fields[y][x].getStatus() == 'x') && (fields[y + 1][x].getStatus() == 'x') && (fields[y + 2][x].getStatus() == 'x') && (fields[y + 3][x].getStatus() == 'x')) {
                        System.out.println("Congratulations player 1 (x, red), you have won the game!");
                        return true;
                    } else if((fields[y][x].getStatus() == 'o') && (fields[y + 1][x].getStatus() == 'o') && (fields[y + 2][x].getStatus() == 'o') && (fields[y + 3][x].getStatus() == 'o')) {
                        System.out.println("Congratulations player 2 (o, yellow), you have won the game!");
                        return true;
                    }
                } else if((y > 2) && (fields[y][x].isOccupied() && fields[y - 1][x].isOccupied() && fields[y - 2][x].isOccupied() && fields[y - 3][x].isOccupied())) {
                    if((fields[y][x].getStatus() == 'x') && (fields[y - 1][x].getStatus() == 'x') && (fields[y - 2][x].getStatus() == 'x') && (fields[y - 3][x].getStatus() == 'x')) {
                        System.out.println("Congratulations player 1 (x, red), you have won the game!");
                        return true;
                    } else if((fields[y][x].getStatus() == 'o') && (fields[y - 1][x].getStatus() == 'o') && (fields[y - 2][x].getStatus() == 'o') && (fields[y - 3][x].getStatus() == 'o')) {
                        System.out.println("Congratulations player 2 (o, yellow), you have won the game!");
                        return true;
                    }
                } else if(((x <= 3) && (y <= 2)) && (fields[y][x].isOccupied() && fields[y + 1][x + 1].isOccupied() && fields[y + 2][x + 2].isOccupied() && fields[y + 3][x + 3].isOccupied())) {
                    if((fields[y][x].getStatus() == 'x') && (fields[y + 1][x + 1].getStatus() == 'x') && (fields[y + 2][x + 2].getStatus() == 'x') && (fields[y + 3][x + 3].getStatus() == 'x')) {
                        System.out.println("Congratulations player 1 (x, red), you have won the game!");
                        return true;
                    } else if((fields[y][x].getStatus() == 'o') && (fields[y + 1][x + 1].getStatus() == 'o') && (fields[y + 2][x + 2].getStatus() == 'o') && (fields[y + 3][x + 3].getStatus() == 'o')) {
                        System.out.println("Congratulations player 2 (o, yellow), you have won the game!");
                        return true;
                    }
                } else if(((x > 3) && (y > 2)) && (fields[y][x].isOccupied() && fields[y - 1][x - 1].isOccupied() && fields[y - 2][x - 2].isOccupied() && fields[y - 3][x - 3].isOccupied())) {
                    if((fields[y][x].getStatus() == 'x') && (fields[y - 1][x - 1].getStatus() == 'x') && (fields[y - 2][x - 2].getStatus() == 'x') && (fields[y - 3][x - 3].getStatus() == 'x')) {
                        System.out.println("Congratulations player 1 (x, red), you have won the game!");
                        return true;
                    } else if((fields[y][x].getStatus() == 'o') && (fields[y - 1][x - 1].getStatus() == 'o') && (fields[y - 2][x - 2].getStatus() == 'o') && (fields[y - 3][x - 3].getStatus() == 'o')) {
                        System.out.println("Congratulations player 2 (o, yellow), you have won the game!");
                        return true;
                    }
                } else if(drawCheck == 42) {
                    System.out.println("The game is a draw!");
                    return true;
                }
            }
        }
        return false;
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
