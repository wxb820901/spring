package billdemo.springjpa.model.repo;

import billdemo.springjpa.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="user")
public interface UserRepository extends CrudRepository<User, String> {
}
