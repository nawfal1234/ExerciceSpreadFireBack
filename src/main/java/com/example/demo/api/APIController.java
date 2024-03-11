package com.example.demo.api;


import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Cell;
import com.example.demo.model.Grid;
import com.example.demo.model.Howa;
import com.example.demo.model.ResultFire;
import com.example.demo.service.FireService;
import com.exemple.demo.config.Configuration;
import com.exemple.demo.config.SimulationResult;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@RestController
public class APIController {
	
	@PostMapping(value="walo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grid> startSimulation(@RequestBody Grid thing){
		FireService fireService = new FireService(thing);
        Grid g = fireService.start(thing.getpP());
       g.setBurnedCellsCount(fireService.getBurnedCellsCount());
       g.setEtatFireGrid(fireService.update(g.getpP()));
		return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(g);
	}
	
	
}
