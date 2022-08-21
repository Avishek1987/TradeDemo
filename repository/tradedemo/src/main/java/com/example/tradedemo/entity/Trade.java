package com.example.tradedemo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.example.deseriallizer.*;

@Entity
@Table(name = "trade")
public class Trade {
   
	
	@Id
	@Column(name ="tradeId")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String TradeId;
	@Column(name ="version")
	public String Version;
	@Column(name ="counterPartyId")
	public String CounterPartyId;
	@Column(name ="bookId")
	public String BookId;
	@Column(name ="maturityDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
   // @JsonDeserialize(using = DateHandler.class)
	public LocalDate MaturityDate;
	@Column(name ="createdDate")
	public LocalDate CreatedDate;
	@Column(name="expired")
	String Expired;
	
	public Trade() {
		super();
	}
	
	public Trade(String tradeId, String version, String counterPartyId, String bookId, LocalDate maturityDate,
			LocalDate createdDate, String expired) {
		super();
		TradeId = tradeId;
		Version = version;
		CounterPartyId = counterPartyId;
		BookId = bookId;
		MaturityDate = maturityDate;
		CreatedDate = createdDate;
		Expired = expired;
	}
	
	
	public String getTradeId() {
		return TradeId;
	}

	public void setTradeId(String tradeId) {
		TradeId = tradeId;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getCounterPartyId() {
		return CounterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		CounterPartyId = counterPartyId;
	}

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public LocalDate getMaturityDate() {
		return MaturityDate;
	}

	public void setMaturityDate(LocalDate maturitydate2) {
		MaturityDate = maturitydate2;
	}

	public LocalDate getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		CreatedDate = createdDate;
	}

	public String getExpired() {
		return Expired;
	}

	public void setExpired(String string) {
		Expired = string;
	}

	@Override
	public int hashCode() {
		return Objects.hash(BookId, CounterPartyId, CreatedDate, Expired, MaturityDate, TradeId, Version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return Objects.equals(BookId, other.BookId) && Objects.equals(CounterPartyId, other.CounterPartyId)
				&& Objects.equals(CreatedDate, other.CreatedDate) && Objects.equals(Expired, other.Expired)
				&& Objects.equals(MaturityDate, other.MaturityDate) && Objects.equals(TradeId, other.TradeId)
				&& Objects.equals(Version, other.Version);
	}


	@Override
	public String toString() {
		return "Trade [TradeId=" + TradeId + ", Version=" + Version + ", CounterPartyId=" + CounterPartyId + ", BookId="
				+ BookId + ", MaturityDate=" + MaturityDate + ", CreatedDate=" + CreatedDate + ", Expired=" + Expired
				+ "]";
	}

	
}
