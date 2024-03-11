package com.example.demo.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Grid;

import com.example.demo.service.FireService;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@RestController
public class APIController {

	@PostMapping(value = "start", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grid> startSimulation(@RequestBody Grid thing) {
		FireService fireService = new FireService(thing);
		Grid g = fireService.start(thing.getpP());
		g.setBurnedCellsCount(fireService.getBurnedCellsCount());
		g.setEtatFireGrid(fireService.update(g.getpP()));
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(g);
	}

}
