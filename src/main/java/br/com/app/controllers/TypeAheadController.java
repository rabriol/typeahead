package br.com.app.controllers;

import br.com.app.services.TypeAheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TypeAheadController {

    private TypeAheadService typeAhedService;

    @Autowired
    public TypeAheadController(TypeAheadService typeahedService) {
        this.typeAhedService = typeahedService;
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping(value = "/api/predict/{word}")
    public ResponseEntity insert(@PathVariable String word) {
        typeAhedService.insert(word);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/api/predict/{word}")
    public ResponseEntity<List<String>> predict(@PathVariable String word) {
        return ResponseEntity.ok(typeAhedService.predict(word));
    }
}
