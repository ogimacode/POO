
public class Player {
    private String name;
    private int number;
    private String position;
    private String isFielded;

    public Player(String name, int number, String position) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = "Bench";
    }

    public Player(String name, int number, String position, String isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public String getStateAsString() {
        return "Name: "+ name + " number: " + number + " Position: " + position +" isFielded: " + isFielded ;
    }

    public void setIsFielded(String isFielded) {
        this.isFielded = isFielded;
    }
}

