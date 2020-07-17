package by.catalog.storage;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertStorage {


    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "aili61329";
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into advert (id, mark, model, color, yearcar, price, id_user, dateadvert, specificationadvert) values (default , ?, ? , ? , ? , ?, ?, ?, ?)");
            preparedStatement.setString(1, advert.getMarkCar());
            preparedStatement.setString(2, advert.getModelCar());
            preparedStatement.setString(3, advert.getColorCar());
            preparedStatement.setInt(4, advert.getYearCar());
            preparedStatement.setDouble(5, advert.getPriceCar());
            preparedStatement.setLong(6, advert.getIdUser());
            preparedStatement.setString(7, advert.getDateAdvert());
            preparedStatement.setString(8, advert.getSpecificationAdvert());
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
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.id = ?");
            preparedStatement.setLong(1, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            String mark = resultSet.getString(2);
            String model = resultSet.getString(3);
            String color = resultSet.getString(4);
            int yearCar = resultSet.getInt(5);
            double price = resultSet.getDouble(6);
            long idUser = resultSet.getLong(7);
            String date = resultSet.getString(8);
            String specification = resultSet.getString(9);
            List<Message> messages = messageStorage.returnMessageByIdAdvert(idAdvert);
            return new Advert(id, mark, model, color, yearCar, price, idUser, date, specification, messages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Advert> getAllAdvertByIdUser(long idUser) {
        MessageStorage messageStorage = new MessageStorage();
        List<Advert> adverts = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.id_user = ?");
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String mark = resultSet.getString(2);
                String model = resultSet.getString(3);
                String color = resultSet.getString(4);
                int yearCar = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                String date = resultSet.getString(8);
                String specification = resultSet.getString(9);
                List<Message> messages = messageStorage.returnMessageByIdAdvert(id);
                adverts.add( new Advert(id, mark, model, color, yearCar, price, idUser, date, specification, messages));
            }
            return adverts;
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

    public List<Advert> getAllAdverts() {
        List<Advert> list = new ArrayList<>();
        try {
            long id = 0;
            String mark = "";
            String model = "";
            String color = "";
            int year = 0;
            double price = 0;
            long idUser = 0;
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong(1);
                mark = resultSet.getString(2);
                model = resultSet.getString(3);
                color = resultSet.getString(4);
                year = resultSet.getInt(5);
                price = resultSet.getDouble(6);
                idUser = resultSet.getLong(7);
                Advert advert = new Advert(id, mark, model, color, year, price, idUser);
                list.add(advert);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getModelByMark(String mark) {
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car s where s.mark = ?");
            preparedStatement.setString(1, mark);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(2);
                list.add(model);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getMarkByModel(String model) {
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car s where s.model = ?");
            preparedStatement.setString(1, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(3);
                list.add(mark);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllMark() {
        ArrayList<String> listMark = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(1);
                listMark.add(mark);
            }
            return listMark;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllModel() {
        ArrayList<String> listModel = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(2);
                listModel.add(model);
            }
            return listModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getAllAdvertMark() {
        ArrayList<String> listAdvertMark = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(2);
                listAdvertMark.add(mark);
            }
            return listAdvertMark;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public void removeIdAdvertIdUser(long idAdvert, long idUser) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from useradvertlist where iduser = ? and idadvert = ?");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIdUserIdAdvert(long idUser, long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from useradvertlist s where s.iduser = ? and s.idadvert = ?");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}