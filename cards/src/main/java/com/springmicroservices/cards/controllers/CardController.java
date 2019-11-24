package com.springmicroservices.cards.controllers;

import com.springmicroservices.cards.exceptions.ResourceNotFoundException;
import com.springmicroservices.cards.model.Card;
import com.springmicroservices.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @GetMapping("/cards")
    public List<Card> getAllCards() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable Integer id) {
        Optional<Card> card = cardRepository.findById(id);
        if (!card.isPresent())
            throw new ResourceNotFoundException("card-id" + id);
        return card.get();
    }

    @PostMapping("/cards")
    public ResponseEntity<Object> createNewCard(@RequestBody Card card) {
        card.setId(null);
        Card storedCard = cardRepository.save(card);
        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(storedCard.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(@PathVariable Integer id) {
        Optional<Card> card = cardRepository.findById(id);
        if (!card.isPresent())
            throw new ResourceNotFoundException("card-id" + id);

        cardRepository.delete(card.get());
    }
}
