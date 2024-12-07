/**
 * The `com.Apples2Apples.phases` package defines and manages the phases of the Apples to Apples game,
 * encapsulating specific game states as individual behaviors. Each phase is implemented as a separate
 * class that adheres to the GamePhase interface, enabling dynamic transitions and flexible execution.
 *
 * ## Design Patterns
 * This package primarily implements the **State Pattern** to represent the various states of the game
 * and their transitions. The behavior of the game changes depending on the current phase, and the
 * phases are executed sequentially.
 *
 * Additionally, the **Strategy Pattern** is used to implement each phase in a modular way, allowing
 * for interchangeable behaviors through the common GamePhase interface.
 *
 * ## Classes
 * - `GamePhase`: The interface defining the contract for all phases.
 * - `DrawGreenApplePhase`: Handles drawing a green apple card.
 * - `SubmitRedApplePhase`: Manages the submission of red apple cards by players.
 * - `JudgePhase`: Oversees the judging process to determine a winning card.
 * - `ReplenishHandPhase`: Handles the replenishment of players' hands.
 * - `RotateJudgePhase`: Rotates the role of the judge to the next player.
 *
 * ## Usage
 * Phases are dynamically added to the game at runtime and executed sequentially via the
 * `Game.nextPhase()` method. This approach ensures a modular and flexible game flow.
 */


package com.Apples2Apples.phases;
