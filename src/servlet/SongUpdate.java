package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dal.*;

@WebServlet("/songupdate")
public class SongUpdate extends HttpServlet {

	protected SongsDao songsDao;

	@Override
	public void init() throws ServletException {
		songsDao = SongsDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve song and validate.
		String songId = req.getParameter("songid");
		if (songId == null || songId.trim().isEmpty()) {
			messages.put("success", "Please enter a valid SongId.");
		} else {
			try {
				Songs song = songsDao.getSongBySongId(songId);
				if (song == null) {
					messages.put("success", "SongId does not exist.");
				}
				req.setAttribute("song", song);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}

		req.getRequestDispatcher("/SongUpdate.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve song and validate.
		String songId = req.getParameter("songid");
		if (songId == null || songId.trim().isEmpty()) {
			messages.put("success", "Please enter a valid SongId.");
		} else {
			try {
				Songs song = songsDao.getSongBySongId(songId);
				if (song == null) {
					messages.put("success", "SongId does not exist. No update to perform.");
				} else {
					String StringAcousticness = req.getParameter("acousticness");
					String StringDanceability = req.getParameter("danceability");
					String StringDuration = req.getParameter("duration");
					String StringEnergy = req.getParameter("energy");
					String StringExplicit = req.getParameter("explicit");
					String StringInstrumentalness = req.getParameter("instrumentalness");
					String StringSongKey = req.getParameter("songKey");
					String StringLiveness = req.getParameter("liveness");
					String StringLoudness = req.getParameter("loudness");
					String StringMode = req.getParameter("mode");
					String StringTitle = req.getParameter("title");
					String StringPopularity = req.getParameter("popularity");
					String StringSpeechiness = req.getParameter("speechiness");
					String StringTempo = req.getParameter("tempo");
					String StringValence = req.getParameter("valence");
					String StringYear = req.getParameter("year");

					double newAcousticness = StringAcousticness != null && !StringAcousticness.trim().isEmpty() ? 
							Double.parseDouble(StringAcousticness) : song.getAcousticness();
					double newDanceability = StringDanceability != null && !StringDanceability.trim().isEmpty() ?
							Double.parseDouble(StringDanceability) : song.getDanceability();
					double newDuration = StringDuration != null && !StringDuration.trim().isEmpty() ? 
							Double.parseDouble(StringDuration) : song.getDuration();
					double newEnergy =  StringEnergy != null && !StringEnergy.trim().isEmpty() ?
							Double.parseDouble(StringEnergy) : song.getEnergy();
					boolean newExplicit = false;
					if (StringExplicit != null && !StringExplicit.trim().isEmpty()) {
						newExplicit = StringExplicit == "1" ? true : false;
					} else {
						newExplicit = song.isExplicit();
					}
					double newInstrumentalness = StringInstrumentalness != null && !StringInstrumentalness.trim().isEmpty() ?
							Double.parseDouble(StringInstrumentalness) : song.getInstrumentalness();
					int newSongKey = StringSongKey != null && !StringSongKey.trim().isEmpty() ?
							Integer.parseInt(StringSongKey) : song.getSongKey();
					double newLiveness = StringLiveness != null && !StringLiveness.trim().isEmpty() ? 
							Double.parseDouble(StringLiveness) : song.getLiveness();
					double newLoudness = StringLoudness != null && !StringLoudness.trim().isEmpty() ?
							Double.parseDouble(StringLoudness) : song.getLoudness();
					boolean newMode = false;
					if (StringMode != null && !StringMode.trim().isEmpty()) {
						newMode = StringMode == "1" ? true : false;
					} else {
						newMode = song.isMode();
					}
					String newTitle = StringTitle != null && !StringTitle.trim().isEmpty() ?
							StringTitle : song.getTitle();
					int newPopularity = StringPopularity != null && !StringPopularity.trim().isEmpty() ?
							Integer.parseInt(StringPopularity) : song.getPopularity();
					double newSpeechiness = StringSpeechiness != null && !StringSpeechiness.trim().isEmpty() ?
							Double.parseDouble(StringSpeechiness) : song.getSpeechiness();
					double newTempo = StringTempo != null && !StringTempo.trim().isEmpty() ?
							Double.parseDouble(StringTempo) : song.getTempo();
					double newValence = StringValence != null && !StringValence.trim().isEmpty() ?
							Double.parseDouble(StringValence) : song.getValence();
					int newYear = StringYear != null && !StringYear.trim().isEmpty() ?
							Integer.parseInt(StringYear) : song.getYear();
					
					Songs updatedSong = new Songs(newAcousticness, newDanceability, newDuration, newEnergy, newExplicit, songId, newInstrumentalness,
							newSongKey, newLiveness, newLoudness, newMode, newTitle, newPopularity, newSpeechiness, newTempo, newValence, newYear);
					song = songsDao.update(song, updatedSong);
					messages.put("success", "Successfully updated for " + songId);
				}
				req.setAttribute("song", song);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}

		req.getRequestDispatcher("/SongUpdate.jsp").forward(req, resp);
	}
}
