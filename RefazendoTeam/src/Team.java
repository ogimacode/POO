import java.util.Arrays;

public class Team {
    private String name;
    private String baseLocation;

    private String coachName;

    private Player[] players;

    private Player captain;

    private int playerCount;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.players = new Player[18];
    }

    public void addPlayer(Player player){
        if (playerCount < 18){
        players[playerCount++] = player;
        } else{
            System.out.println("Numero maximo de players");
        }
    }

    private int isOnTeam(Player player){
        for (int i = 0; i < playerCount; i++) {
            if (player == players[i]) return i;
        }
        return -1;
    }
    public void removePlayer(Player player){
        int index = isOnTeam(player);
        if(index == -1) return;
        playerCount--;
        players[index] = players[playerCount];
        players[playerCount] = null;
    }

    public void substitute(Player substitute, Player starter){
        substitute.setFielded(true);
        starter.setFielded(false);
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Player[] getFieldedPlayers(){
        Player[] newPlayers = new Player[playerCount];
        int numberOfFieldedPlayers = 0;
        for (Player player : players){
            if(player == null) break;
            if (player.getisFielded()){
                newPlayers[numberOfFieldedPlayers++] = player;
            }
        }
        return newPlayers;
    }

    public Player[] getOutFieldedPlayers(){
        Player[] newPlayers = new Player[playerCount];
        int numberOfOutFieldedPlayers = 0;
        for(Player player : players){
            if (player == null) break;
            if (!player.getisFielded()){
                newPlayers[numberOfOutFieldedPlayers++] = player;
            }
        }
        return newPlayers;
    }

    public Player getCaptain() {
        return captain;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", coachName='" + coachName + '\'' +
                ", players=" + Arrays.toString(players) +
                ", captain=" + captain +
                ", playerCount=" + playerCount +
                "}\n";
    }
}
