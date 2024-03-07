package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMyQueue(t *testing.T) {
	mq := problems.Constructor()
	mq.Push(1)
	mq.Push(2)
	fmt.Println(mq.Peek())
	fmt.Println(mq.Pop())
	fmt.Println(mq.Empty())
}
