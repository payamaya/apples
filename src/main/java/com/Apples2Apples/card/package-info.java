/**
 * The {@code com.Apples2Apples.card} package defines the core structure and behavior
 * of cards used in the Apples to Apples game. It includes base card types, decorators
 * for extending card functionality, and utilities for managing card submissions.
 *
 * <h2>Classes in this Package</h2>
 * <ul>
 *   <li>{@link com.Apples2Apples.card.Card}: An abstract base class representing a general card.</li>
 *   <li>{@link com.Apples2Apples.card.GreenAppleCard}: Represents a green apple (adjective) card used as prompts.</li>
 *   <li>{@link com.Apples2Apples.card.RedAppleCard}: Represents a red apple (noun) card submitted by players.</li>
 *   <li>{@link com.Apples2Apples.card.CardDecorator}: A base class for creating custom card behaviors.</li>
 *   <li>{@link com.Apples2Apples.card.WildRedAppleCard}: A special red card allowing players to fill in their own answers.</li>
 *   <li>{@link com.Apples2Apples.card.ApplesAndPearsCard}: A special red card that replaces the green apple in play.</li>
 *   <li>{@link com.Apples2Apples.card.RedAppleSubmissionManager}: Manages red appleCard submissions and randomization.</li>
 * </ul>
 *
 * <h2>Design Patterns Used</h2>
 * <ul>
 *   <li><b>Decorator Pattern</b>: Used to extend the functionality of red apple cards
 *       (e.g., WildRedAppleCard, ApplesAndPearsCard) without modifying their base behavior.</li>
 *   <li><b>Single Responsibility Principle (SRP)</b>: Each class has a focused responsibility,
 *       such as defining card types, managing card submissions, or decorating cards.</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <p>
 * Players interact with cards through the {@link com.Apples2Apples.card.Card} hierarchy. Custom behaviors
 * can be added using decorators (e.g., {@link com.Apples2Apples.card.WildRedAppleCard}).
 * </p>
 *
 * <pre>{@code
 * // Example: Using a WildRedAppleCard
 * Card redCard = new RedAppleCard("Funny");
 * Card wildCard = new WildRedAppleCard(redCard);
 * System.out.println(wildCard.getDescription());
 * // Output: "Red Card: Funny (Wild Card: Fill your own answer)"
 * }</pre>
 *
 * <h2>Future Extensions</h2>
 * <ul>
 *   <li>Introduce additional special cards with unique effects (e.g., timer-based cards).</li>
 *   <li>Support voting mechanisms to replace judge-based selection phases.</li>
 *   <li>Enhance the card submission manager to support dynamic deck modifications.</li>
 * </ul>
 */
package com.Apples2Apples.card;

