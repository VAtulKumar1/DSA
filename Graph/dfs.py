# n,m = map(int,input().split()) # take node and edges as input and map them to n and m

# adj = [list() for _ in range(n+1)] # create a list that contains n empty lists

# for _ in range(m):  # 0 indexed undirected graph
#     u,v = map(int,input().split())
#     adj[u].append(v)  # append v to the list at uth index in adj list
#     adj[v].append(u)
n,m = 9,9
adj =[[1,6],[3,4,0],[],[1],[1,5],[4,8],[7,9,0],[6,8],[5,7],[6]]



def dfs(s,vis,adj):  
    print(s,end=" ")
    for i in adj[s]:
        if(vis[i]==0):
            vis[i] = 1
            dfs(i,vis,adj)  # call dfs for all non visited nodes


vis = [0 for _ in range(n+1)] # take vis array and initialize all index to zero

vis[0] = 1 # make 0th node as visited

s = 0

dfs(s,vis,adj)



# 9 9
# 0 1
# 0 6
# 1 3
# 1 4
# 6 7
# 6 9
# 4 5
# 7 8
# 5 8
# 0 1 3 4 5 8 7 6 9 