class Solution:
    def duplicates(self, arr, n): 
        # code here
        seen=set()
        duplicates=set()
        for i in range(n):
            if arr[i] in seen:
                duplicates.add(arr[i])
            else:
                seen.add(arr[i])
        
        if duplicates:
            return sorted(list(duplicates))
            
            
        return [-1]

#{ 
 # Driver Code Starts
if(__name__=='__main__'):
    t = int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        res = Solution().duplicates(arr, n)
        for i in res:
            print(i,end=" ")
        print()



# } Driver Code Ends