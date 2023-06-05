public class Player {
    private String name;
    private int numWins;

    public Player(String name) {
        this.name = name;
        numWins = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void addWin() {
        numWins++;
    }
}
