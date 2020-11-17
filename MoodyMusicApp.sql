CREATE SCHEMA IF NOT EXISTS MoodyMusicApp;
USE MoodyMusicApp;

DROP TABLE IF EXISTS FavoriteSongs;
DROP TABLE IF EXISTS ExternalFactors;
DROP TABLE IF EXISTS Recommendations;
DROP TABLE IF EXISTS SongOwnership;
DROP TABLE IF EXISTS Songs;
DROP TABLE IF EXISTS FavoriteArtists;
DROP TABLE IF EXISTS Artists;
DROP TABLE IF EXISTS FavoriteGenres;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Location;
DROP TABLE IF EXISTS Genres;

CREATE TABLE Genres
(
    GenreName        VARCHAR(255),
    Acousticness     DECIMAL(65,30),
    Danceability     DECIMAL(65,30),
    Duration         DECIMAL(65,30),
    Energy           DECIMAL(65,30),
    Instrumentalness DECIMAL(65,30),
    Liveness         DECIMAL(65,30),
    Loudness         DECIMAL(65,30),
    Speechiness      DECIMAL(65,30),
    Tempo            DECIMAL(65,30),
    Valence          DECIMAL(65,30),
    Popularity       DECIMAL(65,30),
    GenreKey         INT,
    Mode             BOOLEAN,
    CONSTRAINT pk_Genres_GenreName
        PRIMARY KEY (GenreName)
);

CREATE TABLE Location
(
    LocationID INT AUTO_INCREMENT,
    City       VARCHAR(255),
    State      VARCHAR(255),
    CONSTRAINT pk_Location_LocationID
        PRIMARY KEY (LocationID)
);

CREATE TABLE Users
(
    UserName   VARCHAR(255),
    Phone      VARCHAR(255),
    Email      VARCHAR(255),
    LocationID INT,
    CONSTRAINT pk_Users_UserName
        PRIMARY KEY (UserName),
    CONSTRAINT fk_Users_Locations
        FOREIGN KEY (LocationID)
            REFERENCES Location (LocationID)
            ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE FavoriteGenres
(
    FavoriteGenreID INT AUTO_INCREMENT,
    UserName        VARCHAR(255),
    GenreName       VARCHAR(255),
    CONSTRAINT pk_FavoriteGenres_FavoriteGenreID
        PRIMARY KEY (FavoriteGenreID),
    CONSTRAINT fk_FavoriteGenres_Genres
        FOREIGN KEY (GenreName)
            REFERENCES Genres (GenreName)
            ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_FavoriteGenres_UserName
        FOREIGN KEY (UserName)
            REFERENCES Users (UserName)
            ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Artists
(
	ArtistKey        INT AUTO_INCREMENT,
    ArtistName       VARCHAR(255),
    Acousticness     DECIMAL(65,30),
    Danceability     DECIMAL(65,30),
    Duration         DECIMAL(65,30),
    Energy           DECIMAL(65,30),
    Instrumentalness DECIMAL(65,30),
    Liveness         DECIMAL(65,30),
    Loudness         DECIMAL(65,30),
    Speechiness      DECIMAL(65,30),
    Tempo            DECIMAL(65,30),
    Valence          DECIMAL(65,30),
    Popularity       DECIMAL(65,30),
    Mode             BOOLEAN,
    Count            INT,
    CONSTRAINT pk_Artists_ArtistKey
        PRIMARY KEY (ArtistKey)
);

CREATE TABLE FavoriteArtists
(
    FavoriteArtistID INT AUTO_INCREMENT,
    ArtistKey       INT,
    UserName         VARCHAR(255),
    CONSTRAINT pk_FavoriteArtists_FavoriteArtistsID
        PRIMARY KEY (FavoriteArtistID),
    CONSTRAINT fk_FavoriteArtists_Users
        FOREIGN KEY (UserName)
            REFERENCES Users (UserName)
            ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_FavoriteArtists_ArtistKey
        FOREIGN KEY (ArtistKey)
            REFERENCES Artists (ArtistKey)
            ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Songs
(
    Acousticness     DECIMAL(65, 30),
    Danceability     DECIMAL(65,30),
    Duration         DECIMAL(65,30),
    Energy           DECIMAL(65,30),
    Explicit         BOOLEAN,
    SongID           VARCHAR(255),
    Instrumentalness DECIMAL(65,30),
    SongKey          INT,
    Liveness         DECIMAL(65,30),
    Loudness         DECIMAL(65,30),
    Mode             BOOLEAN,
	Title            VARCHAR(255),
    Popularity       INT,
    Speechiness      DECIMAL(65,30),
    Tempo            DECIMAL(65,30),
    Valence          DECIMAL(65,30),
    Year			 INT,
    CONSTRAINT pk_Songs_SongID
        PRIMARY KEY (SongID)
);

CREATE TABLE SongOwnership
(
    SongOwnershipId INT AUTO_INCREMENT,
    SongID			VARCHAR(255),
    ArtistKey		INT,
    CONSTRAINT pk_SongOwnership_SongOwnershipId
        PRIMARY KEY (SongOwnershipId),
	CONSTRAINT fk_SongOwnership_SongID
        FOREIGN KEY (SongID)
            REFERENCES Songs (SongID)
            ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_SongOwnership_ArtistKey
        FOREIGN KEY (ArtistKey)
            REFERENCES Artists (ArtistKey)
            ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Recommendations
(
    RecommendationId INT AUTO_INCREMENT,
    UserName         VARCHAR(255),
    SongID           VARCHAR(255),
    Created          TIMESTAMP,
    Temperature      INT, # TYPE: integer/string (depends on the returned data type from API)
    CONSTRAINT pk_Recommendations_RecommendationId
        PRIMARY KEY (RecommendationId),
    CONSTRAINT fk_Recommendations_UserName
        FOREIGN KEY (UserName)
            REFERENCES Users (UserName)
            ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT uq_Recommendations_UserName_SongID UNIQUE(UserName, SongID),
    CONSTRAINT fk_Recommendations_SongID
        FOREIGN KEY (SongID)
            REFERENCES Songs (SongID)
            ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE ExternalFactors
(
    Day         VARCHAR(255),
    Temperature INT,
    CONSTRAINT pk_ExternalFactors_Day
        PRIMARY KEY (Day)
);

CREATE TABLE FavoriteSongs
(
    FavoriteSongID INT AUTO_INCREMENT,
    SongID         VARCHAR(255),
    UserName       VARCHAR(255),
    CONSTRAINT pk_FavoriteSongs_FavoriteSongID
        PRIMARY KEY (FavoriteSongID),
    CONSTRAINT fk_FavoriteSongs_SongID
        FOREIGN KEY (SongID)
            REFERENCES Songs (SongID)
            ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_FavoriteSongs_UserName
        FOREIGN KEY (UserName)
            REFERENCES Users (UserName)
            ON UPDATE CASCADE ON DELETE SET NULL
);