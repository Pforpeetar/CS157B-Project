DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `location` mediumint default NULL,
  `attendee` mediumint default NULL,
  `date` mediumint default NULL,
  `band` mediumint default NULL,
  `attendance_count` mediumint default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (100,10,6,7,381),(59,3,3,36,226),(20,37,17,39,1607),(85,70,17,14,852),(28,17,9,22,665),(86,98,3,2,478),(99,4,26,4,1254),(54,70,25,30,301),(40,23,25,3,1962),(80,14,24,6,1480);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (62,77,13,32,1511),(56,46,28,43,430),(78,100,23,33,1954),(85,23,18,8,355),(70,32,6,24,1826),(15,85,9,1,1759),(1,34,30,42,1005),(11,58,9,3,1170),(24,90,4,22,206),(88,31,4,29,1879);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (46,22,4,35,1847),(89,3,13,2,244),(59,58,12,6,1661),(36,88,5,1,1577),(43,96,26,11,778),(66,19,22,26,203),(73,20,25,23,513),(28,35,29,31,1222),(57,48,22,23,1069),(92,67,2,28,743);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (88,71,29,11,1977),(90,45,2,9,297),(72,46,9,28,277),(44,65,6,40,1708),(99,60,13,24,546),(28,7,5,9,1303),(24,66,25,11,1587),(97,67,8,3,661),(48,62,21,39,1209),(81,46,19,11,191);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (60,47,15,26,117),(7,78,6,34,263),(5,77,20,8,778),(91,91,24,25,1975),(12,37,2,40,1278),(70,25,20,13,1886),(66,56,11,7,949),(36,51,6,39,270),(85,8,6,3,1155),(79,40,12,15,779);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (60,19,15,7,1888),(92,43,3,27,1680),(59,60,20,8,1649),(9,28,17,9,696),(96,77,4,17,1149),(4,5,27,4,1173),(43,21,29,20,1241),(57,78,21,11,765),(56,9,29,24,1235),(18,51,25,18,1330);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (41,88,24,29,122),(67,84,10,8,1953),(94,89,3,21,446),(16,24,28,36,337),(91,83,29,42,1247),(30,93,6,4,1310),(34,91,30,33,1500),(19,47,20,23,675),(15,45,6,41,895),(22,33,21,29,1702);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (91,50,7,32,517),(16,66,19,5,1874),(93,54,27,16,1218),(12,88,12,34,784),(74,44,12,10,893),(100,66,11,20,1038),(72,69,26,27,324),(87,42,8,6,1254),(86,73,16,21,793),(75,45,13,30,1344);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (63,1,3,25,424),(15,66,15,34,1751),(49,35,14,7,1119),(6,93,17,42,1665),(21,41,1,36,217),(83,61,18,44,148),(97,16,11,18,1304),(83,58,26,2,341),(84,9,4,20,1132),(22,27,2,6,1590);
INSERT INTO `attendance` (`location`,`attendee`,`date`,`band`,`attendance_count`) VALUES (7,92,4,35,1448),(76,13,13,16,1663),(13,92,30,30,1601),(82,18,10,12,1412),(49,40,3,10,1982),(84,7,12,19,1017),(7,90,16,7,1416),(94,84,11,37,596),(62,64,18,19,956),(7,39,16,16,1617);

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `venue` varchar(255) default NULL,
  `city` varchar(255),
  `state` varchar(50) default NULL,
  `country` varchar(100) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES ("The Warfield ","Kenosha","Wisconsin","Mauritius"),(" Bill Graham ","Casper","Wyoming","Mauritius"),(" House of Blues ","Warren","MI","Hungary"),(" The Hideout ","Columbus","Ohio","San Marino"),("The Warfield ","Cheyenne","Wyoming","Åland Islands"),(" Howard Theatre ","Annapolis","MD","Kuwait"),(" The Independent ","Detroit","Michigan","Kazakhstan"),(" U Street Music Hall ","Baltimore","MD","Niger"),(" SAP Center ","Tampa","Florida","Côte D'Ivoire (Ivory Coast)"),(" U Street Music Hall ","Topeka","Kansas","Saint Lucia");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" The Fox Theatre ","South Bend","IN","Bangladesh"),(" U Street Music Hall ","Chattanooga","TN","Nigeria"),(" The Great American Music House ","Worcester","Massachusetts","Senegal"),(" The Fox Theatre ","Casper","WY","Christmas Island"),(" Mohawk ","Memphis","TN","Bhutan"),(" Lincoln Hall ","Overland Park","KS","Cayman Islands"),(" The End ","Jonesboro","Arkansas","Luxembourg"),(" U Street Music Hall ","Orlando","FL","Slovakia"),(" Mohawk ","Chesapeake","Virginia","Chile"),(" Grand City Star Jazz Club ","Nashville","Tennessee","Luxembourg");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" House of Blues ","Lakewood","CO","Syria"),(" The Great American Music House ","Auburn","ME","Portugal"),(" Roseland Ballroom ","Glendale","Arizona","South Africa"),(" Grand City Star Jazz Club ","Richmond","Virginia","Equatorial Guinea"),(" Bill Graham ","Erie","Pennsylvania","Sri Lanka"),(" The Fox Theatre ","Little Rock","Arkansas","Malaysia"),(" Mohawk ","Dover","Delaware","Central African Republic"),(" Slim's ","Aurora","IL","Trinidad and Tobago"),(" Gorge Amphitheatre ","Racine","WI","Kenya"),(" The Filmore ","Springfield","Missouri","Thailand");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" Oracle Arena ","Toledo","OH","Sint Maarten"),(" House of Blues ","Green Bay","WI","Trinidad and Tobago"),(" Bill Graham ","Iowa City","Iowa","Zimbabwe"),(" Gorge Amphitheatre ","Salt Lake City","Utah","Iceland"),(" U Street Music Hall ","Kaneohe","Hawaii","Togo"),(" The Hideout ","Bellevue","NE","Jordan"),(" The Fox Theatre ","Columbus","OH","Cape Verde"),(" Black Bird Ordinary ","Gillette","WY","Mozambique"),(" The New Opera House ","Lexington","KY","Guadeloupe"),(" Slim's ","New Haven","Connecticut","Turkey");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" Gorge Amphitheatre ","Casper","Wyoming","United States Minor Outlying Islands"),(" The Great American Music House ","Milwaukee","WI","Cook Islands"),(" Bill Graham ","Lexington","KY","Kenya"),(" The New Parish ","Bellevue","Washington","Romania"),(" The Great American Music House ","Fresno","CA","Yemen"),(" House of Blues ","Lexington","Kentucky","Cambodia"),(" Mohawk ","Akron","OH","Panama"),(" Gorge Amphitheatre ","Biloxi","MS","South Africa"),(" The New Parish ","Waterbury","CT","Seychelles"),(" Lincoln Hall ","Little Rock","AR","Germany");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" Bill Graham ","Huntsville","AL","Burkina Faso"),(" The Great American Music House ","Newport News","VA","Bolivia"),(" The Hideout ","Racine","WI","Grenada"),(" Shoreline Amphitheatre ","Covington","KY","Monaco"),(" Shoreline Amphitheatre ","Augusta","Maine","Iraq"),(" The Independent ","Tallahassee","Florida","Sierra Leone"),(" The New Parish ","Fort Smith","AR","Niger"),("The Warfield ","Southaven","MS","Albania"),(" SAP Center ","Des Moines","Iowa","United States"),(" Roseland Ballroom ","Madison","WI","Costa Rica");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" The New Parish ","Philadelphia","PA","Algeria"),(" Shoreline Amphitheatre ","Meridian","Idaho","Sudan"),(" The Great American Music House ","New Orleans","Louisiana","Maldives"),(" The Fox Theatre ","Montpelier","VT","Indonesia"),(" Gorge Amphitheatre ","Great Falls","MT","Turks and Caicos Islands"),(" The Independent ","Overland Park","KS","Tajikistan"),(" U Street Music Hall ","Huntsville","Alabama","Bouvet Island"),(" The Independent ","Montgomery","Alabama","Cocos (Keeling) Islands"),(" Lincoln Hall ","Cheyenne","WY","Bulgaria"),(" Lincoln Hall ","Springfield","Massachusetts","Yemen");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES ("The Warfield ","College","AK","Sierra Leone"),(" Bill Graham ","New Haven","Connecticut","Oman"),(" The New Parish ","College","AK","French Guiana"),(" Lincoln Hall ","Reno","Nevada","Poland"),(" Bill Graham ","Lakewood","Colorado","Burundi"),(" Howard Theatre ","Bridgeport","Connecticut","Jamaica"),(" The Fox Theatre ","Toledo","Ohio","Curaçao"),(" The End ","Saint Paul","Minnesota","Guam"),(" The Great American Music House ","Hilo","HI","Belize"),(" Black Bird Ordinary ","Fairbanks","Alaska","Congo, the Democratic Republic of the");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" The Filmore ","Anchorage","Alaska","Bangladesh"),(" The Great American Music House ","Dallas","Texas","Falkland Islands"),(" Oracle Arena ","Anchorage","AK","Denmark"),(" The New Opera House ","Milwaukee","Wisconsin","Heard Island and Mcdonald Islands"),(" Black Bird Ordinary ","Saint Paul","MN","Cocos (Keeling) Islands"),(" The Hideout ","Essex","VT","Guadeloupe"),(" Regency Ballroom ","Anchorage","AK","Cayman Islands"),(" The New Parish ","Phoenix","Arizona","Cape Verde"),(" SAP Center ","Norfolk","Virginia","France"),(" The New Opera House ","Carson City","Nevada","Tokelau");
INSERT INTO `location` (`venue`,`city`,`state`,`country`) VALUES (" U Street Music Hall ","Iowa City","IA","Mauritius"),(" Grand City Star Jazz Club ","Fresno","CA","Singapore"),(" The New Parish ","Anchorage","Alaska","Suriname"),(" House of Blues ","Virginia Beach","VA","Libya"),(" The Filmore ","Flint","MI","Slovenia"),(" Gorge Amphitheatre ","Orlando","Florida","New Zealand"),(" U Street Music Hall ","Baton Rouge","Louisiana","Syria"),(" Regency Ballroom ","Bozeman","MT","Brunei"),(" U Street Music Hall ","Hattiesburg","Mississippi","Brunei"),(" The Great American Music House ","Norfolk","Virginia","Wallis and Futuna");

DROP TABLE IF EXISTS `band`;

CREATE TABLE `band` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `band` (`name`) VALUES ("Drake"), ("Taylor Swift"), ("Tool"), ("Maroon"), ("Kendrick Lamar"), ("Lorde"), ("Alexisonfire"), ("Phish"), ("Umphrey's McGee"), ("Tame Impala"), ("Snarky Puppy"), ("Big Bang "), ("EXO"), ("f(x)"), ("Girl's Generation"), ("Opeth"), ("Metallica"), ("Disturbed"), ("Taking Back Sunday"), ("Muse"), ("Deer Hunter"), ("Walk The Moon"), ("Gacharic Spin"), ("DOLL$ BOXX"), ("Maximum the Hormone"), ("City and Colour"), ("Beck "), ("Kanye West"), ("Jay Z"), ("Beyonce"), ("Kamasi Washington"), ("Eric Harland"), ("Justin Beiber"), ("One Direction"), ("Coldplay "), ("Billy Talent"), ("Sigur Ros"), ("Ellie Goulding"), ("Pearl Jam"), ("Rihanna"), ("The Cure"), ("Bruce Springsteen"), ("Adele"), ("Guns N' Roses"), ("Iron Maiden");

DROP TABLE IF EXISTS `attendee_info`;

CREATE TABLE `attendee_info` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `gender` varchar(255) default NULL,
  `race` varchar(255) default NULL,
  `age` mediumint default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Male","White",57),("Male","Black",48),("Female","Native American",60),("Female","Native American",53),("Male","Black",68),("Female","White",33),("Male","Hispanic",53),("Female","Other",24),("Female","Hispanic",24),("Female","Asian/Pacific Islander",64);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Male","Other",58),("Male","Hispanic",68),("Male","Other",67),("Male","White",55),("Female","Native American",48),("Female","Asian/Pacific Islander",36),("Female","Native American",62),("Female","Black",38),("Male","Asian/Pacific Islander",29),("Male","Native American",46);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Female","Other",36),("Female","Native American",35),("Female","Asian/Pacific Islander",29),("Female","White",52),("Female","Native American",44),("Male","White",24),("Female","Asian/Pacific Islander",66),("Female","White",23),("Male","Other",27),("Female","Black",56);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Female","White",50),("Male","Black",63),("Male","Native American",30),("Male","Asian/Pacific Islander",32),("Female","Native American",47),("Female","Black",24),("Male","Native American",23),("Female","Native American",39),("Male","Other",54),("Female","White",69);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Male","Native American",57),("Female","White",26),("Male","Asian/Pacific Islander",38),("Male","White",64),("Male","White",49),("Male","Black",37),("Female","Hispanic",58),("Male","Hispanic",36),("Male","Other",22),("Female","Hispanic",68);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Male","Black",47),("Female","Asian/Pacific Islander",51),("Male","Other",27),("Female","Hispanic",22),("Female","Native American",40),("Male","Asian/Pacific Islander",21),("Male","Hispanic",29),("Male","Hispanic",23),("Male","Other",49),("Male","White",68);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Male","Other",38),("Male","Native American",26),("Female","Native American",52),("Male","Black",27),("Female","Hispanic",57),("Male","Asian/Pacific Islander",62),("Female","White",29),("Male","Other",43),("Female","Native American",60),("Male","Hispanic",48);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Male","Hispanic",63),("Male","Asian/Pacific Islander",27),("Male","Native American",30),("Female","White",47),("Male","Other",25),("Male","Asian/Pacific Islander",49),("Male","Other",26),("Male","Native American",48),("Male","White",68),("Male","Hispanic",41);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Female","Asian/Pacific Islander",50),("Male","Hispanic",29),("Female","White",44),("Female","White",44),("Male","Hispanic",22),("Male","Asian/Pacific Islander",66),("Male","Black",31),("Female","Hispanic",28),("Female","White",59),("Male","Other",24);
INSERT INTO `attendee_info` (`gender`,`race`,`age`) VALUES ("Female","White",37),("Male","Other",18),("Female","White",54),("Male","Other",31),("Female","Asian/Pacific Islander",45),("Female","Hispanic",63),("Male","Other",28),("Male","White",66),("Female","Native American",50),("Female","Other",46);

DROP TABLE IF EXISTS `date_table`;

CREATE TABLE `date_table` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `day` mediumint(9) DEFAULT NULL,
  `day_of_the_week` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `quarter` varchar(255) DEFAULT NULL,
  `year` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `date_table` VALUES (1,17,'Thursday','May','Q3',2016),(2,23,'Tuesday','Februrary','Q1',2014),(3,31,'Monday','July','Q2',2016),(4,15,'Tuesday','October','Q4',2014),(5,14,'Wednesday','November','Q1',2015),(6,14,'Thursday','April','Q2',2014),(7,23,'Saturday','November','Q3',2016),(8,25,'Thursday','September','Q4',2016),(9,31,'Monday','April','Q2',2014),(10,11,'Sunday','September','Q3',2016),(11,1,'Saturday','Februrary','Q4',2014),(12,13,'Tuesday','Februrary','Q2',2014),(13,6,'Thursday','October','Q2',2016),(14,20,'Friday','January','Q2',2014),(15,2,'Tuesday','September','Q1',2015),(16,11,'Saturday','November','Q3',2015),(17,21,'Wednesday','September','Q1',2016),(18,19,'Wednesday','August','Q3',2014),(19,28,'Saturday','April','Q4',2016),(20,4,'Friday','Februrary','Q1',2015),(21,17,'Tuesday','March','Q1',2016),(22,27,'Thursday','June','Q4',2014),(23,19,'Wednesday','November','Q4',2015),(24,21,'Monday','July','Q4',2014),(25,13,'Wednesday','September','Q2',2015),(26,10,'Friday','April','Q2',2014),(27,18,'Saturday','November','Q1',2016),(28,27,'Saturday','January','Q1',2014),(29,17,'Saturday','December','Q3',2015),(30,30,'Saturday','June','Q1',2015),(31,2,'Friday','Februrary','Q2',2016),(32,28,'Wednesday','July','Q4',2015),(33,22,'Sunday','October','Q4',2015),(34,1,'Monday','Februrary','Q4',2015),(35,30,'Tuesday','May','Q1',2016),(36,20,'Monday','March','Q1',2014),(37,3,'Thursday','December','Q4',2015),(38,6,'Monday','July','Q3',2016),(39,5,'Sunday','Februrary','Q1',2014),(40,20,'Wednesday','January','Q3',2015),(41,24,'Monday','April','Q3',2014),(42,1,'Wednesday','November','Q4',2015),(43,19,'Friday','August','Q2',2014),(44,5,'Monday','March','Q3',2015),(45,7,'Tuesday','October','Q3',2014),(46,26,'Monday','November','Q3',2015),(47,17,'Sunday','June','Q3',2015),(48,16,'Saturday','May','Q4',2014),(49,6,'Saturday','November','Q1',2014),(50,24,'Sunday','November','Q3',2015),(51,21,'Thursday','November','Q4',2016),(52,12,'Sunday','May','Q1',2015),(53,31,'Sunday','March','Q2',2014),(54,14,'Sunday','June','Q3',2015),(55,29,'Saturday','August','Q1',2015),(56,11,'Thursday','March','Q1',2015),(57,31,'Tuesday','July','Q3',2014),(58,9,'Saturday','April','Q3',2016),(59,19,'Tuesday','January','Q2',2014),(60,10,'Tuesday','July','Q4',2014),(61,5,'Saturday','June','Q2',2014),(62,13,'Saturday','September','Q1',2014),(63,25,'Tuesday','December','Q2',2014),(64,1,'Saturday','December','Q1',2015),(65,2,'Tuesday','August','Q1',2015),(66,11,'Wednesday','June','Q3',2015),(67,13,'Wednesday','Februrary','Q2',2014),(68,22,'Saturday','June','Q2',2015),(69,20,'Saturday','July','Q2',2016),(70,22,'Saturday','November','Q1',2016),(71,22,'Saturday','July','Q3',2014),(72,21,'Friday','June','Q4',2014),(73,10,'Monday','April','Q2',2016),(74,29,'Friday','August','Q3',2016),(75,10,'Sunday','July','Q4',2016),(76,5,'Saturday','April','Q2',2014),(77,26,'Thursday','March','Q3',2016),(78,6,'Tuesday','April','Q2',2014),(79,18,'Sunday','December','Q1',2014),(80,6,'Saturday','June','Q2',2016),(81,10,'Saturday','July','Q4',2016),(82,28,'Friday','October','Q4',2016),(83,9,'Saturday','December','Q1',2014),(84,18,'Wednesday','June','Q4',2014),(85,3,'Saturday','November','Q4',2014),(86,12,'Monday','September','Q1',2015),(87,25,'Wednesday','April','Q2',2016),(88,18,'Friday','September','Q2',2015),(89,14,'Saturday','March','Q1',2015),(90,20,'Sunday','October','Q3',2016),(91,25,'Sunday','January','Q1',2015),(92,24,'Monday','October','Q1',2014),(93,15,'Friday','November','Q3',2015),(94,30,'Saturday','May','Q1',2015),(95,19,'Wednesday','Februrary','Q1',2014),(96,20,'Thursday','September','Q3',2016),(97,29,'Tuesday','March','Q4',2015),(98,7,'Saturday','May','Q4',2015),(99,25,'Thursday','June','Q1',2015),(100,9,'Tuesday','September','Q3',2014);