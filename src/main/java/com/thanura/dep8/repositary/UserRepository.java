package com.thanura.dep8.repositary;
import com.thanura.dep8.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsUserByEmail(String email);

}
