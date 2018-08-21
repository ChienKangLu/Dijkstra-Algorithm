/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author leo
 */
public class Graph {
    Vertex[] graph;
    public Graph(Vertex[] graph){
        this.graph=graph;
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<graph.length;i++){
            s+=graph[i]+"\n";
        }
        return s;
    }
    
    public String printSmallestCost(){
        String s="";
        for(int i=0;i<graph.length;i++){
            //System.out.println(graph[i].printSmallest()+"\n");
            if(graph[i].path!=null){
                s+=graph[i].printData()+"\n";
            }else{
                s+=graph[i].name+" "+"start"+"\n";
            }
        }
        return s;
    }
    
}
