package com.Apples2Apples.util;

import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;
import com.Apples2Apples.player.PlayerType;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the addition of players, including bot players, to the game.
 */
public class PlayerManager {

    /**
     * Adds bot players to the game if there aren't enough players to meet the table size.
     *
     * @param players the list of current players
     * @param tableSize the desired number of players for the game
     */
    public void addBotPlayersIfNeeded(List<Player> players, int tableSize) {
        int currentSize = players.size();
        if (currentSize < tableSize) {
            int botsToAdd = tableSize - currentSize;
            for (int i = 0; i < botsToAdd; i++) {
                String botName = "Bot" + (currentSize + i + 1);
                Player botPlayer = PlayerFactory.createPlayer(PlayerType.BOT, botName, new ArrayList<>(), false);
                players.add(botPlayer);
            }
        }
    }
}
