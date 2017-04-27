package ro.patut.models;


import com.datastax.driver.core.utils.UUIDs;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
import ro.patut.models.enums.State;
import ro.patut.models.enums.UserProfileType;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by neop on 1/14/17.
 */

@Table("users")
public class UserModel {

    @PrimaryKeyColumn(name = "nickname",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
    private String nickname;

    @PrimaryKeyColumn(name="email",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String email;

    @Column(value="password")
    private String password;

    @Column(value="first_name")
    private String firstName;

    @Column(value="last_name")
    private String lastName;

    @Column(value = "state")
    private String state= State.ACTIVE.getState();

    @Column(value = "creation_date")
    private LocalTime creationDate= LocalTime.now();

    @Column(value="type")
    private String type= UserProfileType.USER.getUserProfileType();

    @Column(value="isAccountNonExpired")
    private boolean isAccountNonExpired = true;

    @Column(value="isAccountNonLocked")
    private boolean isAccountNonLocked = true;

    @Column(value="isCredentialsNonExpired")
    private boolean isCredentialsNonExpired=true;

    @Column(value = "isEnabled")
    private boolean isEnabled = true;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }


    public String getType() {
        return type;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", creationDate=" + creationDate +
                ", type='" + type + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
