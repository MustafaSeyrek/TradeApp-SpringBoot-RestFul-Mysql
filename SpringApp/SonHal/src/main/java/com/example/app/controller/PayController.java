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

import com.example.app.model.Pay;
import com.example.app.service.PayService;

@RestController
@RequestMapping("/pay")
public class PayController {
	@Autowired
	private PayService service;

	@GetMapping("/hepsi")
	public List<Pay> list() {
		return service.listAll();
	}

	@PostMapping("/ekle")
	public void add(@RequestBody Pay pay) {
		service.createPay(pay);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deletePay(id);
	}
	
	@PutMapping("/satinal/{id}/{userid}")
	public String satinAlma(@PathVariable Integer id,@PathVariable Integer userid) {
		return service.satinAlma(id,userid);
	}
}
