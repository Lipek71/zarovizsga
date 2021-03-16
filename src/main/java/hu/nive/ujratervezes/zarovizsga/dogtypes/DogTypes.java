package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    MariaDbDataSource dataSource = new MariaDbDataSource();

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT `name` FROM dog_types WHERE country = ? ORDER BY name ASC")
        ) {
            stmt.setString(1, country.toUpperCase());
            return getReadDogsByCountryFromDB(stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can't query", sqle);
        }
    }

    private List<String> getReadDogsByCountryFromDB(PreparedStatement stmt) {

        List<String> dogsName = new ArrayList<>();

        try (
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                String dogName = rs.getString("name").toLowerCase();

                dogsName.add(dogName);
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can't query", sqle);
        }
        return dogsName;
    }

}
