package reg.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reg.api.domain.entity.EntityData;
import reg.api.domain.entity.EntityRepository;

import java.util.List;

@RestController
@RequestMapping("/entities")
public class EntityController {

    @Autowired
    private EntityRepository repository;

    @GetMapping
    public ResponseEntity<Page<EntityData>> list(@PageableDefault(size=10, sort={"description"}) Pageable pagination){
        var page = repository.findAll(pagination).map(EntityData::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
