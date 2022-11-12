package com.soap.card.config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.card.entities.Card;
import com.soap.card.interfaces.AddCardRequest;
import com.soap.card.interfaces.AddCardResponse;
import com.soap.card.interfaces.CardInfo;
import com.soap.card.interfaces.DeleteCardRequest;
import com.soap.card.interfaces.DeleteCardResponse;
import com.soap.card.interfaces.GetCardRequest;
import com.soap.card.interfaces.GetCardResponse;
import com.soap.card.interfaces.ServiceStatus;
import com.soap.card.interfaces.UpdateCardRequest;
import com.soap.card.interfaces.UpdateCardResponse;
import com.soap.card.serviceImpl.CardService;

@Endpoint
public class CardEndpoint {

	private static final String NAMESPACE_URI = "http://interfaces.soap.com";

	@Autowired
	private CardService cardService;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCardRequest")
	@ResponsePayload
	public AddCardResponse addCard(@RequestPayload AddCardRequest request) {
		AddCardResponse response = new AddCardResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Card card = new Card();
		BeanUtils.copyProperties(request.getCardInfo(), card);
		cardService.addCard(card);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("A new card is added to the system");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCardRequest")
	@ResponsePayload
	public GetCardResponse getCard(@RequestPayload GetCardRequest request) {
		GetCardResponse response = new GetCardResponse();
		CardInfo cardInfo = new CardInfo();
		BeanUtils.copyProperties(cardService.getCard(request.getCardno()), cardInfo);
		response.setCardInfo(cardInfo);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCardRequest")
	@ResponsePayload
	public UpdateCardResponse updateCard(@RequestPayload UpdateCardRequest request) {
		UpdateCardResponse response = new UpdateCardResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Card card = new Card();
		BeanUtils.copyProperties(request.getCardInfo(), card);
		cardService.updateCard(card);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Card details are updated to the system");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCardRequest")
	@ResponsePayload
	public DeleteCardResponse deleteCard(@RequestPayload DeleteCardRequest request) {
		DeleteCardResponse response = new DeleteCardResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		CardInfo cardInfo = new CardInfo();
		BeanUtils.copyProperties(cardService.getCard(request.getCardno()), cardInfo);
		cardService.deleteCard(request.getCardno());
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Card details are deleted from the system");
		response.setServiceStatus(serviceStatus);
//		response.setCardInfo(cardInfo);
		return response;
	}



}

