package io.almansa.microservices.currencuexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.almansa.microservices.currencuexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
