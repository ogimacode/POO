import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player captain;

    private final Player[] players = new Player[18];

    private int numPlayers = 0;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player) {
        players[numPlayers++] = player;
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < numPlayers; i++){
            if (player == players[i]){
                players[i] = players[numPlayers - 1];
                players[numPlayers - 1] = null;
                numPlayers--;
            }
        }
    }

    public void substitute(Player substitute, Player starter) {
        starter.setIsFielded("Bench");
        substitute.setIsFielded(("Fielded"));

    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", coachName='" + coachName + '\'' +
                ", captain=" + captain +
                ", players=" + Arrays.toString(players) +
                ", numPlayers=" + numPlayers +
                '}';
    }
}