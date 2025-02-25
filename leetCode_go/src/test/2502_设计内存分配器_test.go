package test

import (
	"src/problems"
	"testing"
)

func TestAllocator(t *testing.T) {
	c := problems.AllocateConstructor(10)
	println(c.Allocate(1, 1))
	println(c.Allocate(1, 2))
	println(c.Allocate(1, 3))
	println(c.FreeMemory(2))
	println(c.Allocate(3, 4))
	println(c.Allocate(1, 1))
	println(c.Allocate(1, 1))
	println(c.FreeMemory(1))
	println(c.Allocate(10, 2))
	println(c.FreeMemory(7))
}

func TestAllocator2(t *testing.T) {
	c := problems.AllocateConstructor(7)
	println(c.Allocate(3, 1))
	println(c.Allocate(5, 2))
	println(c.FreeMemory(1))
	println(c.FreeMemory(3))
}

func TestAllocator3(t *testing.T) {
	c := problems.AllocateConstructor(5)
	println(c.FreeMemory(4))

	println(c.Allocate(9, 5))
	println(c.Allocate(5, 8))
	println(c.Allocate(4, 8))
	println(c.Allocate(3, 2))
	println(c.FreeMemory(6))
	println(c.Allocate(9, 9))
	println(c.FreeMemory(6))
}

func TestAllocator4(t *testing.T) {
	c := problems.AllocateConstructor(7)
	println(c.Allocate(7, 8))
	println(c.Allocate(8, 7))
	println(c.Allocate(6, 2))
	println(c.FreeMemory(9))
	println(c.FreeMemory(8))
	println(c.Allocate(7, 6))
	println(c.FreeMemory(9))
	println(c.Allocate(10, 9))
}
