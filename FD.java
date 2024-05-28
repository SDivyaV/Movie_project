import java.util.*;

public class FD{
  private int distancematrix[][];
  public int numberofvertices;
  private final static int INFINITY = 999;
  Scanner sc = new Scanner(System.in);
  public FD(int numberofvertices)
  {
    distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
    this.numberofvertices = numberofvertices;
  }
  public void floydwarshall(int adjacencymatrix[][])
  {
    for(int source = 1;source<=numberofvertices;source++)
     {
        for(int destination = 1;destination<=numberofvertices;destination++)
          {
             distancematrix[source][destination] = adjacencymatrix[source][destination];
          }
     }
   for(int intermediate = 1;intermediate<=numberofvertices;intermediate++)
    {

    for(int source = 1;source<=numberofvertices;source++)
     {
        for(int destination = 1;destination<=numberofvertices;destination++)
          {
             distancematrix[source][destination] = adjacencymatrix[source][destination];
             if(distancematrix[source][intermediate] + distancematrix[intermediate][destination] < distancematrix[source][destination])
              distancematrix[source][destination] = distancematrix[source][intermediate] + distancematrix[intermediate][destination];
          }
      }
   }
  System.out.println();
    for(int source = 1;source<=numberofvertices;source++)
     {
         System.out.println(source + "\t");
        for(int destination = 1;destination<=numberofvertices;destination++)
          { 
              System.out.println(distancematrix[source][destination] + "\t");
          }
       System.out.println();
     }
  }

public static void main(String[] args)
{
  int adjacency_matrix[][];
  int numberofvertices;
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the number of vertices ::");
  numberofvertices = sc.nextInt();
  adjacency_matrix = new int[numberofvertices + 1][numberofvertices + 1];
  System.out.println("Enter the weighted matrix of the Graph ");
  for(int source = 1;source<=numberofvertices;source++)
     {
        for(int destination = 1;destination<=numberofvertices;destination++)
          {
               adjacency_matrix[source][destination] = sc.nextInt();
               if(source==destination)
               {
                  adjacency_matrix[source][destination] = 0;
                  continue;
               }
               if(adjacency_matrix[source][destination] == 0)
               {  
                   adjacency_matrix[source][destination] = INFINITY;
               }
          }
     }
    System.out.println("The Transitive Closure of the Graph");
    FD floydwarshall = new FD(numberofvertices);
    floydwarshall.floydwarshall(adjacency_matrix);
    sc.close();
}
}