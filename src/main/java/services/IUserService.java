package services;

import models.UserModel;

public interface IUserService {
    UserModel findByUsername(String username);

    UserModel login(String username, String password);

    void register(UserModel user);

    boolean register(String email, String password, String username, String
            fullname, String phone);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistPhone(String phone);

    boolean checkUserByEmail(String username, String email);

    boolean updatePassword(String username, String password);

}
