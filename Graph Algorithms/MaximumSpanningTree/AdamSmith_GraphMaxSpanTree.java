

public class AdamSmith_GraphMaxSpanTree
{
	public static void maxSpanTree(int start, int nodes, int edges, 
			int [][] graph,int [][] spTable)
	{
		for (int i=0; i<nodes;i++) {
			spTable[i][0] = 0;
			spTable[i][1] = -1;
			spTable[i][2] = 0;
		}

		PQueueCell PQ = new PQueueCell(edges);
		Cell node = new Cell(0,start);
		PQ.insert(node);
		while(!PQ.isEmpty()) {
			Cell vCell = PQ.deleteMax();
			int v = vCell.getItem();

			spTable[v][0] = 1;

			for (int w =0; w < nodes; w++) {
				if(spTable[w][0] != 1 && graph[v][w] != 0) {
					if (graph[v][w] > spTable[w][2] || spTable[w][1] ==-1 ) {
						spTable[w][2] = graph[v][w];
						spTable[w][1] = v;
						node.setItem(w);
						node.setKey(graph[v][w]);
						PQ.insert(node);
					}
				}
			}
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
/*-------------------- print span tree Table ---------------------------*/
public static void printSpanTreeTable (int nodes, int [][] spTable)
{
	System.out.println("Min Span Tree table:");
	System.out.println("fixed" + "\t" + "parent" +"\t" + "weight");
	for (int i = 0; i < nodes; i++)
		System.out.println( spTable[i][0] + "\t" + (spTable[i][1] + 1) +"\t" + spTable[i][2]) ;
	System.out.println();
}
public static void printMaxSpanTreeTable (int nodes, int [][] spTable)
{
	System.out.println("Max Span Tree table:");
	System.out.println("fixed" + "\t" + "parent" +"\t" + "weight");
	for (int i = 0; i < nodes; i++)
		System.out.println( spTable[i][0] + "\t" + (spTable[i][1] + 1) +"\t" + spTable[i][2]) ;
	System.out.println();
}
/*-------------------- print span tree ---------------------------*/
public static void printSpanTree(int nodes, int [][] spTable)
{
	System.out.println("Tree Edges:");
	for(int i =0; i < nodes; i++) {
		if (spTable[i][2] == 0);
		else System.out.println((i+1)+"-"+(spTable[i][1]+1)+" weight "+spTable[i][2]);
	}

}
/*----------------------- print total weight --------------------------*/     
public static void printWeight(int nodes, int [][]spTable)
{
	int total =0;
	for(int i = 0; i < nodes;i++) {
		total += spTable[i][2];
	}
	System.out.println("Total Weight "+total);

}

public static int findWeight(int nodes, int [][]spTable)
{
	int total =0;
	for(int i = 0; i < nodes;i++) {
		total += spTable[i][2];
	}
	return total;

}

}
