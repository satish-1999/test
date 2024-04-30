package graphTraversal;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS 
{
	public static ArrayList<Integer> getDFS(int edges[][], int n, int sv, int v2, boolean[] visited)
	{ 
		if(sv==v2)
		{
			ArrayList<Integer> l=new ArrayList<>();
			l.add(sv);
			return l;
		}
		visited[sv]=true;
		for(int i=0;i<n;i++)
		{
			if(i==sv)
				continue;
			if(visited[i])
				continue;
			
			if(edges[sv][i]==1)
			{
				ArrayList<Integer> list=getDFS(edges,n,i, v2, visited);
				if(list.size()!=0)
				{
					list.add(sv);
				}
				return list;
			}
		}
		ArrayList<Integer> l1=new ArrayList<>();
		return l1;
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
		int v1=sc.nextInt();
		int v2=sc.nextInt();
		boolean visited[]=new boolean[n];
		for(int i=0;i<n;i++)
		{
			visited[i]=false;
		}
		ArrayList<Integer> list= getDFS(edges,n, v1, v2, visited);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
}
