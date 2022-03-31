package problems

func HighestRankedKItems(grid [][]int, pricing []int, start []int, k int) [][]int {
	return highestRankedKItems(grid,pricing,start,k)
}

func highestRankedKItems(grid [][]int, pricing []int, start []int, k int) [][]int {
	h,w:=len(grid),len(grid[0])
	extendNodes:=[][]int{start}
	used:=map[int]bool{}
	result:=make([][]int,0)
	used[(start[0]<<14)+start[1]]=true
	//判定初始节点是否可加入
	if pric:=grid[start[0]][start[1]];pricing[1]>=pric&&pric>=pricing[0]  {
		result = append(result, start)
		k-=1
	}
	dev:=[][]int{{0,1},{0,-1},{-1,0},{1,0}}
	for k>0 && len(extendNodes)>0{
		next:=make([][]int,0)
		tempArr:=make([][]int,0)
		for _,nodeArr:=range extendNodes{
			x,y:=nodeArr[0],nodeArr[1]
			//循环，周围点
			for _,d:=range dev{
						nx,ny:=x+d[0],y+d[1]
						if nx>=0 && ny>=0 &&nx<h&&ny<w {
							hash:=(nx<<14)+ny
							if _,ok:=used[hash];!ok {
								switch price:=grid[nx][ny];{
								case price==0:
								case price>=pricing[0] &&price<=pricing[1]:
									next = append(next, []int{nx,ny})
									tempArr = append(tempArr, []int{nx,ny})
								default:
									next = append(next, []int{nx,ny})
								}
								used[hash]=true
							}
						}

			}
		}
		if k>len(tempArr) {
			result = append(result, sortArr(tempArr,grid,len(tempArr))...)
		}else {
			result = append(result, sortArr(tempArr,grid,k)...)
		}
		k-=len(tempArr)
		extendNodes=next
	}
	return result
}
//排序
func sortArr(arr [][]int,grid [][]int,limit int)  [][]int{
	//冒泡
	for i:=0;i<len(arr);i++ {
		for j:=i+1;j<len(arr);j++ {
			//交换条件
			x1,y1,x2,y2:=arr[i][0],arr[i][1],arr[j][0],arr[j][1]
			if grid[x2][y2]<grid[x1][y1] ||(grid[x2][y2]==grid[x1][y1] && (x2<x1||(x2==x1 &&y2<y1) )) {
				arr[i],arr[j]=arr[j],arr[i]
			}
		}
	}
	return arr[0:limit]
}

func highestRankedKItems_hash(grid [][]int, pricing []int, start []int, k int) [][]int {
	h,w:=len(grid),len(grid[0])
	extendNodes:=[][]int{start}
	used:=map[int]bool{}
	result:=make([][]int,0)
	used[(start[0]<<14)+start[1]]=true
	//判定初始节点是否可加入
	if pric:=grid[start[0]][start[1]];pricing[1]>=pric&&pric>=pricing[0]  {
		result = append(result, start)
		k-=1
	}
	dev:=[][]int{{0,1},{0,-1},{-1,0},{1,0}}
	for k>0 && len(extendNodes)>0{
		next:=make([][]int,0)
		tempArr:=make([][]int,0)
		for _,nodeArr:=range extendNodes{
			x,y:=nodeArr[0],nodeArr[1]
			//循环，周围点
			for _,d:=range dev{
				nx,ny:=x+d[0],y+d[1]
				if nx>=0 && ny>=0 &&nx<h&&ny<w {
					hash:=(nx<<14)+ny
					if _,ok:=used[hash];!ok {
						switch price:=grid[nx][ny];{
						case price==0:
						case price>=pricing[0] &&price<=pricing[1]:
							next = append(next, []int{nx,ny})
							tempArr = append(tempArr, []int{nx,ny})
						default:
							next = append(next, []int{nx,ny})
						}
						used[hash]=true
					}
				}
			}
		}
		if k>len(tempArr) {
			result = append(result, sortArr(tempArr,grid,len(tempArr))...)
		}else {
			result = append(result, sortArr(tempArr,grid,k)...)
		}
		k-=len(tempArr)
		extendNodes=next
	}
	return result
}