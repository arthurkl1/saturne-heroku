package hei.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import hei.projet.dao.VideoDao;
import hei.projet.entities.Video;

public class VideoDaoImpl implements VideoDao {

	@Override
	public void addVideo(Video video) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO video(evenement,titreVideo,description,dateVideo) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, video.getEvenement().getIdEvenement());
				statement.setString(2, video.getTitreVideo());
				statement.setString(3, video.getDescription());
				statement.setDate(4, video.getDateVideo());
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						video.setId(resultSet.getInt(1));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
