public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        while(true) {
            board.draw();
            board.turnP1();
        }
    }

    public void run() {
        if (Math.random() < 0.5) {
            System.out.println("The coin flipped heads! Player 1 (x, red) will begin!");
            //board.draw()
            while (true) {
                //board.turnP1()
                //board.draw()
                //board.winCheck()
                //board.turnP2()
                //board.draw()
                //board.winCheck()
            }
        } else {
            System.out.println("The coin flipped tails! Player 2 (o, yellow) will begin!");
            //board.draw()
            while (true) {
                //board.turnP2()
                //board.draw()
                //board.winCheck()
                //board.turnP1()
                //board.draw()
                //board.winCheck()
            }
        }
    }
}