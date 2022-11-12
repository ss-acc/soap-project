package com.soap.card.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.card.entities.Card;
import com.soap.card.repo.CardRepository;
import com.soap.card.service.ICardService;

@Service
public class CardService implements ICardService {

	 @Autowired
	 CardRepository cardRepository;	
	
	@Override
	public Card getCard(String cardno) {
		
		Card obj = cardRepository.findByCardno(cardno);
		return obj;
		
	}

	@Override
	public void addCard(Card card) {
		cardRepository.save(card);
	}
	
	@Override
	public void updateCard(Card card) {
		cardRepository.save(card);
	}
	
	
	@Override
	@Transactional
	public void deleteCard(String cardno) {
		
		cardRepository.deleteByCardno(cardno);
				
	}
	
	

	
}
