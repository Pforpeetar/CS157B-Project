select name, year, venue, sum(attendance_count) as Attendance
from attendance, band, date_table, location 
where attendance.band = band.id
AND attendance.date = date_table.id
AND attendance.location = location.id
AND band.name = "Taylor Swift"
AND date_table.year = "2016"
AND location.venue = "SAPCenter"
GROUP BY band.name, date_table.year, location.venue;