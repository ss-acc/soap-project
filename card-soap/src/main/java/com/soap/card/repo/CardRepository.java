package com.soap.card.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.card.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{


	Card findByCardno(String cardno);
	
	void deleteByCardno(String cardno);

}
