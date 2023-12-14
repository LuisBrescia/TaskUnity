package taskunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import taskunity.model.Convite;
import taskunity.repository.ConviteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/convites")
public class ConviteController {

    @Autowired
    ConviteRepository conviteRepository;

    @Transactional
    @GetMapping
    public List<Convite> getAllConvites(
        @RequestParam(name = "tasker", required = false) Integer taskerId, 
        @RequestParam(name = "owner", required = false) Integer ownerId,
        @RequestParam(name = "task", required = false) Integer taskId
        ) {

        if ( taskerId != null ) {
            return conviteRepository.findByTasker(taskerId);
        } 
        
        if ( ownerId != null ) {
            return conviteRepository.findByOwner(ownerId);
        }

        if ( taskId != null ) {
            return conviteRepository.findByTask(taskId);
        }

        return conviteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convite> getConvite(@PathVariable Integer id) {
        Optional<Convite> convite = conviteRepository.findById(id);
        return convite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Convite> createConvite(@RequestBody Convite convite) {
        Convite savedConvite = conviteRepository.save(convite);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConvite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Convite> updateConvite(@PathVariable Integer id, @RequestBody Convite convite) {
        if (conviteRepository.existsById(id)) {
            convite.setId(id);
            Convite savedConvite = conviteRepository.save(convite);
            return ResponseEntity.ok(savedConvite);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConvite(@PathVariable Integer id) {
        if (conviteRepository.existsById(id)) {
            conviteRepository.deleteById(id);
            return ResponseEntity.ok("Convite com ID " + id + " excluído com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convite com ID " + id + " não encontrado.");
        }
    }
}
