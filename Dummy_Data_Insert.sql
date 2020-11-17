# Location
USE MoodyMusicApp;
INSERT INTO Location(City, State)
VALUES('Seattle', 'Washington');
INSERT INTO Location(City, State)
VALUES('Philadelphia', 'Pennsylvania');
INSERT INTO Location(City, State)
VALUES('Atlanta', 'Georgia');

# Users
INSERT INTO Users(UserName, Phone, Email, LocationID)
VALUES('John', 4254444444, 'john@noemail.com', 1);
INSERT INTO Users(UserName, Phone, Email, LocationID)
VALUES('Jane', 4255555555, 'jane@noemail.com', 2);
INSERT INTO Users(UserName, Phone, Email, LocationID)
VALUES('Jack', 4256666666, 'jack@noemail.com', 3);

# Favorite Genres
INSERT INTO FavoriteGenres (UserName, GenreName)
VALUES ('John', 'Classic finnish rock');
INSERT INTO FavoriteGenres (UserName, GenreName)
VALUES ('Jane', 'danseband');
INSERT INTO FavoriteGenres (UserName, GenreName)
VALUES ('Jack', 'Chinese indie rock');
INSERT INTO FavoriteGenres (UserName, GenreName)
VALUES ('John', 'Australian talent show');
INSERT INTO FavoriteGenres (UserName, GenreName)
VALUES ('Jack', 'skramz');

# Favorite Artists
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (23183, 'John');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (371, 'Jane');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (7260, 'Jane');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (11114, 'Jack');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (7193, 'Jane');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (17477, 'Jack');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (12679, 'John');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (16280, 'John');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (13555, 'Jack');
INSERT INTO FavoriteArtists(ArtistKey, UserName)
VALUES (17463, 'Jane');

# Recommendations
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('John', '000G1xMMuwxNHmwVsBdtj1', 70);
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('John', '000jBcNljWTnyjB4YO7ojf', 70);
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('John', '000mGrJNc2GAgQdMESdgEc', 70);
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('John', '000u1dTg7y1XCDXi80hbBX', 70);
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('Jane', '000x2qE0ZI3hodeVrnJK8A', 70);
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('John', '000ZxLGm7jDlWCHtcXSeBe', 70); 
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('Jane', '001UkMQHw4zXfFNdKpwXAF', 90);
INSERT INTO Recommendations(UserName, SongID, Temperature)
VALUES ('Jack', '004skCQeDn1iLntSom0rRr', 70);

# External Factors
-- INSERT INTO externalfactors(ExternalFactorsID, APIEndpoint, ExternalFactorName)
-- VALUES (1, 'api.openweathermap.org/data/2.5/weather?q={city name},{state code}&appid={API key}', 'Weather');
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Monday', 60);
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Tuesday', 90);
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Wednesday', 40);
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Thursday', 30);
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Friday', 20);
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Saturday', 50);
INSERT INTO externalfactors(Day, Temperature)
VALUES ('Sunday', 70);
# Favorite Songs
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('John', '018Lv2nSK23HDJeqmvw1A8');
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('John', '01ADfl2dm3ev0a7qcZN1Ix');
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('Jane', '01dmH2IPkrLNWIMPNXlreE');
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('Jane', '6nx6oC4HgnZOxC4dgsPiIU');
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('Jane', '0ZBaYkxZLlIl7CVfywmWw2');
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('Jack', '3SOUAgD70B82lpBVjgVGn9');
INSERT INTO FavoriteSongs(UserName, SongID)
VALUES ('Jack', '6rbGpy1s1TniuQXsIBaQym');

