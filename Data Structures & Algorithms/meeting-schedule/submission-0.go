/**
 * Definition of Interval:
 * type Interval struct {
 *    start int
 *    end   int
 * }
 */

import "slices"

func canAttendMeetings(intervals []Interval) bool {
    slices.SortFunc(intervals, func(i, j Interval) int {
		return i.start - j.start
	})

    end := 0

    for _, interval := range intervals {
        if interval.start < end {
            return false
        }
        end = interval.end
    }

    return true
}
