package com.example.android3_lesson1.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

public class EmojiGame {
    private final Game<String> game;

    @RequiresApi (api = Build.VERSION_CODES.R)
    public EmojiGame() {
        List<String> content = List.of("\uD83C\uDF0D", "\uD83D\uDE0B", "\uD83D\uDC4C", "\uD83E\uDD70", "🤩");
        game = new Game<>(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);

    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
