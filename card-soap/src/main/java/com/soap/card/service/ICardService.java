package com.soap.card.service;

import com.soap.card.entities.Card;

public interface ICardService {

	 void addCard(Card card);
	 
	 void updateCard(Card card);
	 
	 void deleteCard(String cardno);
	 
	 Card getCard(String cardno);
	 
	 
	 
	 
	 
}