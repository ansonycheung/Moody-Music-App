package tools;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dal.*;
import model.*;

public class Inserter {
	public static void main(String[] args) throws SQLException {
		// DAO
		ArtistsDao artistsDao = ArtistsDao.getInstance();
		SongsDao songsDao = SongsDao.getInstance();
		UsersDao usersDao = UsersDao.getInstance();
		LocationDao locationDao = LocationDao.getInstance();
		RecommendationDao recommendationDao = RecommendationDao.getInstance();
		ExternalFactorsDao externalFactorsDao = ExternalFactorsDao.getInstance();
		int artistKey = 1;
		String songId = "000G1xMMuwxNHmwVsBdtj1";
		String artistName = "Ed Sheeran";
		String songTitle = "smart";

		// CREATE
		ExternalFactors monday = new ExternalFactors("Monday", 60);
		ExternalFactors tuesday = new ExternalFactors("Tuesday", 50);
		ExternalFactors wednesday = new ExternalFactors("Wednesday", 70);
		ExternalFactors thursday = new ExternalFactors("Thursday", 40);
		ExternalFactors friday = new ExternalFactors("Friday", 30);
		ExternalFactors saturday = new ExternalFactors("Saturday", 10);
		ExternalFactors sunday = new ExternalFactors("Sunday", 20);

		monday = externalFactorsDao.create(monday);
		tuesday = externalFactorsDao.create(tuesday);
		wednesday = externalFactorsDao.create(wednesday);
		thursday = externalFactorsDao.create(thursday);
		friday = externalFactorsDao.create(friday);
		saturday = externalFactorsDao.create(saturday);
		sunday = externalFactorsDao.create(sunday);

		Location l1 = locationDao.getLocationById(1);
		System.out.format("Reading location: i:%s c:%s s:%s \n", l1.getLocationId(), l1.getCity(), l1.getState());
		Users user1 = new Users("user1", "4632819009", "user1@gmail.com", l1);
		user1 = usersDao.create(user1);

		// READ
		Users u1 = usersDao.getUserFromUsername("user1");
		System.out.format("Reading user: u:%s p:%s e:%s \n", u1.getUsername(), u1.getPhone(), u1.getEmail());

		List<Artists> artistsList1 = artistsDao.getArtistsByYear(2016);
		System.out.println("Top 10 Artists from specified year:");
		for (Artists artist : artistsList1) {
			System.out.format("\tName: %s\n", artist.getArtistName());
		}

		List<Artists> artistsBySongId = artistsDao.getArtistBySongId(songId);
		for (Artists artist : artistsBySongId) {
			System.out.format("\tName: %s\n", artist.getArtistName());
		}

		Artists artist = artistsDao.getArtistByArtistKey(artistKey);
		System.out.format("Name: %s\n", artist.getArtistName());

		Songs song1 = songsDao.getSongBySongId(songId);
		System.out.format("Reading song: songId: %s, title: %s \n", song1.getSongId(), song1.getTitle());

		Map<Integer, List<Songs>> songsByArtistName = songsDao.getSongsByArtistName(artistName);
		for (int key : songsByArtistName.keySet()) {
			System.out.format("Artist: name: %s, key: %s", artistName, key);
			for (Songs song : songsByArtistName.get(key)) {
				System.out.format("\tSong: songId: %s, title: %s \n", song1.getSongId(), song1.getTitle());
			}
		}

		List<Songs> top100Songs = songsDao.getTop100Songs();
		System.out.println("Reading top100Songs");
		for (Songs song : top100Songs) {
			System.out.format("Song: songId: %s, title: %s \n", song.getSongId(), song.getTitle());
		}

		List<Songs> top100SongsOfYear = songsDao.getTop100SongsOfYear(2019);
		System.out.println("Reading top100SongsOfYear");
		for (Songs song : top100SongsOfYear) {
			System.out.format("Song: songId: %s, title: %s \n", song.getSongId(), song.getTitle());
		}

		List<Songs> songsByTitle = songsDao.getSongsByTitle(songTitle);
		System.out.println("Reading songsByTitle");
		for (Songs song : songsByTitle) {
			System.out.format("Song: songId: %s, title: %s \n", song.getSongId(), song.getTitle());
		}

		Songs songsByWeather = songsDao.getSongsByWeather("Jack");
		System.out.println("Reading songsByWeater");
		System.out.format("Song: songId: %s, title: %s \n", songsByWeather.getSongId(), songsByWeather.getTitle());

		// UPDATE

		u1 = usersDao.updatePhone(u1, "1234567890");
		System.out.format("Reading user: u:%s p:%s e:%s \n", u1.getUsername(), u1.getPhone(), u1.getEmail());
		u1 = usersDao.updateEmail(u1, "xxs@gmail.com");
		System.out.format("Reading user: u:%s p:%s e:%s \n", u1.getUsername(), u1.getPhone(), u1.getEmail());

		// DELETE
		System.out.println("Deleting Users");
		usersDao.delete(u1);

		System.out.println("Deleting ExternalFactors");
		externalFactorsDao.delete(monday);
		externalFactorsDao.delete(tuesday);
		externalFactorsDao.delete(wednesday);
		externalFactorsDao.delete(thursday);
		externalFactorsDao.delete(friday);
		externalFactorsDao.delete(saturday);
		externalFactorsDao.delete(sunday);

	}

}