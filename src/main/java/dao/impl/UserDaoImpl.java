package dao.impl;

import configs.DBConnectMySQL;
import dao.IUserDao;
import models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "select * from user";
        List<UserModel> users = new ArrayList<>();
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) { // Move from row to row in the ResultSet
                users.add(new UserModel(rs.getInt("id"),            // Get the "id" column as an integer
                        rs.getString("username"),    // Get the "username" column as a string
                        rs.getString("password"),    // Get the "password" column as a string
                        rs.getString("email"),       // Get the "email" column as a string
                        rs.getString("fullname"),    // Get the "fullname" column as a string
                        rs.getString("images")       // Get the "images" column as a string
                ));  // Add the new UserModel object to the list
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public UserModel findById(int id) {
        UserModel user = null;
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("images"),
                        rs.getString("fullname")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO user(email, username, fullname, password, images, roleid, phone,\n" +
                "createdDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = super.getDatabaseConnection(); // Kết nối database

            ps = conn.prepareStatement(sql); // Ném câu SQL vào cho thực thi

            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getImages());
            ps.setInt(6,user.getRoleid());
            ps.setString(7,user.getPhone());
            ps.setDate(8, user.getCreateDate());
            ps.executeUpdate();

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return false;
    }

    @Override
    public UserModel findByUsername(String username) {
        UserModel user = null;
        String sql = "SELECT * FROM user WHERE username = ?";

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("images"),
                        rs.getString("fullname"),
                        rs.getString("phone"),
                        rs.getInt("roleid"),
                        rs.getDate("createDate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();

        System.out.println(userDao.findByUsername("ldmvuong"));
        //userDao.insert(new UserModel(4, "hoang", "ldmh", "hhoang@gmail.com", "Le Duc Minh Hoang", "abcdef"));

        //List<UserModel> list = userDao.findAll();

//        for (UserModel user : list) {
//            System.out.println(user);

    }
}
