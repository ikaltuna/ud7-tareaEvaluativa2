package eus.birt.dam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Museos;
import eus.birt.dam.repository.MuseoRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MuseosController {

	
	@Autowired
	MuseoRepository museoRepository;
	
	/**
	 * Endpoint principal de museos.
	 * @return
	 */
	@GetMapping("/museos")
	public ResponseEntity<List<Museos>> index() {
	    try {
	        List<Museos> museos = museoRepository.findAll();
	        return new ResponseEntity<List<Museos>>(museos, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<Museos>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/provinces")
	public ResponseEntity<List<String>> getAllTerritories() {
	    try {
	        List<Museos> museos = museoRepository.findAll();
	        Set<String> uniqueTerritories = new HashSet<>();
	        for (Museos museos1 : museos) {
	            uniqueTerritories.add(museos1.getProperties().getTerritory());
	        }
	        List<String> sortedTerritories = new ArrayList<>(uniqueTerritories);
	        Collections.sort(sortedTerritories);
	        return new ResponseEntity<List<String>>(sortedTerritories, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@GetMapping("/municipalities")
	public ResponseEntity<List<String>> getAllMunicipalities() {
	    try {
	        List<Museos> museos = museoRepository.findAll();
	        Set<String> uniqueMunicipalities = new HashSet<>();
	        for (Museos museos1 : museos) {
	            uniqueMunicipalities.add(museos1.getProperties().getMunicipality());
	        }
	        List<String> sortedMunicipalities = new ArrayList<>(uniqueMunicipalities);
	        Collections.sort(sortedMunicipalities);
	        return new ResponseEntity<List<String>>(sortedMunicipalities, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}