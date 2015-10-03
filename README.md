# PackagingLab 
This is the Solution for the problem stated as the "Packaging Lab" problem as described on the document. The approach to solving the problem is making use of the Dynamic programming and the category of the problem is the Knapsack problem. 


The approach taken to solve the problem is a TDD based approach where we will first write the test case for the problem and then move to writing the actual solution, we would than re factor the actual solution code for optimization. 


The external libraries required would be:


1. JUNIT for Unit testing
2. Log4j for Logging


The approach I aim to follow is :- 


1. Write JUnit Test case(s) to ensure I follow the basic principle of TDD. 
2. Write Solution Class with basic Error Testing like whether the input is valid or not and its empty.
3. Write the main logic to take care of main requirements
4. Re factor to ensure readability and cleanliness.
5. Add logging
6. Aim to write an implementation Using another algorithm which may be greedy algorithm, which will work great for fractional knapsack problem but not here. 


One of the problems with this algorithm is that it cannot be run in a distributed environment like Hadoop or Spark Let me use Genetic programming to write a Class which uses Genetic programming and be distributed.


Implemented Genetic Algorithm but found it takes more time than DP solution, but the only advantage I could see was if we wanted it to work in a distributed environment, which is not the case here hence rejecting it, for this exercise.


Upon my analysis between DP, GA, and Greedy DP works best for this problem set with the constraints given.