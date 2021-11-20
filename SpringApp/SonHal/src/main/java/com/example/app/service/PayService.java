package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Pay;
import com.example.app.model.Portfoy;
import com.example.app.repository.PayRepository;
import com.example.app.repository.PortfoyRepository;

@Service
public class PayService {
	@Autowired
	private PayRepository repository;
	private Pay p = new Pay();

	@Autowired
	private PortfoyRepository portRepo;

	public List<Pay> listAll() {
		return repository.findAll();
	}

	public void createPay(Pay pay) {
		repository.save(pay);
	}

	public void deletePay(Integer id) {
		repository.deleteById(id);
	}

	// satın alma kısmı
	public String satinAlma(Integer payId, Integer userid) {
		boolean flag = true;
		p = repository.getById(payId);
		if (p.getCount() - p.getSatilan_count() > 0) {
			p.setSatilan_count(p.getSatilan_count() + 1);// satilanı artırdık
			repository.save(p);

			// portfoya ekleme kısmı
			List<Portfoy> listP = portRepo.findAll();
			for (int i = 0; i < listP.size(); i++) {
				// daha once almıssa
				if ((listP.get(i).getUser_id() == userid) && (listP.get(i).getPay_adi().equals(p.getAdi()))) {
					Portfoy portf = listP.get(i);
					portf.setPay_count(portf.getPay_count() + 1);
					portRepo.save(portf);
					flag = false;
					break;
				}
			}
			if (flag == true) {// daha once almamıssa
				Portfoy portf = new Portfoy();
				portf.setPay_adi(p.getAdi());
				portf.setPay_count(1);
				portf.setUser_id(userid);
				portf.setId(0);
				portRepo.save(portf);
			}

			return "Satın Alma Başarılı";
		} else {
			return " Bad Request!";
		}
	}

}
