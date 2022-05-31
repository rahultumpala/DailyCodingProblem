# --------- Question ---------
#
# You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall.
# Each False boolean represents a tile you can walk on.
#
# Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. 
# If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
#
# For example, given the following board:
#
# [[f, f, f, f],
# [t, t, f, t],
# [f, f, f, f],
# [f, f, f, f]]
# and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, 
# since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
#
# --------- End Question ---------

from collections import deque
class Solution:
    
    
    # Uses a BFS Approach 
    # The shortest path is the level at which the end tile is found
    # Worst case Time Complexity = O(M*N) where M = rows and N = cols - in this case all tiles are True and we have to visit them all
    def shortest_path(self, target_map, start, end):
        # Edge Cases
        if(len(target_map) == 0):
            return 0
        if (start[0] == end[0] and start[1] == end[1]):
          return 0
        ans = 0
        lvl = 0
        q = deque()
        di = [-1,1,0,0]
        dj = [0,0,-1,1]
        q.append([ start[0] ,start[1] ])
        while len(q) > 0:
            l = len(q)
            for _ in range(l):
                top = q.popleft()
                for k in range(4):
                    i = top[0] + di[k]
                    j = top[1] + dj[k]
                    if i<0 or j<0 or i >= len(target_map) or j >= len(target_map[0]) or target_map[i][j] == False:
                        continue
                    elif target_map[i][j] == True and i == end[0] and j == end[1]:
                        ans = lvl
                        target_map[i][j] = False
                        break
                    else:
                        q.append([i,j])
                        target_map[i][j] = False
            lvl +=1
        return ans+1 if ans > 0 else None


