isConnected =[[1,1,0],[1,1,0],[0,0,1]]  # adj matrix
n = len(isConnected)
adj =[list() for _ in range(n+1)]  # empty list of list
for i in range(len(isConnected)):  # conversion to adj list
    for j in range(len(isConnected[i])):
        if(i != j and isConnected[i][j]==1):
            adj[i+1].append(j+1)



def dfs(s,vis,adj):  # dfs recursive
    for i in adj[s]:
        if(vis[i]== 0):
            vis[i] = 1
            dfs(i,vis,adj)



vis = [0 for _ in range(n+1)] 
res = 0
for i in range(1,n+1):  # to find all provinces in a disconnected graph 
    if(vis[i] == 0):
        res += 1
        dfs(i,vis,adj)

print(res)

print(adj)

