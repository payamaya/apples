/**
 * This package implements the Decorator design pattern to define different types of cards for a game.
 *
 * The `Card` class acts as the base component, providing the core functionality for all cards.
 * The abstract `CardDecorator` class allows extending the functionality of the `Card` at runtime without modifying its structure.
 *
 * Concrete implementations like `RedAppleCard` and `GreenAppleCard` inherit from `Card` and represent specific card types.
 * Special cards like `WildRedAppleCard` and `ApplesAndPearsCard` further demonstrate the flexibility offered by the decorator pattern.
 */
package com.Apples2Apples.card;

