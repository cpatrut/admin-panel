package ro.patut.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.patut.models.UserModel;

import java.util.UUID;

/**
 * Created by neop on 09.04.2017.
 */
public interface UserRepository extends CrudRepository<UserModel,UUID> {

    @Query("SELECT * FROM users where email=?0")
    UserModel findByEmail(String email);

    @Query("SELECT * FROM users where nickname=?0")
    UserModel findByNickname(String nickname);
}
