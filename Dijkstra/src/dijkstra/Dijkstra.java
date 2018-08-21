/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Iterator;
import java.util.List;

/**
 * Dijkstra algorithm
 * @author leo
 */
public class Dijkstra {
    Graph g;
    public Dijkstra(Graph g){
        this.g=g;
    }
    public void algorithm(Vertex s,Vertex e){
        //initial all dis to infinity
        for(int i=0;i<g.graph.length;i++){
            g.graph[i].dis=Integer.MAX_VALUE;//infinity
            g.graph[i].know=false;//not know
        }
        //set start point length between start point to 0
        //still unknow right now
        s.dis=0;
        
        //find the smallest unknown distance vertex
        while(true){
            Vertex v=smallestUnkown();
            
            if(v==null){//by wiki https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
                break;
            }
            
            v.know=true;
            //use for from source to destination
            if(e!=null && v==e){
                return;
            }
            List<Weight> adj=v.adj;//get the adjacent vertex
            for (Iterator iter = adj.iterator(); iter.hasNext();) {
                Weight now = (Weight) iter.next();
                if(now.v.know==false){
                    /**
                     * if the smallest one add the weight to the adjacent vertex distance smaller than 
                     * the adjacent vertex distance,update the shortest-path length between start point
                     * 
                     * now.v.dis's initial value is infinity!
                     */
                    if(v.dis+now.weight<now.v.dis){
                        now.v.dis=v.dis+now.weight;//update the shortest-path length between start point(must be smaller)
                        
                        now.v.path=v;////the last previous vertex to update the dis
                    }
                }
            }
        }
    }
    /**
     * find the samllest unknown vertex
     * @return samllest unknown vertex
     */
    public Vertex smallestUnkown(){
        Vertex smallest=null;
        int smallestDist=Integer.MAX_VALUE;
        for(int i=0;i<g.graph.length;i++){
            Vertex now=g.graph[i];
            if(now.know==false){//must be the unknown
                if(now.dis<smallestDist){
                    smallest=now;
                }
            }
        }
        return smallest;
    }
            
}
