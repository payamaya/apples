/**
 * This package provides utility classes for the Apples to Apples game, offering various helper
 * methods and functionalities to manage different aspects of the game. The utilities include:
 *
 * - **CardUtil:** Provides methods for reading and creating red and green apple cards from files,
 *   allowing the game to load cards dynamically.
 * - **FileReaderService:** Handles reading card data from files and converting them into card objects.
 * - **LoggerUtil:** Offers centralized logging functionality for the application, supporting
 *   different log levels (info, warning, error).
 * - **CardDisplayService:** Manages the display of player hands, notifying players of updates
 *   and displaying cards when allowed.
 * - **CardReplenisher:** Replenishes cards for players by drawing cards from the deck to ensure
 *   players have the correct number of cards.
 * - **JudgeSelector:** Handles the random selection of a judge from the list of players and notifies
 *   all players of the selection.
 * - **JudgeUtil:** Contains methods for judge-specific actions, such as drawing green apple cards
 *   and notifying players about these actions.
 * - **TabelSizeUtil:** Contains utility methods for determining the number of green apples needed
 *   to win based on the number of players.
 *
 * These utility classes work together to manage game logic, enhance code modularity, and
 * facilitate ease of testing and debugging.
 */
package com.Apples2Apples.util;
