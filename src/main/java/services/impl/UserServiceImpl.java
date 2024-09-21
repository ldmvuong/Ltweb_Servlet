package services.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import models.UserModel;
import services.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public void register(UserModel user) {
        userDao.insert(user);
    }


    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        userDao.insert(new UserModel(username, password, email, fullname, phone, 3, date));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public boolean checkUserByEmail(String username, String email) {
        return userDao.checkUserByEmail(username, email);
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return userDao.updatePassword(username, password);
    }


    public static void main(String[] args) {
        try {
            IUserService userService = new UserServiceImpl();
            System.out.println(userService.login("ldmvuong", "admin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
