package program.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.store.model.Pack;
import program.store.repository.repository_pack.IPackRepository;

@RestController
@RequestMapping("/api/pack")
@CrossOrigin
public class PackRestController {
    @Autowired
    private IPackRepository iPackRepository;

    @GetMapping
    public ResponseEntity<Page<Pack>> getPagePack(@PageableDefault(value = 5) Pageable pageable) {
        Page<Pack> packPage = iPackRepository.findAll(pageable);
        return new ResponseEntity<>(packPage, HttpStatus.OK);
    }

    @GetMapping("/{productName}")
    public ResponseEntity<Page<Pack>> getPagePackByProductName(@PageableDefault(value = 5) Pageable pageable,
                                                               @PathVariable("productName") String productName) {
        Page<Pack> packPage = iPackRepository.findAllByProductNameContaining(productName, pageable);
        return new ResponseEntity<>(packPage, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deletePack(@PathVariable("productId") Integer productId){
        this.iPackRepository.deleteById(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addPack(@RequestBody Pack pack){
        iPackRepository.save(pack);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
