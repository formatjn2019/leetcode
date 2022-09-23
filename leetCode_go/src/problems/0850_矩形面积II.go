package problems

import "fmt"

func RectangleArea(rectangles [][]int) int {
	return rectangleArea(rectangles)
}

func rectangleArea(rectangles [][]int) int {

	for _, arr := range rectangles {
		fmt.Println(arr)
	}

	return 0
}
