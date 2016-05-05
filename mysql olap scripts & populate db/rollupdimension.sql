select name, year, venue, gender, sum(attendance_count) as Attendance
from attendance, band, date_table, location, attendee_info
where attendance.band = band.id
AND attendance.date = date_table.id
AND attendance.location = location.id
AND attendance.attendee = attendee_info.id
GROUP BY band.name, date_table.year, location.venue, attendee_info.gender;