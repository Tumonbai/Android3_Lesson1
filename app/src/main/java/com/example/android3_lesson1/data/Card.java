package com.example.android3_lesson1.data;

public class Card<T> {
    private boolean isFaceUp;
    private boolean isMatched;
    private T content;

    public Card(boolean isFaceUp, boolean isMatched, T content) {
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
        this.content = content;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Card{" +
                "isFaceUp=" + isFaceUp +
                ", isMatched=" + isMatched +
                ", content=" + content +
                '}';
    }
}
