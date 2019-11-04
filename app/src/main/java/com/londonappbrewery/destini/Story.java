package com.londonappbrewery.destini;

class Story {
    private final int story;
    private final Integer topAnswer;
    private final Integer bottomAnswer;

    Story(int story, Integer topAnswer, Integer bottomAnswer) {
        this.story = story;
        this.topAnswer = topAnswer;
        this.bottomAnswer = bottomAnswer;
    }

    int getBottomAnswer() {
        return bottomAnswer;
    }

    int getTopAnswer() {
        return topAnswer;
    }

    int getStory() {
        return story;
    }

    boolean isEnd() {
        return topAnswer==null || bottomAnswer==null;
    }
}
