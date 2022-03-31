package problems

func imageSmoother(img [][]int) [][]int {
	width, height := len(img[0]), len(img)
	result := make([][]int, height)
	for i := 0; i < height; i++ {
		result[i] = make([]int, width)
	}
	//普通方法计算，没使用前缀和
	for i := 0; i < height; i++ {
		for j := 0; j < width; j++ {
			//坐标循环
			sum := 0
			count:=0
			for k := -1; k < 2; k++ {
				for l := -1; l < 2; l++ {
					x, y := i+k, j+l
					if x >= 0 && x < height && y >= 0 && y < width {
						sum+=img[x][y]
						count++
					}
				}
			}
			result[i][j]=sum/count
		}
	}
	return result
}
