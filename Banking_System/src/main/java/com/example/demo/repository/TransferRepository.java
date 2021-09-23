package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, String>{
	List<Transfer> findBydebtorIbanEquals(String accountNumber);

}
