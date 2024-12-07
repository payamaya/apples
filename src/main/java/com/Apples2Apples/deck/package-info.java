/**
 * The {@code com.Apples2Apples.deck} package contains classes and interfaces
 * for managing the game's card decks. This package is responsible for:
 *
 * <ul>
 *   <li>Shuffling card decks using customizable strategies.</li>
 *   <li>Dealing cards to players during gameplay.</li>
 *   <li>Providing flexible and extendable mechanisms for deck management.</li>
 * </ul>
 *
 * <h2>Classes in this Package</h2>
 * <ul>
 *   <li>
 *     {@link com.Apples2Apples.deck.DeckManager}: Handles the distribution of cards to players,
 *     ensuring each player receives the correct number of cards.
 *   </li>
 *   <li>
 *     {@link com.Apples2Apples.deck.DeckShuffler}: Provides a utility method for shuffling decks
 *     using the default shuffle algorithm.
 *   </li>
 *   <li>
 *     {@link com.Apples2Apples.deck.DeckShuffleStrategy}: Defines a functional interface to enable
 *     custom shuffle strategies for decks.
 *   </li>
 *   <li>
 *     {@link com.Apples2Apples.deck.DefaultDeckShuffler}: Implements the {@code DeckShuffleStrategy}
 *     interface using the standard shuffle algorithm from the
 *     {@code java.util.Collections} class.
 *   </li>
 * </ul>
 *
 * <h2>Design Patterns Used</h2>
 * <ul>
 *   <li>
 *     <b>Strategy Pattern</b>: Enables the use of different shuffle strategies
 *     by decoupling the shuffle algorithm from the deck management logic.
 *   </li>
 *   <li>
 *     <b>Single Responsibility Principle (SRP)</b>: Ensures that each class
 *     in this package has a focused responsibility, making the codebase easier
 *     to maintain and extend.
 *   </li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <p>To shuffle a deck, use the {@code DeckShuffler} utility for default shuffling
 * or provide a custom implementation of {@code DeckShuffleStrategy}. To deal cards
 * to players, use the {@code DeckManager} class.</p>
 *
 * <pre>{@code
 * // Example: Shuffling and dealing cards
 * List<Card> deck = ...; // Initialize the deck
 * DeckShuffler.shuffleDeck(deck); // Shuffle the deck
 *
 * List<Player> players = ...; // Initialize the list of players
 * int handSize = 7; // Number of cards per hand
 * DeckManager deckManager = new DeckManager();
 * deckManager.dealCards(players, deck, handSize); // Deal cards to players
 * }</pre>
 *
 * <h2>Future Extensions</h2>
 * <p>This package can be extended to include features like tracking discarded cards,
 * implementing specialized deck types, or adding advanced shuffle algorithms.</p>
 */
package com.Apples2Apples.deck;