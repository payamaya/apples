/**
 * The `com.Apples2Apples.network` package provides the networking components for the Apples to Apples game.
 * It includes the necessary abstractions for supporting various network protocols, enabling easy extensibility
 * and integration with different networking technologies. The main goal of this package is to simplify the process
 * of setting up network communication, abstracting away the complexities of the underlying protocols.
 *
 * <p>The package follows the **Abstract Factory** design pattern to allow seamless support for different
 * networking protocols such as TCP, UDP, WebSocket, and QUIC. This allows the game to be easily adaptable to
 * new protocols without requiring changes to the game logic.</p>
 *
 * <p>Key components of this package include:</p>

 *
 * <p>The **Abstract Factory** pattern is particularly well-suited here because networking protocols often require
 * complex and specific setup steps that vary between protocols. By using the factory, users can focus on interacting
 *
 * <p>This package allows for easy extensibility. New protocols can be added by implementing the necessary server
 * factory and client classes without affecting existing code or requiring changes to the game logic. As a result,
 * this design improves **flexibility**, **maintainability**, and **testability** while adhering to SOLID principles,
 * especially the **Dependency Inversion Principle** (D) and **Interface Segregation Principle** (I).</p>
 *
 * <p>Currently, a TCP-based server is implemented as the default, but additional protocol factories can be added
 * with minimal changes to the rest of the codebase.</p>
 *
 * @since 1.0
 */
package com.Apples2Apples.networking;