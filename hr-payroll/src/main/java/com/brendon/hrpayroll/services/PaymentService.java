package com.brendon.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.hrpayroll.entities.Payment;
import com.brendon.hrpayroll.entities.Worker;
import com.brendon.hrpayroll.feignclients.WorkerFeignClients;

@Service 
public class PaymentService {
	
	@Autowired
	private WorkerFeignClients workerFeignClients;
		
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClients.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
