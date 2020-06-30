package billdemo.springjpa.controller;

import billdemo.springjpa.model.repo.IslandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/island")
public class DeleteIslandController {

    @Autowired
    private IslandRepository islandRepository;

    @DeleteMapping(path = "/deleteIslandByName/{name}", produces = "application/json")
    public ResponseEntity deleteIslandByName(@PathVariable String name) {
        return ResponseEntity.ok(islandRepository.deleteByName(name) + "rows deleted");
    }
}
