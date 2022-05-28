public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        if(Math.random() < 0.5) {
            System.out.println("The coin flipped heads, Player 1 will begin the round!");
            while(true) {
                board.draw();
                board.turn(player1);
                if(board.winCheck(player1)) {
                    board.draw();
                    System.exit(0);
                }
                board.draw();
                board.turn(player2);
                if(board.winCheck(player2)) {
                    board.draw();
                    System.exit(0);
                }
            }
        } else {
            System.out.println("The coin flipped heads, Player 2 will begin the round!");
            while(true) {
                board.draw();
                board.turn(player2);
                if(board.winCheck(player2)) {
                    board.draw();
                    System.exit(0);
                }
                board.draw();
                board.turn(player1);
                if(board.winCheck(player1)) {
                    board.draw();
                    System.exit(0);
                }
            }
        }
    }
}