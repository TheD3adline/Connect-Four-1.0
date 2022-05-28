public class Player {

    private char symbol;
    private int number;

    public Player(int number) {
        this.number = number;
        if(number == 1) {
            this.symbol = 'x';
        } else if(number == 2) {
            this.symbol = 'o';
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
