import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>(); // созд коллекцию


    public void register(Player player) {
        players.add(player);
    }

    public int findByName (String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
            
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {
        int player1 = findByName(playerName1);
        int player2 = findByName(playerName2);

        if (player1 == -1) {
            throw new NotRegisteredException("Необходимо зарегистрироваться на турнир");
        }
        if (player2 == -1) {
            throw new NotRegisteredException("Необходимо зарегистрироваться на турнир");
        }
        int strPlayer1 = players.get(player1).getStrength();
        int strPlayer2 = players.get(player2).getStrength();

        if (strPlayer1 == strPlayer2) {
            return 0;
        }
        if (strPlayer1 > strPlayer2) {
            return 1;
        }
        return 2;




//        for (Player player : players) {
//            if (!player.getName().equals(playerName1)) {
//                throw new NotRegisteredException("Необходимо зарегистрироваться на турнир");
//
//            }
//
//            if (!player.getName().equals(playerName2)) {
//                throw new NotRegisteredException("Необходимо зарегистрироваться на турнир");
//            }
//            String player1 = player.getName(playerName1);
//           int player2 = player.getStrength();
//
//
//
//        }



    }

//        for (Player player : players) {
//            int result;
////            String playerName1 = player.getName();
////            String playerName2;
//            if (!player.getName().equals(playerName1) || !player.getName().equals(playerName2)) {
//                throw new NotRegisteredException("Необходимо зарегистрироваться на турнир");
//            } else {
//                String player1 = player.getName();
//                String player2 = player.getName();
//            }
////
//            int strPlayer1 = player.getStrength();
//            int strPlayer2 = player.getStrength();
//
//
//            {
//                if (strPlayer1 == strPlayer2) {
//                    return result = 0;
//                }
//            }
//            if (strPlayer1 > strPlayer2) {
//                return result = 1;
//            }
//            return result = 2;
//
//
//        }
//        return;
//    }
}
