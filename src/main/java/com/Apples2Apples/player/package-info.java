/**
 * The `com.Apples2Apples.player` package contains classes and interfaces related to players
 * in the Apples to Apples game. It defines the core functionality for player actions,
 * including selecting cards, submitting red apples, and keeping track of scores.
 *
 * <p>This package follows the Factory design pattern to dynamically create instances of different
 * types of players (e.g., LocalPlayer, BotPlayer, OnlinePlayer). The Factory pattern allows for
 * flexibility in generating various types of players based on different contexts or game modes.</p>
 *
 * <p>The main components of this package include:</p>
 * <ul>
 *     <li>{@link Player} - An abstract class representing a generic player.</li>
 *     <li>{@link LocalPlayer}, {@link BotPlayer}, {@link OnlinePlayer} - Concrete implementations
 *         representing different types of players.</li>
 *     <li>{@link Hand} - A class representing the player's hand of cards.</li>
 *     <li>{@link CardChooser} - An interface defining the method for selecting cards.</li>
 * </ul>
 *
 * <p>The Factory pattern is used to instantiate the appropriate player type based on the game's
 * context. This ensures that the game logic can easily accommodate both human players and automated
 * bot players, as well as players from different platforms (local or online).</p>
 *
 * @since 1.0
 */
package com.Apples2Apples.player;