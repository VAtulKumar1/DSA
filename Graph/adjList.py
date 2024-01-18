n,m = map(int,input().split()) # take node and edges as input and map them to n and m

adj = [list() for _ in range(n)] # create a list that contains n empty lists

for _ in range(n):  # 0 indexed undirected graph
    u,v = map(int,input().split())
    adj[u].append(v)  # append v to the list at uth index in adj list
    adj[v].append(u)

print(adj)

