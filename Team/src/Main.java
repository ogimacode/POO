

public class Main {
    public static void main(String[] args){
        Team Santos = new Team("Santos", "SP", "Fábio");

        Player player1 = new Player("juninho", 10,"mid");
        Player player2 = new Player("paulo", 11, "center", "Fielded");
        Player player3 = new Player("joao", 9, "defender", "Bench");

        Santos.addPlayer(player1);
        Santos.addPlayer(player2);
        Santos.addPlayer(player3);

        Santos.substitute(player2, player3);

        Santos.removePlayer(player1);

        Santos.setCaptain(player2);

        System.out.println(player3.getStateAsString());

        System.out.println();

        System.out.println(Santos);


    }
}