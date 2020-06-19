package by.catalog.storage;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertStorage {

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "";
    private final static String PASS_TABLES = "";
    Connection connection = null;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addAdvert(Advert advert) {

        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into advert (id, model, color, yearcar, price, id_user) values (default , ? , ? , ? , ?, ?)");
            preparedStatement.setString(1, advert.getModelCar());
            preparedStatement.setString(2, advert.getColorCar());
            preparedStatement.setInt(3, advert.getYearCar());
            preparedStatement.setDouble(4, advert.getPriceCar());
            preparedStatement.setLong(5, advert.getIdUser());
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Advert returnAdvertById(long idAdvert) {
        MessageStorage messageStorage = new MessageStorage();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.idadvert = ?");
            preparedStatement.setLong(1, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            String model = resultSet.getString(2);
            String color = resultSet.getString(3);
            int yearCar = resultSet.getInt(4);
            double price = resultSet.getDouble(5);
            long idUser = resultSet.getLong(6);
            List<Message> messages = messageStorage.returnMessageByIdAdvert(idAdvert);
            return new Advert(id, model, color, yearCar, price, idUser, messages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addIdUserIdAdvert(long idUser, long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into useradvertlist (iduser, idadvert) values (?, ?)");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAllIdAdvertByIdUser(long idUser) {
        ArrayList<Long> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from useradvertlist s where s.iduser = ?");
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idAdvert = resultSet.getLong(2);
                list.add(idAdvert);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}