package billdemo.springapp.controller;

import billdemo.springapp.feign.SpringRepoFeign;
import billdemo.springapp.pojo.UserGroupPojo;
import billdemo.springapp.pojo.UserPojo;
import billdemo.springjpa.model.entity.User;
import billdemo.springjpa.model.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/api/v1")
public class SpringAppController {
    @Autowired
    private SpringRepoFeign springRepoFeign;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserPojo>> listUser() {
        List<UserPojo> users = springRepoFeign.listUser().getContent().stream().map(UserPojo::getUserPojo).collect(Collectors.toList());
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPojo> findUser(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(UserPojo.getUserPojo(springRepoFeign.findUser(id).getContent()));

    }

    @PostMapping(path = "/user", produces = "application/json")
    public ResponseEntity<UserPojo> createUser(@RequestBody User user) {
        return ResponseEntity.ok(UserPojo.getUserPojo(springRepoFeign.createUser(user).getContent()));

    }

    @PutMapping(path = "/user", produces = "application/json")
    public ResponseEntity<UserPojo> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(UserPojo.getUserPojo(springRepoFeign.updateUser(user).getContent()));
    }

    @DeleteMapping(path = "/user/{id}", produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable String id) {
        springRepoFeign.deleteUser(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping(path = "/userGroup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserGroupPojo>> listUserGroup() {
        List<UserGroupPojo> users = springRepoFeign.listUserGroup().getContent().stream().map(UserGroupPojo::getUserPojo).collect(Collectors.toList());
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(path = "/userGroup/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserGroupPojo> findUserGroup(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(UserGroupPojo.getUserPojo(springRepoFeign.findUserGroup(id).getContent()));

    }

    @PostMapping(path = "/userGroup", produces = "application/json")
    public ResponseEntity<UserGroupPojo> createUserGroup(@RequestBody UserGroup user) {
        return ResponseEntity.ok(UserGroupPojo.getUserPojo(springRepoFeign.createUserGroup(user).getContent()));

    }

    @PutMapping(path = "/userGroup", produces = "application/json")
    public ResponseEntity<UserGroupPojo> updateUserGroup(@RequestBody UserGroup user) {
        return ResponseEntity.ok(UserGroupPojo.getUserPojo(springRepoFeign.updateUserGroup(user).getContent()));
    }

    @DeleteMapping(path = "/userGroup/{id}", produces = "application/json")
    public ResponseEntity deleteUserGroup(@PathVariable String id) {
        springRepoFeign.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
