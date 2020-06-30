package billdemo.springjpa.model.repo;

import billdemo.springjpa.model.entity.Island;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(path="island")
public interface IslandRepository extends CrudRepository<Island, String> {
    //http://localhost:8080/island/search/findByName?name=island1
    @Query(
            value = " SELECT count(*) FROM customer_transaction_setting " +
                    " WHERE customer_id = :customerId",
            nativeQuery = true)
    List<Island> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "delete Island where name = ?",
            nativeQuery = true)
    int deleteByName(String name);
}
