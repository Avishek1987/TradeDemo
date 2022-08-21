package com.example.tradedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.Before;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.tradedemo.controller.TradeController;
import com.example.tradedemo.entity.Trade;
import com.example.tradedemo.exception.CustomException;
import com.example.tradedemo.repository.TradeRepository;
import com.example.tradedemo.service.TradeServiecImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TradedemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	Trade t;

	@Mock
	TradeRepository tradeRepository;

	@Mock
	TradeController tradeController;

	@InjectMocks
	TradeServiecImpl tradeServiecImpl;

	@Test()
	public void saveTrade_1() throws ParseException, CustomException {

		LocalDate localDate1 = LocalDate.parse("2022-05-21", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate localDate2 = LocalDate.now();

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<Trade> responseEntity = new ResponseEntity<Trade>(header, HttpStatus.OK);

		Trade t = null;
		try {
			t = new Trade("T1", "1", "CP-2", "B2", localDate1, localDate2, "N");
		} catch (Exception e) {

			e.printStackTrace();
		}

		when(tradeController.saveTrade(t.toString())).thenReturn(responseEntity);
		Mockito.verify(tradeController).saveTrade(String.valueOf(t));
	}

	@Test
	public void saveTrade_2() throws ParseException, CustomException {

		LocalDate localDate1 = LocalDate.parse("2022-08-25", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate localDate2 = LocalDate.now();

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<Trade> responseEntity = new ResponseEntity<Trade>(header, HttpStatus.OK);

		Trade t = null;
		try {
			t = new Trade("T2", "3", "CP-1", "B2", localDate1, localDate2, "Y");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		when(tradeController.saveTrade(t.toString())).thenReturn(responseEntity);
		Mockito.verify(tradeController).saveTrade(String.valueOf(t));
		

	}

}
