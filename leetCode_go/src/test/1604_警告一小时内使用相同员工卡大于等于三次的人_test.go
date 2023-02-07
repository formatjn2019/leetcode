package test

import (
	"src/problems"
	"testing"
)

func TestAlertNames(t *testing.T) {
	problems.AlertNames([]string{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, []string{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"})
	problems.AlertNames([]string{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, []string{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"})
	problems.AlertNames([]string{"john", "john", "john"}, []string{"23:58", "23:59", "00:01"})
	problems.AlertNames([]string{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, []string{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"})
	problems.AlertNames([]string{"a", "a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c", "c", "c", "c", "c", "c"}, []string{"00:37", "11:24", "14:35", "21:25", "15:48", "20:28", "07:30", "09:26", "10:32", "20:10", "19:26", "08:13", "01:08", "15:49", "02:34", "06:48", "04:33", "07:18", "00:05", "06:44", "13:33", "04:12", "03:54"})

}
