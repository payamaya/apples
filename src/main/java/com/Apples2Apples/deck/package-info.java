/**
 * The {@code com.Apples2Apples.deck} package manages the game's card decks,
 * including shuffling, dealing cards, and supporting custom shuffle strategies.
 *
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Shuffling card decks using default or custom strategies.</li>
 *   <li>Dealing cards to players based on predefined hand sizes.</li>
 *   <li>Providing extendable mechanisms for deck operations.</li>
 * </ul>
 *
 * <h2>Key Classes</h2>
 * <ul>
 *   <li>{@link com.Apples2Apples.deck.DeckManager}: Manages card distribution to players during gameplay.</li>
 *   <li>{@link com.Apples2Apples.deck.DeckShuffler}: Provides a utility method for shuffling card decks.</li>
 *   <li>{@link com.Apples2Apples.deck.DeckShuffleStrategy}: Defines a functional interface for implementing custom shuffle algorithms.</li>
 *   <li>{@link com.Apples2Apples.deck.DefaultDeckShuffler}: Implements the default shuffle strategy using {@code Collections.shuffle()}.</li>
 * </ul>
 *
 * <h2>Design Patterns</h2>
 * <ul>
 *   <li><b>Strategy Pattern:</b> Allows flexibility in shuffle algorithms.</li>
 *   <li><b>Single Responsibility Principle (SRP):</b> Ensures each class focuses on a single task (e.g., shuffling or dealing cards).</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <p>To shuffle and deal cards:</p>
 * <pre>{@code
 * // Initialize a deck and players
 * List<Card> deck = ...;
 * List<Player> players = ...;
 * int handSize = 7;
 *
 * // Shuffle the deck
 * DeckShuffler.shuffleDeck(deck);
 *
 * // Deal cards to players
 * DeckManager deckManager = new DeckManager();
 * deckManager.dealCards(players, deck, handSize);
 * }</pre>
 *
 * <h2>Future Extensions</h2>
 * <ul>
 *   <li>Tracking discarded cards for recycling or analysis.</li>
 *   <li>Implementing specialized deck types (e.g., themed or multi-deck setups).</li>
 *   <li>Adding advanced shuffle algorithms, such as seed-based or user-defined shuffling.</li>
 * </ul>
 */
package com.Apples2Apples.deck;
