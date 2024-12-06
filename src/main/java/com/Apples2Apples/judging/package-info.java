/**
 * This package (`com.Apples2Apples.judging`) defines the core components
 * related to judging mechanics in the Apples2Apples game. It provides classes
 * and interfaces for selecting winning cards and managing judge interactions.
 *
 * The key components include:
 *
 *  * **JudgingStrategy:** This interface defines a contract for selecting a
 *    winning card from a list of red apple card submissions. Concrete implementations
 *    can define different judging algorithms.
 *  * **DefaultJudgingStrategy:** This class implements the `JudgingStrategy`
 *    interface by delegating the selection of the winning card to the judge's
 *    logic (`Player.selectFavoriteRedApple`).
 *  * **JudgeManager:** This class manages the judging process. It takes a
 *    `JudgingStrategy` and a `NotificationService` as dependencies
 *    during construction. It provides a `selectWinner` method that handles
 *    selecting a winning card, notifying the players, and potentially tracking
 *    card submissions (implementation detail).
 *  * **NotificationService:** This class provides functionalities for sending
 *    game notifications. It injects a `GameNotification` dependency during
 *    construction and exposes a `notify` method to send messages.
 */
package com.Apples2Apples.judging;