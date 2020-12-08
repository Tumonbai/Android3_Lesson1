package com.example.android3_lesson1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.EmojiGame;

public class EmojiGameAdapter extends RecyclerView.Adapter <EmojiGameAdapter.Emojiholder> {

    private final EmojiGame game;
    private CardCallback cardCallback;

    public EmojiGameAdapter(EmojiGame game, CardCallback cardCallback) {
        this.game = game;
        this.cardCallback = cardCallback;
    }

    @NonNull
    @Override
    public Emojiholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emoji_card, parent, false);
        return new Emojiholder(view, cardCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull Emojiholder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    static class Emojiholder extends RecyclerView.ViewHolder  {

        private final TextView content;
        private CardCallback cardCallback;

        public Emojiholder(@NonNull View itemView, CardCallback cardCallback) {
            super(itemView);
            content = itemView.findViewById(R.id.tv_card_emoji);
            this.cardCallback = cardCallback;
        }

        public void bind(Card<String> card) {
            itemView.setOnClickListener(v -> cardCallback.choose(card));
            if (card.isFaceUp()) {
                content.setText(card.getContent());
                itemView.setBackgroundColor(Color.WHITE);
            }else  {
                content.setText("");
                itemView.setBackgroundColor(Color.BLUE);
            }


        }
    }
    interface CardCallback {
        void choose(Card<String> card);
    }

}
