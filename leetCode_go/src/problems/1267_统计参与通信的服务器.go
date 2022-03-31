package problems

func countServers(grid [][]int) int {
	m,n:=len(grid),len(grid[0])
	lines,rows:=make([]int,m),make([]int,n)
	for i:=0;i<m;i++ {
		for j:=0;j<n;j++ {
			if grid[i][j]==1 {
				lines[i]++
				rows[j]++
			}
		}
	}
	result:=0
	for i:=0;i<m;i++ {
		for j:=0;j<n;j++ {
			if grid[i][j]==1 && (lines[i]>1 || rows[j]>1) {
				result++
			}
		}
	}
	return result
}