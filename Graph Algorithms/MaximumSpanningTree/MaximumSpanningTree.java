
/*
 * MAXIMUM SPANNING TREE ALGORITHM
 * 
 * This algorithm uses a PQueue class and the GraphMaxSpanTree
 * 	The PQ class has a method called deleteMax which percolates the contents of the queue in such a way that the object with the highest "item". 
 * 	The Method just make the highest edge object come out of the queue first. The graphs class then has a method that creates a spTable which stores 
 * 	the edges of the maximum spanning tree created at a given starting node.
 * 
 * 
 * 
 * 
 * How it works:
 * 	The algorithm goes through the graph and calculates every possible graph based on each node and calculates which node has the highest total distance.
 * 
 * Sudo code
 * 	loop through all nodes.
 * 		run each node run through a method that returns the total sum of the weights of the edges
 * 		store the current highest total and compare all nodes to that total
 * 		store the node corresponding to the total distance
 * 	When you're done iterating through all the nodes send the node you stored with the highest corresponding weight use that node and send them through a method that builds
 * 	the table and print the distances and the node and its parent.
 * 
 *
 * 
 * EXAMPLE
 * 		Graph:
 * 				   {{0,8,3,6,0,0},
					{8,0,0,0,0,9},
					{3,0,0,5,0,0},
					{6,0,5,0,2,0},
					{0,0,0,2,0,1},
					{0,9,0,0,1,0}};
		output
			Tree Edges:
				2-1 weight 8
				3-4 weight 5
				4-1 weight 6
				5-4 weight 2
				6-2 weight 9
				Total Weight 30
 * 
 * 
 * 
 * 
 * Author Adam Smith
 * Version 11/14/18
 */
public class MaximumSpanningTree {
	public static void main(String [] args)
	{
		int nodes = 6; 
		int edges = 0;
		
		int [][] spTable = new int[nodes][3];

		int [][] graph =   
				   {{0,8,3,6,0,0},
					{8,0,0,0,0,9},
					{3,0,0,5,0,0},
					{6,0,5,0,2,0},
					{0,0,0,2,0,1},
					{0,9,0,0,1,0}};
		
		System.out.println("The program computes the Maximum spanning tree of a weighted graph");
		edges = AdamSmith_GraphMaxSpanTree.computeEdges(nodes, graph);    
		int temp = 0;
		int finalNode =0;
		int prevTotal= 0;
		AdamSmith_GraphMaxSpanTree.maxSpanTree(0, nodes, edges, graph, spTable);
		prevTotal = AdamSmith_GraphMaxSpanTree.findWeight(nodes, spTable);
		
		for (int i = 1; i < nodes; i++) {
			AdamSmith_GraphMaxSpanTree.maxSpanTree(i, nodes, edges, graph, spTable);
			temp = AdamSmith_GraphMaxSpanTree.findWeight(nodes, spTable);
			if (temp > prevTotal) {
				finalNode = i;
				prevTotal = temp;
			}
		}
		AdamSmith_GraphMaxSpanTree.maxSpanTree(finalNode, nodes, edges, graph, spTable);
		AdamSmith_GraphMaxSpanTree.printSpanTree(nodes, spTable);
		AdamSmith_GraphMaxSpanTree.printWeight(nodes, spTable);
	}
}


