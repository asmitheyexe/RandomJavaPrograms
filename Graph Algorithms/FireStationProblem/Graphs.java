
public class Graphs
{
    public static int maxWeightPath(int start, int nodes,  
                                     int [][] graph, boolean returnMax)
    {
    	int totalEdges = computeEdges(nodes, graph);
    	PQueueCell PQ = new PQueueCell(totalEdges);
    	int [][] dTable = new int[nodes][2];
        for(int i = 0; i < nodes; i++)
	     {
	         dTable[i][0] = -1;
	         dTable[i][1] = -1;
	     }
	    dTable[start][0] = 0;
	    Cell node = new Cell(0, start);
	    PQ.insert(node);
	    
	    int new_distance=0;
	 
	    while(!PQ.isEmpty()) {
	    	Cell vCell = PQ.deleteMin();
	    	int item = vCell.getItem();
	    	for(int w = 0; w < nodes; w++) {
	    		if(graph[item][w] !=0) {
	    			new_distance = dTable[item][0] + graph[item][w];
	    			if (dTable[w][0] == -1 || dTable[w][0] > new_distance) {
	    				dTable[w][0] = new_distance;
	    				node.setKey(new_distance);
	    				node.setItem(w);
	    				PQ.insert(node);
	    				dTable[w][1] = item;
	    			}
	    		}
	    	}
	    }
	    if (returnMax) {
	    	int max =0;
	    	for (int i = 0; i < nodes;i++) {
	    		if (dTable[i][0] > max) max = dTable[i][0];
	    	}
	    	return max;
	    }
	    else {
	    	int max =0;
	    	for (int i = 0; i < nodes;i++) {
	    		max += dTable[i][0];
	    	}
	    	return max;
	    }
    }
    
  public static void printMaxPath(int target,int [][]dTable)
  {
	  if(dTable[target][1] ==-1) {
		  System.out.println("No path to " + (target+1));
	  }else {
		  System.out.print("Path to " + (target+1) + " with distance " + dTable[target][0]+ ": ");
		  recursivePathPrint(target,dTable);
	  }
	 System.out.println("");
   }
  public static void recursivePathPrint(int target, int [][] dTable)
  {  
	  if(target == -1) {
		  return;
	  }
	  else {
		  recursivePathPrint(dTable[target][1], dTable);
		  System.out.print(target+1+ " ");
	  }
  }
  
public static int computeEdges(int nodes, int [][]graph)
{
   int edges = 0;
   for( int i = 0; i < nodes; i++)
    for( int j = 0; j < nodes; j++)
      if (graph[i][j] != 0) edges++; 
   return edges;
}

 public static void printDistanceTable(int nodes, int [][] dTable)
 {
   System.out.println("Distance table:");
   System.out.println("Node\tDistance\t\tParent");
     for (int i = 0; i < nodes; i++)
      System.out.println((i+1) +"\t" + dTable[i][0] + "\t\t" + (dTable[i][1]+1));
     System.out.println();  
 }

}
