/**
 * Package com.Apples2Apples.player
 *
 * This package contains the core abstractions and implementations for players in the game,
 * including human, bot, and local players. The factory pattern is used to dynamically create players,
 * and responsibilities like managing hands and judging are distributed based on the SOLID principles.
 *
 * Design Patterns:
 * - Factory: Used for player creation.
 * - Strategy (Partial): Behavior like card selection varies across player types.
 * - Observer: Handles player notifications.
 *
 * Future Modifications:
 * The design allows for the introduction of new player types (e.g., online players) and
 * extensible game mechanics with minimal changes to existing code.
 */
package com.Apples2Apples.player;