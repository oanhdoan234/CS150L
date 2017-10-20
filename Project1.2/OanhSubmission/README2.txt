/** CS150 Project 1 
Author: Oanh Doan 
*/

- To first run the program, the user needs to specify the name of configuration file ("input.text") and the number of steps for the simulation. 
- Once the program runs, after the first step (printed as "Step 0" in the console), the user will be prompted to enter a letter that corresponds to one of the following request: 
	• p: print the state of the simulation. Print the charge of each car, the cars at each charging station,
	• t: print the state of each car (h - home, t - traveling, w - at a charging station),
	• e: print the state of each charging station, showing the cars (with ids) at each charging point (with ids)
	• s <integer n >: continue n steps forward in the simulation,
	• c: continue to the end of the simulation (number of time steps specified) without stopping,
	• x: exit the simulation now and print all relevant statistics
For each time step, the user can select only one command. 
- Please note that if any input values are changed, the result of the unit test of the class ProgramInput will no longer be true unless the code of the unit test is modified accordingly. This happens because the expected result in the unit test is hard-coded. 
