/*
 * The algorithm uses a class called Graphs
 * 	In the Graphs class there is a method that builds a distance table given a starting node, and finds the distance
 * 	between each node and finds the maximum distances.
 * 
 * The algorithm in this class loops through all the nodes and creates a distance table for each node being the start. The algorithm then uses a method in the graphs class
 * that accumulates all the edges weights and returns the total. If the total at the current node is higher than the previous then the node is stored in a temp variable.
 * When the loop is done what ever node is in the temp variable is ran through the maxWeightPath method and then the algorithm prints the the results.
 * 
 * 
 * All these if statements are for are when I want the method to return the current highest distance in the dTable or the total sums of the distances in the DTable.
 *  
 *  Example
 *  Graph:
0 1 0 0 11 0 0 
1 0 3 0 0 0 0 
0 3 0 10 0 0 8 
0 0 10 0 3 5 0 
11 0 0 3 0 4 9 
0 0 0 5 4 0 0 
0 0 8 0 9 0 0 

Place the fire station at village 5 with smallest total sum of shortest distances: 52
 * 
 * 
 * Author Adam Smith
 * Version 11/14/18
 */
public class FireStation {

    public static void main(String [] args)
    {
        int nodes = 7; 
        int currentNode = 0;
        int maxLength = 0;
        int [][] graph = 
        		{{ 0, 1,  0,  0, 11, 0, 0},
        		 {1, 0,  3,  0,  0, 0, 0},
        		 {0, 3,  0, 10,  0, 0, 8},
        		{ 0, 0, 10,  0,  3, 5, 0},
        		{11, 0,  0,  3,  0, 4, 9 },
        		 {0, 0,  0,  5,  4, 0, 0},
        		 {0, 0,  8,  0,  9, 0, 0}};
   
        System.out.println("Welcome to my program that decides where to put a fire station based on shortest total paths! There is no input, just create your graph in this class and run it.");
        System.out.println("Graph:");
        for (int i = 0; i < nodes; i++)
        {
        	for (int j = 0; j < nodes; j++)
        		System.out.print(graph[i][j] + " ");
        	System.out.println();
        }
        System.out.println();
        
        int temp = Graphs.maxWeightPath(0,nodes,graph, true);
        currentNode = 1;
        maxLength = temp;

        for (int i = 1; i < nodes; i++) {
        	temp = Graphs.maxWeightPath(i,nodes,graph, true);
        	if (temp < maxLength) {
        		currentNode = i+1;
        		maxLength = temp;
        	}
        }
        int totalLength = Graphs.maxWeightPath(currentNode-1, nodes, graph, false);
        System.out.println("Place the fire station at village "+ currentNode + " with smallest total sum of shortest distances: " + totalLength);
        System.out.println("End of Program");
    }
}

