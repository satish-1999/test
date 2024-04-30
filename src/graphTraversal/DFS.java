package graphTraversal;

import java.util.Scanner;

public class DFS 
{
	public static void printDFS(int edges[][], int n, int sv, boolean[] visited)
	{ 
		System.out.println(sv);
		visited[sv]=true;
		for(int i=0;i<n;i++)
		{
			if(i==sv)
				continue;
			if(visited[i])
				continue;
			
			if(edges[sv][i]==1)
			{
				printDFS(edges,n,i,visited);
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
		printDFS(edges,n, 0, visited);
	}
}
