package com.example.tradedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tradedemo.entity.Trade;
@Repository
public interface TradeRepository extends JpaRepository<Trade, String>{
	
	

}
