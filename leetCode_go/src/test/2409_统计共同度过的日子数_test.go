package test

import (
	"src/problems"
	"testing"
)

func TestCountDaysTogether(t *testing.T) {
	//problems.CountDaysTogether("08-15", "08-18", "08-16", "08-19")
	problems.CountDaysTogether("10-01", "10-31", "11-01", "12-31")
}
