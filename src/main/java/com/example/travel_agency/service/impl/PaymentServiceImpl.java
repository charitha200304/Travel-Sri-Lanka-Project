package com.example.travel_agency.service.impl;

import com.example.travel_agency.dto.PaymentDTO;
import com.example.travel_agency.entity.Payment;
import com.example.travel_agency.entity.User;
import com.example.travel_agency.repository.PaymentRepo;
import com.example.travel_agency.repository.UsersRepo;
import com.example.travel_agency.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);

        // Validate User
        Optional<User> optUser = usersRepo.findById(paymentDTO.getUserId());
        if (optUser.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + paymentDTO.getUserId());
        }

        // Set User reference
        payment.setUser(optUser.get());

        paymentRepo.save(payment);
    }

    @Override
    public void update(PaymentDTO paymentDTO) {
        Optional<Payment> optPayment = paymentRepo.findById(paymentDTO.getId());
        if (optPayment.isEmpty()) {
            throw new RuntimeException("Payment not found with ID: " + paymentDTO.getId());
        }

        Payment payment = modelMapper.map(paymentDTO, Payment.class);

        // Validate User
        Optional<User> optUser = usersRepo.findById(paymentDTO.getUserId());
        if (optUser.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + paymentDTO.getUserId());
        }

        payment.setUser(optUser.get());

        paymentRepo.save(payment);
    }

    @Override
    public void delete(Long id) {
        if (!paymentRepo.existsById(id)) {
            throw new RuntimeException("Payment not found with ID: " + id);
        }
        paymentRepo.deleteById(id);
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepo.findById(id);
        if (payment.isEmpty()) {
            throw new RuntimeException("Payment not found with ID: " + id);
        }
        return modelMapper.map(payment.get(), PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .toList();
    }

    @Override
    public List<PaymentDTO> getPaymentsByUserId(Long userId) {
        List<Payment> payments = paymentRepo.findByUserId(userId);
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .toList();
    }
}
