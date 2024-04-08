# DrivingFrenzy

This is a vehicles speed competition. Several vehicles run individually in a track to do the best time. 
From the Main menu in the ControlCenter you should launch one of the types of races (currently, only simpleRandomRace is implemented). 

The main parts in this project are: 
- ControlCenter, located in the ``main`` package. It is the one that has a ``main`` method and allows us to run races.  
- ``Vehicle``, located in the ``vehicles`` package. It is an interface showing the methods that the ControlCenter can use to simulate how the vehicles drive. 
    - In the same package there is a ``Scooter`` class, implementing this interface, as an example. 
- ``Track``, located in the ``race`` package. It is just a placeholder for ``Section`` objects - each Track will have one or more sections (think of sections as the different turns and straight roads that a real track could have)  
    - In the same package there is a ``Section`` interface defining which operations a section should have. There is also a ``StandardIndoorSection`` which represents just a simple road.
    - **The max speed in each section is not defined by the vehicle, but by the section. I.e, the max speed in a section is the same for a Ferrari and Go-Go-Action Bronco.**

Note that several of the interfaces define utility methods to return a description; this is used from the `ControlCenter` to print information in command line.

The goals of this example are to: 
- show the use of interfaces - note that to actually do the competition we only need to access to "Vehicle" objects, we do not need to declare them as Scooter or any other vehicle type. 
- show how we can create different objects of the same Class with different characteristics. 
- show how we can use objects between functions. 


## The Control Center
The control center simulates careers. After the track and Vehicles are defined, it will: 
1. Choose the next vehicle. 
2. Ask the vehicle to adapt its speed by giving the vehicle information about the next section. **The vehicles must only use the theoretical max speed of the section to adapt**.
3. Check what is the new speed of the vehicle. That speed will be used for that specific section. 
4. Go back to point 2 until there are not any sections left. 
5. Go back to point 1 until there are not any vehicles left.
6. Show the result (total time) of each vehicle. 

Also, the Control Center will print information about the drivers and the track, and how each vehicle is doing.

The assignment follows; **the code must be properly commented**. 

## Setup and Evaluation
The assignment is self-driven and self-paced. 
- Each student will be assigned to a random group, each group will have 3 students.
- Only one laptop is allowed per group. Students will take turns to be completing the assignment. This is an adaptation of [Pair programming](https://www.codementor.io/pair-programming).
- The steps of the assignment are sequential.
- At certain points the students will be questioned to evaluate the job done so far.
> These checkpoints are quoted as this line.
- It is not intended that the students reach the end of the assignment; the goal is to reach as far as possible. 

## Assignment steps
### Initial steps

- Run the application several times as it is and try to follow the code, to understand how it works.
- Create a UML Class diagram of the current project. Be specific about the visibility of methods and variables.
> The diagrams will be reviewed and evaluated. All of the members of the group must explain it the portion they are asked for.
- Create a method called ``defaultRace`` in the `ControlCenter`. This is a simpler version of the ``simpleRandomRace`` method, but in this case everything is predefined (not randomized): 
    - We have a track with 5 sections of 1000, 2000, 3000, 2000 and 1000 meters of length; you can choose the max speed.
    - We have just 3 vehicles, they will be Scooters. Give the vehicles proper descriptions and drivers. 
- Run the race.
> The code will be reviewed. Questions about the code will be asked randomly to the students. 
- Sort the results so we print the different vehicles/drivers in order - by position. To do this, the method ``start`` can be modified just in the last part, the one with the comment  ``MODIFY THIS to show the results sorted by total time.`` 
- Implement a new type of vehicle. This vehicle is a Kart with 2 gears. Before coding it, add it tou your UML diagram. 
    - Each gear will have a minimum and maximum speed. 
    - When calling to `adaptSpeed`, the Kart can do only one of the following: 
        - Increase or decrease speed within the current gear. 
        - Shift a gear up (new speed will be the minimum speed of the second gear).
        - Shift a gear down (new speed can be any within the range of the first gear).
- Create a new race (i.e, a new method in the Control Center) and test the new Kart.
> The code will be reviewed. Questions about the code will be asked randomly to the students. 

### Next steps 
- Create a race in which both Scooters and Karts compete together. Remember, **the ``start`` method cannot be modified at this point**.
    - Choose 3 real one-gear Scooters and 3 real 2-gear Karts to get actual statistics on speed - don't spend more than 10 minutes searching, otherwise, just make up the numbers.
- Create a new type of ``Section`` called ``StandardOutsideSection``. This one has its theoretical max speed, but also the actual one. The actual one is just a percentage of the theoretical one. 
    - For instance, think of a rainy day. Actual max speed could be ``0.7 * maxSpeed``. Or, think of a very sunny day; the actual max speed could be ``1.1 * maxSpeed``.
    - This is not randomized. When creating the Object, the percentage must be provided and also a proper description. 
> The code will be reviewed. Questions about the code will be asked randomly to the students.
- **From this point on, you can modify the start method as needed.**
- Modify the ``start`` method: if a vehicle goes over the actual max speed of a section, it goes out of the track and gets disqualified.
- When listing the positions, you must also show the disqualified vehicles and in which section they were disqualified.
- Run a new Scooters + Karts race, but with both indoor and outdoor sections. 
> The code will be reviewed. Questions about the code will be asked randomly to the students. 

### Final steps 
- Implement some randomization to the speed of the vehicles to simulate that the drivers sometimes make mistakes. When adapting the speed, all of the vehicles add a random factor to the speed by multiplying it by a random number between 0.8 and 1.0.
  - Don´t implement this directly in all of the vehicles. Find a way to implement it just once (inheritance). Also, make the code less redundant - likely, Scooter and Kart have attributes and methods in common.
- Automate the creation of a long track - at least, 50 kilometers with 5 sections. It must be random, and combine different types of sections.
> The code will be reviewed. Questions about the code will be asked randomly to the students. 
- Modify the sections so they provide extra information for the drivers. A section will offer a method `getVariationLevel` which will be -1 if somehow it is impaired and vehicles should go slower, 0 if standard, or 1 if vehicles can go faster. Do not provide the exact modifier that is being applied... 
  - Do it similar to the last vehicles change. 
- Implement a new type of vehicles with 6 gears, normal cars. Also, these cars are allowed to use the information of `getVariationLevel`.
    - Implement the ``adaptSpeed`` method similar to the one in the Karts. However, the vehicle has a new attribute `driverStyle` which can be standard, aggressive or conservative. 
        - An aggressive driver will try to play with the odds to go faster than the theoretical max speed. For instance, if the variation level is positive, it will be aggressive, if it is 0 it will still be aggressive to compensate for the its own randomization speed (see point 1). 
        - A conservative driver will always try to prevent getting out of the track.    
        - A standard driver will have an average behavior.
    - Test it in a race. 
> The code will be reviewed. Questions about the code will be asked randomly to the students.
- Modify the full code so the vehicles compete simultaneously, and add commentator mentions about when a car overtakes another one, etc. Make it real! 
