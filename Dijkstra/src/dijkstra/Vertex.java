/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Iterator;
import java.util.List;

/**
 * smallest entity in graph
 * @author leo
 */
public class Vertex {
    public String name;// just form vertify differ Vertex in graph(read friendly)
    public List<Weight> adj;//the adjacent vertex
    public boolean know;
    public int dis;//the shortest-path length between start point
    public Vertex path;//the previous vertex
    
    /**
     * create a vertex and give a name
     * @param name 
     */
    public Vertex(String name){
        this.name=name;
    }
    /**
     * set this vertex' adjacent
     * @param adj 
     */
    public void setAdj(List<Weight> adj){
        this.adj=adj;
    }

    /**
     * print the vertex name and it adjacent certext name and weight
     * @return 
     */
    @Override
    public String toString() {
        String s="";
        s+=this.name+"  ";
        for(Iterator iter=this.adj.iterator();iter.hasNext();){
            Weight adjNow=(Weight)iter.next();
            s+=adjNow.toString();
        }
        return s;
    }
    
    /**
     * for seeing the shortest distance beteen the starting point
     * @return string
     */
    public String printData(){
        return this.name+" ["+path.name+","+dis+"]";
    }
    /**
     * use recursive to print the path to v(start point's path will be null,terminate the recursive)
     * @param v
     */
    public static void printPath(Vertex v){
        if(v.path!=null){
            printPath(v.path);
            System.out.print("  to  ");
        }
        System.out.print(v.name);
        
    }
    
}
