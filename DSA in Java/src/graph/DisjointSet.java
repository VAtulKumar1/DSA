package graph;
// to find that u and v are the part of same component
// Two ways union by rank and union by size
//part 1
// initialize two arrays parent and rank
// initially parent[i] = i coz its a single node  and rank of all nodes 0
//for (u,v) add ultimate parent of u with smaller rank to ultimate parent of v  with higher rank
// if rank is same for both ultimate parent then add as per your choice
// when finding ultimate parent compress the tree to find parent in constant
// same for part 2
import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank= new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer>  size=new ArrayList<>();
    public DisjointSet(int v){
        for(int i=0;i<v;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int p_node=findUParent(parent.get(node));
        parent.set(node,p_node);

        return parent.get(node);
    }

    public void Union(int u,int v){
        int up_u=findUParent(u);
        int up_v=findUParent(v);
        if(up_u==up_v) return;
        if(rank.get(up_u)>rank.get(up_v)){
            parent.set(up_v,up_u);
        }
        else if(rank.get(up_u)<rank.get(up_v)){
            parent.set(up_u,up_v);
        }
        else{
            parent.set(up_u,up_v);
            int rank_u=rank.get(up_u);
            rank.set(up_u,rank_u+1);
        }
    }

    public void UnionBySize(int u,int v){
        int up_u=findUParent(u);
        int up_v=findUParent(v);
        if(up_u==up_v) return;
        if(size.get(up_u)>size.get(up_v)){
            parent.set(up_v,up_u);
            int su=size.get(up_u);
            int sv=size.get(up_v);

            size.set(up_u,su+sv);
        }
        else{
            parent.set(up_u,up_v);
            int su=size.get(up_u);
            int sv=size.get(up_v);

            size.set(up_v,su+sv);
        }
    }


    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet(7);
        ds.UnionBySize(0,1);
        ds.UnionBySize(1,2);
        ds.UnionBySize(3,4);
        if(ds.findUParent(2)==ds.findUParent(6)){
            System.out.println("same");
        }
        else{
            System.out.println("notSame");
        }
        ds.UnionBySize(5,6);
        ds.UnionBySize(4,5);
        ds.UnionBySize(2,6);
        if(ds.findUParent(2)==ds.findUParent(6)){
            System.out.println("same");
        }
        else{
            System.out.println("notSame");
        }
    }


}


