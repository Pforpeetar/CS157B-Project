select name, year, sum(attendance_count) as Attendance
from attendance, band, date_table
where attendance.band = band.id
AND attendance.date = date_table.id
GROUP BY band.name, date_table.year;