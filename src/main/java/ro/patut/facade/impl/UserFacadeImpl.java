package ro.patut.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.patut.data.UserData;
import ro.patut.facade.UserFacade;
import ro.patut.models.UserModel;
import ro.patut.services.UserService;
import ro.patut.services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neop on 09.04.2017.
 */

@Service
public class UserFacadeImpl implements UserFacade {

    private static final Logger logger= LoggerFactory.getLogger(UserFacadeImpl.class);


    @Autowired
    UserService userService;

    @Override
    public void saveUser(UserData userData) {
        userService.saveUser(populateUserModelWithData(userData));
    }

    @Override
    public List<UserData> getAllUsersAsList() {
        List<UserModel> userModelList=userService.getAllUsersAsList();
        List<UserData> userDataList=new ArrayList<>();

        for(UserModel userModel:userModelList){
            userDataList.add(populateUserDataWithModel(userModel));
        }

        return userDataList;
    }

    @Override
    public UserData getUserByNickName(String nickname) {
        return populateUserDataWithModel(userService.getUserByNickName(nickname));
    }

    @Override
    public void updateUser(UserData userData) {
        userService.saveUser(populateUserModelWithData(userData));
    }

    @Override
    public void deleteUser(String nickname) {
        userService.deleteUser(nickname);
    }

    @Override
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    @Override
    public UserData findByEmail(String email) {
        return populateUserDataWithModel(userService.findByEmail(email));
    }

    private UserModel populateUserModelWithData(UserData userData){
        UserModel userModel=new UserModel();

        userModel.setEmail(userData.getEmail());
        userModel.setNickname(userData.getNickname());
        userModel.setPassword(userData.getPassword());
        userModel.setFirstName(userData.getFirstName());
        userModel.setLastName(userData.getLastName());
        userModel.setAccountNonExpired(userData.isAccountNonExpired());
        userModel.setAccountNonLocked(userData.isAccountNonLocked());
        userModel.setEnabled(userData.isEnabled());

        return userModel;
    }

    private UserData populateUserDataWithModel(UserModel userModel){
        UserData userData=new UserData();

        userData.setEmail(userModel.getEmail());
        userData.setNickname(userModel.getNickname());
        userData.setPassword(userModel.getPassword());
        userData.setFirstName(userModel.getFirstName());
        userData.setLastName(userModel.getLastName());
        userData.setCreationDate(userModel.getCreationDate());
        userData.setAccountNonExpired(userModel.isAccountNonExpired());
        userData.setAccountNonLocked(userModel.isAccountNonLocked());
        userData.setEnabled(userModel.isEnabled());

        return userData;

    }
}
