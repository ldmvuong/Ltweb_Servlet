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

            while (rs.next()) {
                users.add(new UserModel(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("images"),
                        rs.getString("phone"),
                        rs.getInt("roleid"),
                        rs.getDate("createdate")));
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
                user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("images"), rs.getString("fullname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO user(email, username, fullname, password, roleid, phone, createdate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRoleid());
            ps.setString(6, user.getPhone());
            ps.setDate(7, user.getCreateDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String sql = "select * from user where email = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String sql = "select * from user where username = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        String sql = "select * from user where phone = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkUserByEmail(String username, String email) {
        boolean exist = false;
        String sql = "select * from user where username = ? and email = ?";
        try{
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            }
            ps.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return exist;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        String sql = "update user set password = ? where username = ?";
        boolean isUpdated = false;
        try{
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, username);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
            ps.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isUpdated;
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
                user = new UserModel(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("images"),
                        rs.getString("phone"),
                        rs.getInt("roleid"),
                        rs.getDate("createDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<UserModel> list = userDao.findAll();
        for (UserModel user : list) {
            System.out.println(user);
        }
    }
}

