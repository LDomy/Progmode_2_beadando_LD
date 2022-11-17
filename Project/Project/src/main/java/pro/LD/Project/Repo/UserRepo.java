package pro.LD.Project.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.LD.Project.Modell.User;

public interface UserRepo extends JpaRepository<User,Long> {
}
