package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView storyTextView;
    private Button topButton;
    private Button bottomButton;

    private int activeStory;

    final Story[] stories = new Story[]{
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End, null, null),
            new Story(R.string.T5_End, null, null),
            new Story(R.string.T6_End, null, null)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyTextView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        nextStory(activeStory);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activeStory == 0 || activeStory == 1) {
                    nextStory(2);
                } else if (activeStory == 2) {
                    nextStory(5);
                }
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activeStory == 0) {
                    nextStory(1);
                }else if(activeStory == 1){
                    nextStory(3);
                }else if(activeStory == 2){
                    nextStory(4);
                }
            }
        });

    }

    private void nextStory(int nextStoryIndex) {
        activeStory = nextStoryIndex;
        Story story = stories[activeStory];
        storyTextView.setText(story.getStory());
        if (story.isEnd()) {
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
        } else {
            topButton.setText(story.getTopAnswer());
            bottomButton.setText(story.getBottomAnswer());
        }
    }

}
