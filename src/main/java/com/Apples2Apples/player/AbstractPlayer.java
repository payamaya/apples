package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

/**
 * Abstract class that represents a player in the Apples to Apples game.
 * Implements common functionality for managing a player's hand, score, and actions.
 */
public abstract class AbstractPlayer implements Player {
    protected final String name;
    protected final Hand hand;
    private int score;

    /**
     * Constructor that initializes the player with a name.
     *
     * @param name The name of the player.
     */
    public AbstractPlayer(String name) {
        this.name = name;
        this.hand = new Hand();
        this.score = 0;
    }
    /**
     * Gets the player's name.
     *
     * @return The player's name.
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Gets the player's score.
     *
     * @return The player's score.
     */
    @Override
    public int getScore() {
        return score;
    }
    /**
     * Increments the player's score by one.
     */
    @Override
    public void incrementScore() {
        score++;
    }
    /**
     * Gets the cards currently in the player's hand.
     *
     * @return A list of cards in the player's hand.
     */
    @Override
    public List<Card> getHand() {
        return hand.getCards();
    }
    /**
     * Sets the player's hand to a new list of cards.
     *
     * @param cards The new list of cards.
     */
    @Override
    public void setHand(List<Card> cards) {
        hand.setCards(cards);
    }
    /**
     * Adds a card to the player's hand.
     *
     * @param card The card to be added.
     */
    @Override
    public void addCard(Card card) {
        hand.addCard(card);
    }
    /**
     * Removes a card from the player's hand.
     *
     * @param card The card to be removed.
     */
    @Override
    public void removeCard(Card card) {
        hand.removeCard(card);
    }
    /**
     * Checks if the player has already submitted the specified card.
     *
     * @param card The card to check.
     * @return true if the card has been submitted, false otherwise.
     */
    @Override
    public boolean hasSubmitted(Card card) {
        return getHand().contains(card);
    }
    /**
     * Abstract method for choosing a red apple card.
     * This method must be implemented by subclasses of AbstractPlayer.
     *
     * @return The selected red apple card.
     */
    @Override
    public abstract Card chooseRedAppleCard();

    public abstract Card selectFavoriteRedApple(List<Card> submissions);
    /**
     * Abstract method for selecting the favorite red apple card from submissions.
     * This method must be implemented by subclasses of AbstractPlayer.
     *
     * @param submissions The list of red apple cards submitted by players.
     * @return The selected favorite red apple card.
     */
//    public abstract Card selectFavoriteRedApple(List<Card> submissions);
}
