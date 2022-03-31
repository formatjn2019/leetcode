package problems

import "fmt"



func MinAreaFreeRect(points [][]int) float64 {
	return minAreaFreeRect(points)
}

func minAreaFreeRect(points [][]int) float64 {
	slopeMap:= map[float64]map[int64]float64{}
	//斜线记录
	for i:=0;i<len(points);i++ {
		for j:=i+1;j<len(points);j++ {
			x1,y1,x2,y2:=points[i][0],points[i][1],points[j][0],points[j][1]
			k:=float64(y2-y1)/float64(x2-x1)
			b:=float64(y1)-k*float64(x1)
			p1,p2:=getPoint(x1,y1),getPoint(x2,y2)
			if _,ok:=slopeMap[k];!ok {
				slopeMap[k]= map[int64]float64{}
			}
			slopeMap[k][p1]=b
			slopeMap[k][p2]=b
		}
	}
	fmt.Println(slopeMap)



	return 0
}

func getPoint(x,y int) int64 {
	return (int64(x + 40000)<<16) + int64(y + 40000)
}