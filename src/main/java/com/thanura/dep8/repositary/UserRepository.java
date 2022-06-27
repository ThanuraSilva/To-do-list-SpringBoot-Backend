package com.thanura.dep8.repositary;


import com.thanura.dep8.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository {
    boolean existsUserByEmail(String email);

    @Query(value = "SELECT * FROM User WHERE id",nativeQuery = true)
    List<User> findUsersById(String query);
}
