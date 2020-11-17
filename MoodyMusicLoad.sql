USE MoodyMusicApp;

LOAD DATA LOCAL INFILE '/Users/jchen/Desktop/cs5200/PM2/data/data_by_genre.csv' INTO TABLE Genres
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES;

  
LOAD DATA LOCAL INFILE '/Users/jchen/Desktop/cs5200/PM2/final_data/artists.csv' INTO TABLE Artists
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES;
  
LOAD DATA LOCAL INFILE '/Users/jchen/Desktop/cs5200/PM2/final_data/songs.csv' INTO TABLE Songs
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES;

LOAD DATA LOCAL INFILE '/Users/jchen/Desktop/cs5200/PM2/final_data/song_ownership.csv' INTO TABLE SongOwnership
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES;