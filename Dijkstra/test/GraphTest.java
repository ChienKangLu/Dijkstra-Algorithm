
import dijkstra.Dijkstra;
import dijkstra.Graph;
import dijkstra.Vertex;
import dijkstra.Weight;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leo
 */
public class GraphTest {
    public static void main(String args[]) {
        //create vertex
        Vertex a=new Vertex("a");//b(32) f(3)
        Vertex b=new Vertex("b");//a(32) f(7) c(21) e(12)  
        Vertex c=new Vertex("c");//f(2) b(21) e(6) g(11) 
        Vertex d=new Vertex("d");//e(13) g(9)
        Vertex e=new Vertex("e");//b(12) c(6) d(13)
        Vertex f=new Vertex("f");//a(3) b(7) c(2)
        Vertex g=new Vertex("g");//d(9) c(11)
        
        //create weight adjacent
        //b(32) f(3)
        List<Weight> a_adj=new LinkedList<>();
        a_adj.add(new Weight(b, 32));
        a_adj.add(new Weight(f, 3));
        a.setAdj(a_adj);
        //a(32) f(7) c(21) e(12)        
        List<Weight> b_adj=new LinkedList<>();
        b_adj.add(new Weight(a, 32));
        b_adj.add(new Weight(f, 7));
        b_adj.add(new Weight(c, 21));
        b_adj.add(new Weight(e, 12));
        b.setAdj(b_adj);
        //f(2) b(21) e(6) g(11)        
        List<Weight> c_adj=new LinkedList<>();
        c_adj.add(new Weight(f, 2));
        c_adj.add(new Weight(b, 21));
        c_adj.add(new Weight(e, 6));
        c_adj.add(new Weight(g, 11));
        c.setAdj(c_adj); 
        //e(13) g(9)
        List<Weight> d_adj=new LinkedList<>();
        d_adj.add(new Weight(e, 13));
        d_adj.add(new Weight(g, 9));
        d.setAdj(d_adj); 
        //b(12) c(6) d(13)
        List<Weight> e_adj=new LinkedList<>();
        e_adj.add(new Weight(b, 12));
        e_adj.add(new Weight(c, 6));
        e_adj.add(new Weight(d, 13));
        e.setAdj(e_adj); 
        //a(3) b(7) c(2)
        List<Weight> f_adj=new LinkedList<>();
        f_adj.add(new Weight(a, 3));
        f_adj.add(new Weight(b, 7));
        f_adj.add(new Weight(c, 2));
        f.setAdj(f_adj); 
        //d(9) c(11)
        List<Weight> g_adj=new LinkedList<>();
        g_adj.add(new Weight(d, 9));
        g_adj.add(new Weight(c, 11));
        g.setAdj(g_adj); 
        
        //create graph
        Vertex total[]={a,b,c,d,e,f,g};
        Graph graph=new Graph(total);
        System.out.println(graph);
        
        //Test Dijkstra algorithm for all sortest-path for start point
        Dijkstra dijkstra=new Dijkstra(graph);
        dijkstra.algorithm(a,null);
        //printSmallestCost
        System.out.println(graph.printSmallestCost());
        
        //printPath
        Vertex.printPath(d);
        System.out.println(" ("+d.dis+")");
        
        //Test Dijkstra algorithm from source to destination
        Dijkstra dijkstra2=new Dijkstra(graph);
        dijkstra2.algorithm(a,d);
        Vertex.printPath(d);
        System.out.println(" ("+d.dis+")");
    }
}
