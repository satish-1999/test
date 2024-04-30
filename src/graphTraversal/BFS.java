package graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS 
{
	public static void printBFS(int edges[][], int n, int sv, boolean[] visited)
	{ 
		Queue<Integer> pq=new LinkedList<>(); 
		pq.add(sv);
		visited[sv]=true;
		while(pq.size()!=0)
		{
			int front=pq.peek();
			pq.poll();
			System.out.println(front);
			for(int i=0;i<n;i++)
			{
				if(visited[i])
					continue;
				if(edges[front][i]==1)
				{
					pq.add(i);
					visited[i]=true;
				}
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int edges[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				edges[i][j]=0;
		}
		int e=sc.nextInt();
		for(int i=0;i<e;i++)
		{
			int f=sc.nextInt();
			int s=sc.nextInt();
			edges[f][s]=1;
			edges[s][f]=1;
		}
		
		boolean visited[]=new boolean[n];
		for(int i=0;i<n;i++)
		{
			visited[i]=false;
		}
		printBFS(edges,n, 0, visited);
	}
}
