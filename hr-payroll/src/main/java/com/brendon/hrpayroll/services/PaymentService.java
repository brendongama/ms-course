package com.brendon.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.brendon.hrpayroll.entities.Payment;

@Service 
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Brendon", 100.00, days);
	}
}
