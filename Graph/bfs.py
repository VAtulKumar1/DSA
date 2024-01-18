n,m = map(int,input().split()) # take node and edges as input and map them to n and m

adj = [list() for _ in range(n+1)] # create a list that contains n empty lists

for _ in range(m):  # 0 indexed undirected graph
    u,v = map(int,input().split())
    adj[u].append(v)  # append v to the list at uth index in adj list
    adj[v].append(u)

### BFS also known as level order traversal 
# traverse all elements at level 1 then 2 and so on and ofcourse with respect to starting node

q = [] # empty queue 
q.append(0) # assign starting node

vis = [0 for _ in range(n+1)] # take vis array and initialize all index to zero

vis[0] = 1 # make 0th node as visited

while(q):
    s = q.pop(0) # pop and element from the queue
    print(s,end=" ") 
    for i in adj[s]:  # iterate over all adjecent elements
        if(vis[i] == 0): # visit only when not visited
            q.append(i) # append non visited elements to queue
            vis[i] = 1  # also mark this as visited
    

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
# 0 1 6 3 4 7 9 5 8

