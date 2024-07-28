class Solution:
    def secondMinimum(self, n, edges, time, change):
        # dist: keep the min and sub-min distance so far, using set to keep only 2 unique values
        # conn: connection table to record connected nodes 
        # h: priority queue to track the potential path, in the format of (dist, idx)
        h = [(0, 1)]   # starting from node 1, with dist of 0
        conn = defaultdict(set)
        dist = [set() for _ in range(n+1)]
        dist[1] = set([0])
        
        for s, e in edges:
            conn[s].add(e)
            conn[e].add(s)
        
        while h:
            d, idx = heappop(h)
            if idx == n and len(dist[n]) == 2:
                break
            
            # calculate the cost to nei, for a certain node, all of its neighbors will have the same time cost
            if (d // change) % 2 == 0: # green means go, green (0) -> red (1) -> green (2) -> red (3)
                cost = d + time
            else:
                cost = ceil(d / (change * 2)) * (change * 2) + time    
            for nei in conn[idx]:
                # valid nei is only when it's visited once or twice (only the shortest or sub-shortest 
                # path is needed), or more times if prior paths generate the same time cost
                if len(dist[nei]) <= 1:
                    dist[nei].add(cost)
                    heappush(h, (cost, nei))
        return max(dist[n])