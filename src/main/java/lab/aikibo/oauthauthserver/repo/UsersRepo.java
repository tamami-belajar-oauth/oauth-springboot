package lab.aikibo.oauthauthserver.repo;

import lab.aikibo.oauthauthserver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tamami on 05/09/17.
 */
public interface UsersRepo extends JpaRepository<Users, Long> {

    public Users findByUsername(String username);
    public List<Users> findAll();

}
