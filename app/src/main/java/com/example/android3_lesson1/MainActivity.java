package com.example.android3_lesson1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.EmojiGame;

public class MainActivity extends AppCompatActivity implements EmojiGameAdapter.CardCallback {

    private RecyclerView emojiRecycler;
    private EmojiGameAdapter emojiGameAdapter;
    private EmojiGame emojiGame;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiRecycler = findViewById(R.id.rv_cards);
        emojiGame = new EmojiGame();
        emojiGameAdapter = new EmojiGameAdapter(emojiGame, this);
        emojiRecycler.setAdapter(emojiGameAdapter);
        setGridLayout();


    }
    public void setGridLayout(){
        emojiRecycler.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public void choose(Card<String> card) {
        emojiGame.choose(card);
        emojiGameAdapter.notifyDataSetChanged();

    }
}