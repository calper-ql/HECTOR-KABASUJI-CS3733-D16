Project Hector
Can Alper - calper@wpi.edu
Zach Armsby - zrarmsby@wpi.edu
Courtney Davis - cedavis@wpi.edu
Morgan Garbett - mlgarbett@wpi.edu
Mike Harney - mdharney@wpi.edu
Ryan Wiesenberg - rmwiesenberg@wpi.edu

To Run from Eclipse:
Import the Hector_Kabasuji to your workspace,
**Since our Levels are saved to 15 presaved files please run application first.
To run our application for the Kabasuji Application from Eclipse open the Hector project and then the src package click "kabasuji.application" and Run As a Java Application.

To run our application for the Kabasuji Level Builder from Eclipse open the Hector project and then the src package click "kabasuji.builder" and Run As a Java Application.

To run tests go to tests folder "hector_Kabasuji" Run as coverage. 

Game Controls:
Click and drag pieces for Board and Bullpen
While piece is being dragged, the following keys will rotate and flip the piece:
	‘r’ key - rotate right
	‘l’ key - rotate right
	‘h’ - flip horizontally
	‘v’ = flip vertically

A Note on Base Levels:
As requested by Professor Heineman, we are including a note on the functionality of creating and deleting levels in the context of our Base Level framework.
 Because the BaseLevelGenerator class generates levels before either application is run, the user of Level Builder does not have the ability to actually create or a delete levels. 
Instead, 15 ‘blank levels’ exist for the Level Builder user to edit. When the user saves changes, they are overwritten on that base level. 
This is how a level is “created.” Similarly, when the user of Level Builder decides to “delete” a level, that level is reset to a blank base level. 
This system offers the same functionality to the user of creating and deleting levels, however as our code might not look that way, we felt it necessary to provide further explanation. 
TO MAKE OWN LEVELS GO INTO BUILDER AND HIT RESET BUTTON ON THE LEVEL TO OVERWRITE. IT WILL BE SET TO BASE AND YOU CAN MAKE A NEW LEVEL OF THAT TYPE.