package ro.patut.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.patut.data.UserData;
import ro.patut.facade.UserFacade;

import java.util.List;

/**
 * Created by neop on 08.04.2017.
 */

@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = {"http://localhost:4200","*"})
public class UsersController {

    private static final Logger logger= LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserData>> getAllUsers(){
        logger.debug("UsersController.getAllUsers called");
        List<UserData> userDataList =userFacade.getAllUsersAsList();
        if(userDataList.isEmpty()){
            logger.debug("UsersController.getAllUsers not a single user found");
            return new ResponseEntity<List<UserData>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserData>>(userDataList,HttpStatus.OK);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody UserData userData, UriComponentsBuilder ucBuilder){
        logger.debug("UsersController.saveUser called for user with email "+ userData.getEmail());

        userFacade.saveUser(userData);

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(userData.getNickname()).toUri());
        return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{nicknme}",method = RequestMethod.GET)
    public ResponseEntity<UserData> getUser(@PathVariable("nicknme") String nick){
        logger.debug("UsersController.getUser with email: "+nick +" called");
        UserData userData=userFacade.getUserByNickName(nick);
        if(userData==null){
            logger.warn("user with email: "+ nick + " does not exists");
            return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserData>(userData,HttpStatus.OK);
    }

    @RequestMapping(value = "/{nickname}",method = RequestMethod.PUT)
    public ResponseEntity<UserData> updateUserData(@PathVariable("nickname") String nickname,@RequestBody UserData userData ){
        logger.debug("UsersController.updateUserData has been called");

        UserData currentUser = userFacade.getUserByNickName(nickname);
        if(currentUser==null){
            logger.warn("UserModel with nickname: "+ nickname +" not found while trying ");
            return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
        }
        userFacade.updateUser(userData);
        return new ResponseEntity<UserData>(currentUser,HttpStatus.OK);
    }

    @RequestMapping(value="/{nickname}",method = RequestMethod.DELETE)
    public ResponseEntity<UserData> removeTicket(@PathVariable("nickname") String nickname){
        logger.debug("UsersController.removeTicket has been called");

        UserData userData=userFacade.getUserByNickName(nickname);
        if(userData == null){
            logger.warn("UserModel with nickname: "+ nickname +" not found while trying ");
            return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
        }
        userFacade.deleteUser(nickname);
        return new ResponseEntity<UserData>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<UserData> removeAllUsers(){
        logger.warn("UsersController.removeAllUsers take care, removing all users");
        userFacade.deleteAllUsers();
        return new ResponseEntity<UserData>(HttpStatus.NO_CONTENT);
    }


}
