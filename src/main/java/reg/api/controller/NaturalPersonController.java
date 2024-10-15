package reg.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reg.api.domain.entity.*;

@RestController
@RequestMapping("/naturalperson")
public class NaturalPersonController {

    @Autowired
    private NaturalPersonRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity byID(@PathVariable Long id){
        NaturalPerson naturalPerson = repository.findById(id).get();

        return ResponseEntity.ok(new NaturalPersonDataDetail(naturalPerson));
    }

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid NaturalPersonData data, UriComponentsBuilder uriBuilder) {
        NaturalPerson naturalPerson = new NaturalPerson(data);
        repository.save(naturalPerson);

        var uri = uriBuilder.path("/naturalperson/{id}").buildAndExpand(naturalPerson.getId()).toUri();

        return ResponseEntity.created(uri).body(new NaturalPersonDataDetail(naturalPerson));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid NaturalPersonDataUpdate data) {
        NaturalPerson naturalPerson = repository.findById(data.id()).get();
        naturalPerson.updateNaturalPerson(data);

        return ResponseEntity.ok(new NaturalPersonDataDetail(naturalPerson));
    }
}
