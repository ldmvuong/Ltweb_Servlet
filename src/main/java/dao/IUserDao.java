package dao;

import models.UserModel;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    List<UserModel> findAll() throws SQLException, ClassNotFoundException;

    UserModel findById(int id);

    void insert(UserModel user);

    UserModel findByUsername(String username);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistPhone(String phone);

    boolean checkUserByEmail(String username, String email);

    boolean updatePassword(String username, String password);


}
