package billdemo.springjpa.model.repo;

import billdemo.springjpa.model.entity.UserGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="userGroup")
public interface UserGroupRepository extends CrudRepository<UserGroup, String> {
}
