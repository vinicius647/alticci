package com.dellent.alticci.controller;

import com.dellent.alticci.service.SeqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Endpoint alticci.")
@RestController
@RequestMapping("/alticci")
public class SeqController {

    private final SeqService service;

    public SeqController(SeqService service) {
        this.service = service;
    }

    @Operation(description = "Get the value according to the n parameter. 'n' should not be lesser than 0. Invalid parameter will be returned BAD_REQUEST.")
    @GetMapping("/{n}")
    public ResponseEntity<?> getValue(@PathVariable(name = "n") int n) {
        if (n < 0) {
            return ResponseEntity.badRequest().body("Value must be >= 0.");
        }
        return ResponseEntity.ok(this.service.getValue(n));
    }
}
