#Game of Three

Coding ChallengeThe goal is to implement a game with two independent agents –the “players” –communicating with each other using an interface.
When a player starts, a random whole number is generated and sent to the other player, which indicates the start of the game.
The receiving player must now add one of { --1, 0, 1 } to get a number that is divisible by 3 and then divide it.
The resulting number is then sent back to the original sender.
The same rules apply until one of the players reaches the number 1 after division, which ends the game.
Example:Sufficient output should be generated for each move. Both “players” should be able to play automatically without user input.


##Notes

* Each player runs as an independent process

* Communication via an interface of your choice (HTTP, messaging...)

* A player may not be available when the other one starts

* The project should be runnable easily in any environment and provide an entry point to start the game with the two players

* Don’t forget documentation (how to start the game?)


##Solution

* There will be separate producer and consumer for each players.
* It will be a command line application and manager will start the game and declare the winner to end the game.
* There will application manager class


17

p1  p2
    17 +1, %3
6   2 +1, %3
    1