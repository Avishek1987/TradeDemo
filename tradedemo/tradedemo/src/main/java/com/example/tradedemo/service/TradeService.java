package com.example.tradedemo.service;

import java.text.ParseException;
import java.util.List;

import com.eaxple.tradedemo.exception.CustomException;
import com.example.tradedemo.entity.Trade;

public interface TradeService {

	Trade saveTrade(String t) throws ParseException, CustomException;
	
	Trade getTrade(String id);
	
}
