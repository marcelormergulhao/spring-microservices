package com.springmicroservices.boards.controllers;

import com.springmicroservices.boards.exception.ResourceNotFoundException;
import com.springmicroservices.boards.models.Board;
import com.springmicroservices.boards.models.Card;
import com.springmicroservices.boards.models.LabelGroup;
import com.springmicroservices.boards.proxies.CardProxy;
import com.springmicroservices.boards.repositories.BoardRepository;
import com.springmicroservices.boards.repositories.LabelGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    LabelGroupRepository labelGroupRepository;

    @Autowired
    CardProxy cardProxy;

    @GetMapping("/boards")
    public List<Board> getBoards(){
        return boardRepository.findAll();
    }
    
    @GetMapping("/boards/{id}")
    public Board getBoard(@PathVariable Integer id){
        Optional<Board> board = boardRepository.findById(id);
        if(!board.isPresent())
            throw new ResourceNotFoundException("Board id: "+ id);
        return  board.get();
    }

    @GetMapping("/boards/{id}/labels")
    public List<LabelGroup> getLabelGroupsFromBoard(@PathVariable Integer id){
        Optional<Board> board = boardRepository.findById(id);
        if(!board.isPresent())
            throw new ResourceNotFoundException("Board id: "+ id);

        return labelGroupRepository.findByBoardId(id);
    }

    @GetMapping("/labels/{id}")
    public List<Card> getCardsFromLabelGroup(@PathVariable Integer id){
        Optional<LabelGroup> labelGroup = labelGroupRepository.findById(id);
        if(!labelGroup.isPresent())
            throw new ResourceNotFoundException("Label Group id: " + id);

        List<Card> cardList = labelGroup.get().getCards();
        List<Card> cardsFromService = new ArrayList<>();
        for(Card card : cardList){
            //Call Cards Microservice to get list
            Card cardFromService = cardProxy.getCard(card.getId());
            cardsFromService.add(cardFromService);
        }

        return cardsFromService;
    }

}
