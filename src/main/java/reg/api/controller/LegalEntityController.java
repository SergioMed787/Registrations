package reg.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reg.api.domain.entity.*;

@RestController
@RequestMapping("/legalentity")
public class LegalEntityController {

    @Autowired
    private LegalEntityRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity byID(@PathVariable Long id){
        LegalEntity legalEntity = repository.findById(id).get();

        return ResponseEntity.ok(new LegalEntityDataDetail(legalEntity));
    }

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid LegalEntityData data, UriComponentsBuilder uriBuilder) {
        LegalEntity legalEntity = new LegalEntity(data);
        repository.save(legalEntity);

        var uri = uriBuilder.path("/legalentity/{id}").buildAndExpand(legalEntity.getId()).toUri();

        return ResponseEntity.created(uri).body(new LegalEntityDataDetail(legalEntity));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid LegalEntityDataUpdate data) {
        LegalEntity legalEntity = repository.findById(data.id()).get();
        legalEntity.updateLegalEntity(data);

        return ResponseEntity.ok(new LegalEntityDataDetail(legalEntity));
    }
}
