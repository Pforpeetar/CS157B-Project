select name, year, state, sum(attendance_count) as Attendance
from attendance, band, date_table, location 
where attendance.band = band.id
AND attendance.date = date_table.id
AND attendance.location = location.id
GROUP BY band.name, date_table.year, location.state;