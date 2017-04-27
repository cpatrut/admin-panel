package ro.patut.facade;

import ro.patut.data.UserData;
import ro.patut.models.UserModel;

import java.util.List;

/**
 * Created by neop on 09.04.2017.
 */
public interface UserFacade {
    void saveUser(UserData userData);

    List<UserData> getAllUsersAsList();

    UserData getUserByNickName(String nickname);

    void updateUser(UserData userModel);

    void deleteUser(String nickname);

    void deleteAllUsers();

    UserData findByEmail(String email);
}
