public class Player {
    private String name;

    private int number;

    private String position;

    private boolean isFielded;

    private Team team;

    public Player(String name, int number, String position, boolean isFielded, Team team){
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
        this.team = team;
    }

    public boolean getisFielded() {
        return isFielded;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public String getStateAsString(){
        return "["+ team + " Nome: "+ name +" Number: "+number+" Position: "+position +"]\n";
    }

}
