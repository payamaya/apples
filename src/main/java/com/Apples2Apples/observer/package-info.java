/**
 * The {@code com.Apples2Apples.observer} package implements the **Observer design pattern** to handle
 * game notifications, ensuring that all interested parties (observers) are notified of changes in the game
 * state or player actions.
 *
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Provide a means to broadcast messages to multiple observers.</li>
 *   <li>Allow different parts of the game to react to changes asynchronously.</li>
 *   <li>Separate the concerns of message broadcasting and receiving to maintain flexibility.</li>
 * </ul>
 *
 * <h2>Key Classes</h2>
 * <ul>
 *   <li>
 *     {@link com.Apples2Apples.observer.GameNotification}: A concrete implementation of the {@link Subject} interface,
 *     used to notify all registered observers about game-related events or messages.
 *   </li>
 *   <li>
 *     {@link com.Apples2Apples.observer.PlayerNotification}: Another implementation of the {@link Subject} interface,
 *     specifically designed for player-related notifications, such as status updates or score changes.
 *   </li>
 *   <li>
 *     {@link com.Apples2Apples.observer.Observer}: The interface that all observers must implement to receive
 *     updates from the subject.
 *   </li>
 *   <li>
 *     {@link com.Apples2Apples.observer.Subject}: The interface that defines the methods for adding, removing,
 *     and notifying observers.
 *   </li>
 * </ul>
 *
 * <h2>Design Patterns</h2>
 * <ul>
 *   <li><b>Observer Pattern:</b> Allows for loose coupling between subjects (like game or player events)
 *   and observers (such as UI components or game logic), enabling scalable notification systems.</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <p>To implement a notification system in the game, a {@link com.Apples2Apples.observer.Subject} (e.g., {@code GameNotification} or {@code PlayerNotification})
 * is instantiated and observers (implementing the {@link com.Apples2Apples.observer.Observer} interface) can register to receive updates. The subject notifies all
 * observers whenever there is a change (such as game status updates or player actions).</p>
 *
 * <pre>{@code
 * // Example: Notifying observers about a game event
 * GameNotification gameNotification = new GameNotification();
 * PlayerObserver playerObserver = new PlayerObserver();
 * gameNotification.addObserver(playerObserver);
 * gameNotification.setMessage("Round started!");
 * }</pre>
 */
package com.Apples2Apples.observer;
