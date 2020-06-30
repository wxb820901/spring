package billdemo.springapp.feign;

import billdemo.springjpa.model.entity.Island;
import billdemo.springjpa.model.entity.User;
import billdemo.springjpa.model.entity.UserGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient("spring-jpa")
public interface SpringRepoFeign {

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<User> listUser();

    @GetMapping(value = "/user/{id}" , produces = "application/json; charset=UTF-8")
    EntityModel<User>  findUser(@PathVariable("id") String id);

    @PostMapping(value = "/user" , produces = "application/json; charset=UTF-8")
    EntityModel<User>  createUser(User user);

    @PutMapping(value = "/user" , produces = "application/json; charset=UTF-8")
    EntityModel<User>  updateUser(User user);

    @DeleteMapping(value = "/user/{id}")
    void deleteUser(@PathVariable("id") String id);


    @GetMapping(value = "/userGroup", produces = "application/json; charset=UTF-8")
    CollectionModel<UserGroup> listUserGroup();

    @GetMapping(value = "/userGroup/{id}" , produces = "application/json; charset=UTF-8")
    EntityModel<UserGroup>  findUserGroup(@PathVariable("id") String id);

    @PostMapping(value = "/userGroup" , produces = "application/json; charset=UTF-8")
    EntityModel<UserGroup>  createUserGroup(UserGroup user);

    @PutMapping(value = "/userGroup" , produces = "application/json; charset=UTF-8")
    EntityModel<UserGroup>  updateUserGroup(UserGroup user);

    @DeleteMapping(value = "/userGroup/{id}")
    void deleteUserGroup(@PathVariable("id") String id);


    @GetMapping(value = "/island", produces = "application/json; charset=UTF-8")
    CollectionModel<Island>  listIsland();

    @GetMapping(value = "/island/{id}" , produces = "application/json; charset=UTF-8")
    EntityModel<Island>  findIsland(@PathVariable("id") String id);

    @PostMapping(value = "/island" , produces = "application/json; charset=UTF-8")
    EntityModel<Island>  createIsland(Island user);

    @PutMapping(value = "/island" , produces = "application/json; charset=UTF-8")
    EntityModel<Island>  updateIsland(Island user);

    @DeleteMapping(value = "/island/{id}")
    void deleteIsland(@PathVariable("id") String id);
}
