package ro.patut.services;

import ro.patut.data.UserData;
import ro.patut.models.UserModel;

import java.util.List;

/**
 * Created by neop on 08.04.2017.
 */

public interface UserService {

    void saveUser(UserModel userModel);

    List<UserModel> getAllUsersAsList();

    UserModel getUserByNickName(String nickname);

    void updateUser(UserModel userModel);

    void deleteUser(String nickname);

    void deleteAllUsers();

    UserModel findByEmail(String email);

}
