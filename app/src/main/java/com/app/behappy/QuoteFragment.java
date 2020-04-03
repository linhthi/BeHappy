package com.app.behappy;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardview);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[] {R.color.pink_900 , R.color.green_400,
        R.color.lime_400, R.color.orange_400, R.color.amber_800, R.color.pink_800,
        R.color.grey_700, R.color.blue_700, R.color.purple_800};

        quoteText.setText(quote);
        byAuthor.setText("-" + author + "-");

        cardView.setBackgroundResource(getRandomQuote(colors));

        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
        fragment.setArguments(bundle);

        return fragment;

    }

    int getRandomQuote(int[] colorArray) {
        int color;
        int quoteArrayLen = colorArray.length;

        int randomNum = ThreadLocalRandom.current().nextInt(quoteArrayLen);

        color = colorArray[randomNum];

        return color;
    }
}

