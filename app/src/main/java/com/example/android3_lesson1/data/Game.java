package com.example.android3_lesson1.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Game <CardContent> {

    private List<Card<CardContent>> cards = new ArrayList<>();
    private boolean b;

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i)));
            cards.add(new Card<>(false, false, contents.get(i)));
            Collections.shuffle(cards);
        }
    }

    public void choose(Card<CardContent> card) {
        b = false;
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            checkPairs(card);
        }
        if (b = true) {
            removePairs();
        }
    }

    private void checkPairs(Card<CardContent> card) {
        b = false;
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.isFaceUp() && anotherCard.getContent() == card.getContent()) {
                card.setMatched(!card.isMatched());
                anotherCard.setMatched(!anotherCard.isMatched());
            } else {
                anotherCard.setFaceUp(false);
                anotherCard.setFaceUp(false);
            }
            if (anotherCard.isMatched() == true && card.isMatched() == true) {
                b = true;
            }
        }
    }

    private void removePairs() {
        Iterator<Card<CardContent>> i = cards.iterator();
        while (i.hasNext()) {
            Card<CardContent> someCard = i.next();
            if (someCard.isMatched() == true) {
                i.remove();
            }
        }

    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}