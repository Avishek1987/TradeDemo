package com.example.tradedemo.service;

import java.text.ParseException;
import java.util.List;

import com.example.tradedemo.entity.Trade;
import com.example.tradedemo.exception.CustomException;

public interface TradeService {

	Trade saveTrade(String t) throws ParseException, CustomException;
	
	Trade getTrade(String id);
	
}
