package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.exception.CustomExceptions;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * OnlinePlayer represents a player connected to an online game.
 * It uses a socket connection for communication and implements the **Observer Pattern**.
 */
public class OnlinePlayer extends AbstractPlayer {
    private static final Logger logger = Logger.getLogger(HumanPlayer.class.getName());
    private boolean isJudge;

    private final Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public OnlinePlayer(String name, List<Card> hand, Socket socket) {
        super(name);
        this.socket = socket;
        this.isJudge = false;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            // Throw a more specific SocketStreamException
            throw new CustomExceptions.SocketStreamException("Error setting up socket streams.", e);
        }
    }

    @Override
    public Card chooseRedAppleCard() {
        try {
            out.writeObject("Choose a card");
            return (Card) in.readObject();
        } catch (SocketException e) {
            throw new CustomExceptions.OnlineCommunicationException("Error communicating with server due to socket issue.", e);
        } catch (ClassNotFoundException e) {
            throw new CustomExceptions.OnlineCommunicationException("Error receiving object from server. Class not found.", e);
        } catch (IOException e) {
            throw new CustomExceptions.OnlineCommunicationException("Error during communication.", e);  // Fallback for other IO issues
        }
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        // Let the human player choose their favorite red apple from the submissions
        Scanner scanner = new Scanner(System.in);
        logger.info("Select your favorite red apple from the following submissions:");

        for (int i = 0; i < submissions.size(); i++) {
            logger.info(i + ": " + submissions.get(i));
        }

        int choice = scanner.nextInt();
        return submissions.get(choice);
    }


    @Override
    public boolean canSeeCards() {
        return false;
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {

    }

    @Override
    public void update(String message) {

    }

    @Override
    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
        if (isJudge) {
            logger.info(getName() + " is now the judge.");
        } else {
            logger.info(getName() + " is no longer the judge.");
        }
    }

    @Override
    public boolean isJudge() {
        return false;
    }
}

