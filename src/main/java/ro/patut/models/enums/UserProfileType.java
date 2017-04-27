package ro.patut.models.enums;

/**
 * Created by neop on 1/14/17.
 */
public enum UserProfileType {

    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType=userProfileType;
    }
    public String getUserProfileType(){
        return userProfileType;
    }

}
