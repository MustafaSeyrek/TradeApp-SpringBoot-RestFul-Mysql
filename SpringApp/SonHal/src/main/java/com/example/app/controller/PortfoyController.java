package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Portfoy;
import com.example.app.service.PortfoyService;

@RestController
@RequestMapping("/portfoy")
public class PortfoyController {
	@Autowired
	private PortfoyService service;

	@GetMapping("/hepsi")
	public List<Portfoy> list() {
		return service.listAll();
	}

	@PostMapping("/ekle")
	public void add(@RequestBody Portfoy portfoy) {
		service.createPortfoy(portfoy);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deletePortfoy(id);
	}

	/*@PutMapping("/satinal/{payAdi}/{userid}")
	public void satinAlma(@PathVariable String payAdi, @PathVariable Integer userid) {
		service.satinAlma(payAdi, userid);
	}*/

	@PutMapping("/sat/{payAdi}/{userid}")
	public String sat(@PathVariable String payAdi, @PathVariable Integer userid) {
		return service.sat(payAdi, userid);
	}
}
