/**
 * The following is a high level description of my approach to program 1.
 * This file will consist of psedo code and comments describing my approach to each class, method, data structure, and variable.
 * First, I will start of by creating a step by step list of what I need to do to complete the program.
 */

/**
 * Step 1 Create a Data Class: 
 * This class will be used to hold one days COVID-19 data.
 * This class will have the following variables: Continent, Country, Day, Total Cases, Current Cases, and Population.
 * 
 * Step 2 Read and Process CSV Data:
 * In the Driver, there will be a method that will read in the CSV file and create instances of the Data class.
 * 
 * Step 3 Create a MinPQ:
 * This MinPQ class will be used to store the top 3 days with the most new cases for each country. 
 * The MinPQ will be sorted by the number of new cases.
 * 
 * Step 4 Create a BST:
 * This BST class will be used to store the top 3 days with the most new cases for each country from the MinPQ.
 * After the MinPQ is created, the BST will be created by removing the top 3 days from the MinPQ and inserting them into the BST.
 * Wich will then be used to print out the top 3 days with the most new cases for each country in order.
 * 
 * Step 5 Print out the top 3 days with the most new cases for each country in order:
 * This will be done by using the BST created in step 4.
 * Traverse the BST in order from smallest to largest new cases. For each node, I will print the continent, country, day, total cases, current cases, and population.
 * This information will be written to an output file.
 * 
 * Step 6 Comment/Document:
 * Comment and document the code.
 * 
 * Step 7 Write Driver (Main Program/Client):
 * The program will read the data, create instances of the Data class, populate the MinPQ, populate the BST, and write the data to the output file.
 * 
 * Step 8 Citations:
 * Citations will be added to the top of each file.
 */

//Main Program/Client psuedo code:
/**
 * Instantiate a MinPQ
 * Instantiate a BST
 * Read in the CSV file
 * Create instances of the Data class
 * Populate the MinPQ
 * Populate the BST
 * Write the data to the output file
 */

//Data Class psuedo code:
/**
 * Create a Data class
 * Create the following variables: Continent, Country, Day, Total Cases, Current Cases, and Population.
 * Create a constructor that takes in the following parameters: Continent, Country, Day, Total Cases, Current Cases, and Population.
 * Create getters and setters for each variable.
 */

//MinPQ Class psuedo code:
/**
 * Create a MinPQ class with key as a integer and value as a Data object
 * Create a private inner class Node
 * Create a method to insert a node into the MinPQ
 * Create a method to remove the minimum node from the MinPQ
 * Create a method to get the size of the MinPQ
 * Create a method to check if the MinPQ is empty
 * Create a method to clear the MinPQ
 */

//BST Class psuedo code:
/**
 * I will use my BST class from lab 4/5 for this program.
 * I will make the following changes to the BST class:
 * I will change the key to a String
 * I will change the value to a Data object
 */

//JavaDoc for Data Class:
/**
 * constructor:
 * @param Continent, Country, Day, Total Cases, Current Cases, and Population
 * @return none
 * @throws none
 * 
 * getContinent:
 * @param none
 * @return Continent
 * @throws none
 * 
 * setContinent:
 * @param Continent
 * @return none
 * @throws none
 * 
 * getCountry:
 * @param none
 * @return Country
 * @throws none
 * 
 * setCountry:
 * @param Country
 * @return none
 * @throws none
 * 
 * getDay:
 * @param none
 * @return Day
 * @throws none
 * 
 * setDay:
 * @param Day
 * @return none
 * @throws none
 * 
 * getTotalCases:
 * @param none
 * @return Total Cases
 * @throws none
 * 
 * setTotalCases:
 * @param Total Cases
 * @return none
 * @throws none
 * 
 * getCurrentCases:
 * @param none
 * @return Current Cases    
 * @throws none
 * 
 * setCurrentCases:
 * @param Current Cases
 * @return none
 * @throws none
 * 
 * getPopulation:
 * @param none
 * @return Population
 * @throws none
 * 
 * setPopulation:
 * @param Population
 * @return none
 * @throws none
 */

//JavaDoc for MinPQ Class:
/**
 * insert:
 * @param key, value
 * @return none
 * @throws none
 * 
 * removeMin:
 * @param none
 * @return none
 * @throws none
 * 
 * size:
 * @param none
 * @return size
 * @throws none
 * 
 * isEmpty:
 * @param none
 * @return true or false
 * @throws none
 * 
 * clear:
 * @param none
 * @return none
 * @throws none
 */

//JavaDoc for BST Class:
/**
 * constructor:
 * @param none
 * @return none
 * @throws none
 * 
 * size:
 * @param none
 * @return size 
 * @throws none
 * 
 * isEmpty:
 * @param none
 * @return true or false
 * @throws none
 * 
 * clear:
 * @param none
 * @return none
 * @throws none
 * 
 * contains:
 * @param Key
 * @return true or false
 * @throws none
 * 
 * put:
 * @param Key, Value
 * @return true or false
 * @throws none
 * 
 * get:
 * @param Key
 * @return Value
 * @throws none
 * 
 * remove:
 * @param Key
 * @return none
 * @throws none
 * 
 * inorder:
 * @param none
 * @return none
 * @throws none
 * 
 * preorder:
 * @param none
 * @return none
 * @throws none
 * 
 * postorder:
 * @param none
 * @return none
 * @throws none
 * 
 * levelOrder:
 * @param none
 * @return none
 * @throws none
 */

//JavaDoc for Driver Class:
/**
 * readFile:
 * @param file, tree
 * @return none
 * @throws none
 * 
 * main:
 * @param args
 * @return none
 * @throws none
 * 
 * The main method will be used to create instances of the Data class, populate the MinPQ, populate the BST, and write the data to the output file.
 * 
 * writeFile:
 * @param file, tree
 * @return none
 * @throws none
 */

//JavaDoc for Node Class:
/***
 * constructor:
 * @param Key, Value
 * @return none
 * @throws none
 * 
 * getKey:
 * @param none
 * @return Key
 * @throws none
 * 
 * setKey:
 * @param Key
 * @return none
 * @throws none
 * 
 * getValue:
 * @param none
 * @return Value
 * @throws none
 * 
 * setValue:
 * @param Value
 * @return none
 * @throws none
 */

/**
 * Data Structures used:
 * For the MinPQ, I will use an ArrayList as the underlying data structure.
 * For the BST, I will use a LinkedList as the underlying data structure.
 */
 