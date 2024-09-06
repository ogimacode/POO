import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Team BES = new Team("BES", "SAN CHARLES", "JORGE");

        Player player1 = new Player("Matheus", 7, "player", true ,BES);
        Player player2 = new Player("FEFO", 10, "player",true ,BES);
        Player player3 = new Player("Candido", 12, "player", true,BES);
        Player player4 = new Player("Fabiano", 5, "player", false,BES);
        Player player5 = new Player("Lucas", 1, "Couch", false,BES);

        BES.addPlayer(player1);
        BES.addPlayer(player2);
        BES.addPlayer(player3);
        BES.addPlayer(player4);
        BES.addPlayer(player5);

//        BES.removePlayer(player1);
//        BES.setCaptain(player5);
//
//        System.out.println(BES);
//
//        System.out.println(BES.getCaptain().getStateAsString());
//        System.out.println(player1);
//        System.out.println(player2);
//        System.out.println(player3);
//        System.out.println(player4);
//        System.out.println(player5);
//
//        BES.substitute(player4, player3);
//        System.out.println(Arrays.toString(BES.getFieldedPlayers()));
//        System.out.println(Arrays.toString(BES.getOutFieldedPlayers()));



    }
}