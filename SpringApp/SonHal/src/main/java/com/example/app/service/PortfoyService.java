package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Portfoy;
import com.example.app.repository.PortfoyRepository;

@Service
public class PortfoyService {
	@Autowired
	private PortfoyRepository repository;

	public List<Portfoy> listAll() {
		return repository.findAll();
	}

	public void createPortfoy(Portfoy portfoy) {
		repository.save(portfoy);
	}

	public void deletePortfoy(Integer id) {
		repository.deleteById(id);
	}	

	public String sat(String payAdi, Integer userid) {
		List<Portfoy> listP = repository.findAll();
		String result = "Bad Request!";
		for (int i = 0; i < listP.size(); i++) {
			if (listP.get(i).getUser_id() == userid) {
				if ((listP.get(i).getPay_adi().equals(payAdi)) && (listP.get(i).getPay_count() > 0)) {
					Portfoy portf = listP.get(i);
					portf.setPay_count(portf.getPay_count() - 1);
					repository.save(portf);
					result = "Satma işlemi başarılı!";
					break;
				}
			}
		}
		return result;
	}
}
