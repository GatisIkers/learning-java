package CharacterAppearance;

public class Char implements Comparable<Char> {
    private char theChar;
    private int count;

    public Char(char theChar, int count) {
        this.theChar = theChar;
        this.count = count;
    }

    public char getTheChar() {
        return theChar;
    }

    public void setTheChar(char theChar) {
        this.theChar = theChar;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;
    }

    @Override
    public int compareTo(Char o) {
        return Character.compare(this.getTheChar(), o.getTheChar());
    }
}
