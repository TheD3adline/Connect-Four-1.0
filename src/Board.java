public class Board {

    private final char player1 = 'x';
    private final char player2 = 'o';
    private final char empty = ' ';

    private Field[][] fields;

    public Board() {
        fields = new Field[6][7];
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                fields[y][x] = new Field();
            }
        }
    }

    public void run() {
        if(Math.random() < 0.5) {
            System.out.println("The coin flipped heads! Player 1 (x, red) will begin!");
            //draw()
            while(true) {
                //turnP1()
                //draw()
                //winCheck()
                //turnP2()
                //draw()
                //winCheck()
            }
        } else {
            System.out.println("The coin flipped tails! Player 2 (o, yellow) will begin!");
            //draw()
            while(true) {
                //turnP2()
                //draw()
                //winCheck()
                //turnP1()
                //draw()
                //winCheck()
            }
        }
    }

    public void draw() {
        System.out.println();
        System.out.println("   A B C D E F G");
        for(int y = 0; y < fields.length; y++) {
            System.out.print((y + 1) + " |");
            for(int x = 0; x < fields[0].length; x++) {
                System.out.print(fields[y][x].getStatus() + "|");
            }
            System.out.println();
        }
    }
}
