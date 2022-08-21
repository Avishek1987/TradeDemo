package com.example.tradedemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tradedemo.entity.Trade;
import com.example.tradedemo.exception.CustomException;
import com.example.tradedemo.repository.TradeRepository;

@Service
public class TradeServiecImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;

	public Trade saveTrade(String str) throws ParseException, CustomException {
		// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		if ((str != null) && !(str.isEmpty())) {
			try {
				jsonObject = (JSONObject) jsonParser.parse(str);
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		}
		Trade trade = new Trade();
		List<Trade> tradeList = tradeRepository.findAll();

		if (!tradeList.isEmpty()) {
			trade = getTrade(jsonObject.get("TradeId").toString());
			System.out.println("Inside tradelist loop");
			for (Trade t1 : tradeList) {

				if (trade.getTradeId().equals(t1.getTradeId())) {
					if (trade.getVersion().equals(t1.getVersion())
							&& (trade.getMaturityDate().isBefore(t1.getCreatedDate()))) {
						System.out.println("Inside tradelist 1st loop");
						Date d = new Date();

						StringBuilder sb = new StringBuilder();
						sb.append(jsonObject.get("TradeId"));
						Trade tr = new Trade();
						tr.setTradeId(sb.toString());
						tr.setBookId(jsonObject.get("BookId").toString());
						tr.setCounterPartyId(jsonObject.get("CounterPartyId").toString());
						tr.setCreatedDate(d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
						String dateStr = (String) jsonObject.get("MaturityDate");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date maturitydate = sdf.parse(dateStr);
						tr.setMaturityDate(maturitydate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
						tr.setVersion(jsonObject.get("Version").toString());
						t1.setExpired(jsonObject.get("Expired").toString());

						return tradeRepository.save(tr);
					} else if (trade.getVersion().equals(t1.getVersion())
							&& (!trade.getMaturityDate().isBefore(t1.getCreatedDate()))) {
						System.out.println("Inside tradelist 2nd loop");
						Date d = new Date();

						StringBuilder sb = new StringBuilder();
						sb.append(jsonObject.get("TradeId"));
						Trade tr = new Trade();
						tr.setTradeId(sb.toString());
						tr.setBookId(jsonObject.get("BookId").toString());
						tr.setCounterPartyId(jsonObject.get("CounterPartyId").toString());
						tr.setCreatedDate(d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
						String dateStr = (String) jsonObject.get("MaturityDate");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date maturitydate = sdf.parse(dateStr);
						tr.setMaturityDate(maturitydate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
						tr.setVersion(jsonObject.get("Version").toString());
						t1.setExpired(jsonObject.get("Expired").toString());

					}

					else if (Integer.parseInt(trade.getVersion()) < Integer.parseInt(t1.getVersion()))

					{
						System.out.println("Inside tradelist 3rd loop");

						throw new CustomException(
								"Version id is lower from existing verion for trade id:" + trade.getVersion());

					}

				}

			}

		}

		else {

			System.out.println("Inside tradelist else loop");

			Date d = new Date();

			StringBuilder sb = new StringBuilder();
			sb.append(jsonObject.get("TradeId"));
			Trade tr = new Trade();
			tr.setTradeId(sb.toString());
			tr.setBookId(jsonObject.get("BookId").toString());
			tr.setCounterPartyId(jsonObject.get("CounterPartyId").toString());
			tr.setCreatedDate(d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			String dateStr = (String) jsonObject.get("MaturityDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date maturitydate = sdf.parse(dateStr);
			tr.setMaturityDate(maturitydate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			tr.setVersion(jsonObject.get("Version").toString());
			tr.setExpired(jsonObject.get("Expired").toString());

			return tradeRepository.save(tr);

		}
		return trade;
	}

	@Override
	public Trade getTrade(String id) {

		return tradeRepository.getById(id);
		// TODO Auto-generated method stub

	}

}
