package test

import (
	"src/problems"
	"testing"
)

func TestFrontMiddleBackQueue(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()
	fmbq.PushFront(1)
	fmbq.PushBack(2)
	fmbq.PushMiddle(3)
	fmbq.PushMiddle(4)
	println(fmbq.PopFront())
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopBack())
	println(fmbq.PopFront())
}

func TestFrontMiddleBackQueue2(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()
	fmbq.PushMiddle(1)
	fmbq.PushMiddle(2)
	fmbq.PushMiddle(3)
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
}

func TestFrontMiddleBackQueue3(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()
	fmbq.PushFront(1)
	fmbq.PushFront(2)
	fmbq.PushFront(3)
	fmbq.PushFront(4)
	println(fmbq.PopBack())
	println(fmbq.PopBack())
	println(fmbq.PopBack())
	println(fmbq.PopBack())
}

func TestFrontMiddleBackQueue4(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()
	fmbq.PushFront(8)
	println(fmbq.PopMiddle())
	println(fmbq.PopFront())
	println(fmbq.PopBack())
	println(fmbq.PopMiddle())
	fmbq.PushFront(1)
	fmbq.PushFront(10)
}

func TestFrontMiddleBackQueue5(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()
	fmbq.PushBack(10)
	println(fmbq.PopMiddle())
}

func TestFrontMiddleBackQueue6(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()
	println(fmbq.PopMiddle())
	fmbq.PushMiddle(5422)
	fmbq.PushMiddle(532228)
	println(fmbq.PopBack())
	fmbq.PushMiddle(206486)
	fmbq.PushBack(351927)
	println(fmbq.PopFront())
	println(fmbq.PopFront())
	fmbq.PushMiddle(73577)
	fmbq.PushMiddle(785914)
	fmbq.PushMiddle(765630)
	println(fmbq.PopMiddle())
	fmbq.PushMiddle(208060)
	println(fmbq.PopMiddle())
	fmbq.PushMiddle(592866)
}

func TestFrontMiddleBackQueue7(t *testing.T) {
	fmbq := problems.FrontMiddleBackQueueConstructor()

	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	fmbq.PushMiddle(773222)
	fmbq.PushMiddle(279355)
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopBack())
	println(fmbq.PopMiddle())
	println(fmbq.PopFront())
	fmbq.PushBack(448905)
	println(fmbq.PopFront())
	fmbq.PushMiddle(168284)
	fmbq.PushMiddle(874541)
	println(fmbq.PopMiddle())
	println(fmbq.PopBack())
	fmbq.PushFront(15656)
	println(fmbq.PopMiddle())
	fmbq.PushMiddle(803226)
	fmbq.PushMiddle(720129)
	fmbq.PushMiddle(626048)
	println(fmbq.PopMiddle())
	fmbq.PushMiddle(860306)
	println(fmbq.PopBack())
	fmbq.PushMiddle(630886)
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopMiddle())
	println(fmbq.PopFront())
	fmbq.PushMiddle(837735)
	fmbq.PushMiddle(414354)
	fmbq.PushMiddle(404940)
	fmbq.PushFront(88719)
}
