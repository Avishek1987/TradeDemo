package com.example.tradedemo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tradedemo.entity.Trade;
import com.example.tradedemo.service.TradeServiecImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/trade")
public class TradeController {

	@Autowired
	TradeServiecImpl tradeServiecImpl;

	@PostMapping("/savetrade")
	public ResponseEntity<Trade> saveTrade(@RequestBody String t) throws ParseException {

		try {

			tradeServiecImpl.saveTrade(t);

		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Trade>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		  return new ResponseEntity<Trade>(HttpStatus.OK);

	}

}
