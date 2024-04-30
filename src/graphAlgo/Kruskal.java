package graphAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class edge
{
	int st, end, weight;
}
public class Kruskal
{
	public static int findParent(int v, int parent[])
	{
		if(parent[v]==v)
		{
			return v;
		}
		
			return findParent(parent[v], parent);
		
	}

	public static void kruskalAlgo(int v, int e, edge[] input)
	{
		edge output[]=new edge[v-1];
		int parent[]=new int[v];
		for(int i=0;i<v;i++)
		{
			parent[i]=i;
		}
		int count=0, i=0;
		while(count<v-1)
		{
			edge currEdge=input[i];
			int sourceParent=findParent(currEdge.st, parent);
			int destParent=findParent(currEdge.end, parent);
			if(sourceParent!=destParent)
			{
				output[count]=currEdge;
				count++;
				parent[sourceParent]=destParent;			
			}
			i++;
		}
		for( i=0;i<v-1;i++)
		{
			System.out.println( Math.min(output[i].st, output[i].end) 
			+ " "+  Math.max(output[i].st, output[i].end) +" " + output[i].weight );
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("HI SATISH");
		int V = sc.nextInt();
		int E = sc.nextInt();
		edge input[]=new edge[E];
		for(int i=0;i<E;i++)
		{
			input[i]=new edge();
			input[i].st=sc.nextInt();
			input[i].end=sc.nextInt();
			input[i].weight=sc.nextInt();
		}

		Arrays.sort(input, new Comparator<edge>() {
			public int compare(edge o1, edge o2)
			{
				//edge e1=(edge)o1;
				//edge e2=(edge)o2;
				if(o1.weight==o2.weight)
				return 0;
				else if(o1.weight<o2.weight)
				return -1;
				else 
				return 1;
			}
		});
		kruskalAlgo(V, E, input);
	}
}
