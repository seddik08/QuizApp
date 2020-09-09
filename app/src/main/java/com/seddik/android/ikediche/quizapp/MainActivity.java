package com.seddik.android.ikediche.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String QUESTION_NUMBER = "question_number";
    private static final String SCORE = "score";
    private static final String IS_QUESTION_ONE_SUBMITTED = "is_question_one_submitted";
    private static final String IS_QUESTION_TOW_SUBMITTED = "is_question_two_submitted";
    private static final String IS_QUESTION_THREE_SUBMITTED = "is_question_three_submitted";
    private static final String IS_QUESTION_FOUR_SUBMITTED = "is_question_four_submitted";
    private static final String IS_QUESTION_FIVE_SUBMITTED = "is_question_five_submitted";
    private static final String IS_QUESTION_SIX_SUBMITTED = "is_question_six_submitted";
    private static final String RESPONSE_FOR_QUESTION_FIVE = "response_for_question_five";
    private static final String RESPONSE_FOR_QUESTION_SIX = "response_for_question_six";
    private static final String IS_SCORE_VIEWED = "is_score_viewed";

    private LinearLayout questionOneContainer;
    private LinearLayout questionTwoContainer;
    private LinearLayout questionThreeContainer;
    private LinearLayout questionFourContainer;
    private LinearLayout questionFiveContainer;
    private LinearLayout questionSixContainer;
    private LinearLayout scoreContainer;

    private AppCompatCheckBox questionOneSuggestionOne;
    private AppCompatCheckBox questionOneSuggestionTow;
    private AppCompatCheckBox questionOneSuggestionThree;
    private AppCompatCheckBox questionOneSuggestionFour;

    private AppCompatRadioButton questionTwoSuggestionOne;
    private AppCompatRadioButton questionTwoSuggestionTwo;
    private AppCompatRadioButton questionTwoSuggestionThree;
    private AppCompatRadioButton questionTwoSuggestionFour;
    private AppCompatRadioButton questionThreeSuggestionOne;
    private AppCompatRadioButton questionThreeSuggestionTwo;
    private AppCompatRadioButton questionThreeSuggestionThree;
    private AppCompatRadioButton questionThreeSuggestionFour;
    private AppCompatRadioButton questionFourSuggestionOne;
    private AppCompatRadioButton questionFourSuggestionTow;
    private AppCompatRadioButton questionFourSuggestionThree;
    private AppCompatRadioButton questionFourSuggestionFour;
    private RadioGroup questionTwoRadioGroup;
    private RadioGroup questionThreeRadioGroup;
    private RadioGroup questionFourRadioGroup;

    private AppCompatEditText questionFiveEditText;
    private AppCompatEditText questionSixEditText;

    private AppCompatButton submitAndNextButton;
    private AppCompatButton previousButton;

    private TextView scoreTextView;

    private int questionNumber = 1;
    private int score = 0;

    private String responseForQuestionFive;
    private String responseForQuestionSix;

    private boolean isQuestionOneSubmitted = false;
    private boolean isQuestionTwoSubmitted = false;
    private boolean isQuestionThreeSubmitted = false;
    private boolean isQuestionFourSubmitted = false;
    private boolean isQuestionFiveSubmitted = false;
    private boolean isQuestionSixSubmitted = false;

    private boolean isScoreViewed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFields();

        if (savedInstanceState != null) {
            questionNumber = savedInstanceState.getInt(QUESTION_NUMBER);
            score = savedInstanceState.getInt(SCORE);
            isQuestionOneSubmitted = savedInstanceState.getBoolean(IS_QUESTION_ONE_SUBMITTED);
            isQuestionTwoSubmitted = savedInstanceState.getBoolean(IS_QUESTION_TOW_SUBMITTED);
            isQuestionThreeSubmitted = savedInstanceState.getBoolean(IS_QUESTION_THREE_SUBMITTED);
            isQuestionFourSubmitted = savedInstanceState.getBoolean(IS_QUESTION_FOUR_SUBMITTED);
            isQuestionFiveSubmitted = savedInstanceState.getBoolean(IS_QUESTION_FIVE_SUBMITTED);
            isQuestionSixSubmitted = savedInstanceState.getBoolean(IS_QUESTION_SIX_SUBMITTED);
            responseForQuestionFive = savedInstanceState.getString(RESPONSE_FOR_QUESTION_FIVE);
            responseForQuestionSix = savedInstanceState.getString(RESPONSE_FOR_QUESTION_SIX);
            isScoreViewed = savedInstanceState.getBoolean(IS_SCORE_VIEWED);

            if (questionNumber >= 2) {
                previousButton.setVisibility(View.VISIBLE);
            }
            if (questionNumber == 1) {
                if (isQuestionOneSubmitted) {
                    submitAndNextButton.setText(getString(R.string.next));
                }
            } else if (questionNumber == 2) {
                questionTwoContainer.setVisibility(View.VISIBLE);
                questionOneContainer.setVisibility(View.INVISIBLE);
                if (isQuestionTwoSubmitted) {
                    submitAndNextButton.setText(getString(R.string.next));
                }
            } else if (questionNumber == 3) {
                questionThreeContainer.setVisibility(View.VISIBLE);
                questionOneContainer.setVisibility(View.INVISIBLE);
                if (isQuestionThreeSubmitted) {
                    submitAndNextButton.setText(getString(R.string.next));
                }
            } else if (questionNumber == 4) {
                questionFourContainer.setVisibility(View.VISIBLE);
                questionOneContainer.setVisibility(View.INVISIBLE);
                if (isQuestionFourSubmitted) {
                    submitAndNextButton.setText(getString(R.string.next));
                }
            } else if (questionNumber == 5) {
                questionFiveContainer.setVisibility(View.VISIBLE);
                questionOneContainer.setVisibility(View.INVISIBLE);
                if (isQuestionFiveSubmitted) {
                    submitAndNextButton.setText(getString(R.string.next));
                }
            } else if (questionNumber == 6) {
                if (isScoreViewed) {
                    scoreContainer.setVisibility(View.VISIBLE);
                    questionOneContainer.setVisibility(View.INVISIBLE);
                    scoreTextView.setText(getString(R.string.score_result, score));
                    submitAndNextButton.setVisibility(View.INVISIBLE);
                    previousButton.setVisibility(View.INVISIBLE);
                    submitAndNextButton.setEnabled(false);
                    previousButton.setEnabled(false);
                } else {
                    questionSixContainer.setVisibility(View.VISIBLE);
                    questionOneContainer.setVisibility(View.INVISIBLE);
                    if (isQuestionSixSubmitted) {
                        submitAndNextButton.setText(getString(R.string.view_score));
                    }
                }

            }

            if (isQuestionOneSubmitted) {
                questionOneSuggestionOne.setBackgroundResource(R.drawable.correct_question_background);
                questionOneSuggestionTow.setBackgroundResource(R.drawable.correct_question_background);
                questionOneSuggestionThree.setBackgroundResource(R.drawable.false_question_background);
                questionOneSuggestionFour.setBackgroundResource(R.drawable.correct_question_background);
                questionOneSuggestionOne.setEnabled(false);
                questionOneSuggestionTow.setEnabled(false);
                questionOneSuggestionThree.setEnabled(false);
                questionOneSuggestionFour.setEnabled(false);
            }

            if (isQuestionTwoSubmitted) {
                questionTwoSuggestionOne.setBackgroundResource(R.drawable.false_question_background);
                questionTwoSuggestionTwo.setBackgroundResource(R.drawable.false_question_background);
                questionTwoSuggestionThree.setBackgroundResource(R.drawable.correct_question_background);
                questionTwoSuggestionFour.setBackgroundResource(R.drawable.false_question_background);
                questionTwoSuggestionOne.setEnabled(false);
                questionTwoSuggestionTwo.setEnabled(false);
                questionTwoSuggestionThree.setEnabled(false);
                questionTwoSuggestionFour.setEnabled(false);
            }

            if (isQuestionThreeSubmitted) {
                questionThreeSuggestionOne.setBackgroundResource(R.drawable.correct_question_background);
                questionThreeSuggestionTwo.setBackgroundResource(R.drawable.false_question_background);
                questionThreeSuggestionThree.setBackgroundResource(R.drawable.false_question_background);
                questionThreeSuggestionFour.setBackgroundResource(R.drawable.false_question_background);
                questionThreeSuggestionOne.setEnabled(false);
                questionThreeSuggestionTwo.setEnabled(false);
                questionThreeSuggestionThree.setEnabled(false);
                questionThreeSuggestionFour.setEnabled(false);
            }

            if (isQuestionFourSubmitted) {
                questionFourSuggestionOne.setBackgroundResource(R.drawable.false_question_background);
                questionFourSuggestionTow.setBackgroundResource(R.drawable.correct_question_background);
                questionFourSuggestionThree.setBackgroundResource(R.drawable.false_question_background);
                questionFourSuggestionFour.setBackgroundResource(R.drawable.false_question_background);
                questionFourSuggestionOne.setEnabled(false);
                questionFourSuggestionTow.setEnabled(false);
                questionFourSuggestionThree.setEnabled(false);
                questionFourSuggestionFour.setEnabled(false);
            }

            if (isQuestionFiveSubmitted) {

                if (responseForQuestionFive.equals(getString(R.string.gradle))) {
                    questionFiveEditText.setBackgroundResource(R.drawable.correct_question_background);
                } else {
                    questionFiveEditText.setBackgroundResource(R.drawable.false_question_background);
                }
                questionFiveEditText.setEnabled(false);
            }

            if (isQuestionSixSubmitted) {
                if (responseForQuestionSix.equals(getString(R.string.image_view))) {
                    questionSixEditText.setBackgroundResource(R.drawable.correct_question_background);
                } else {
                    questionSixEditText.setBackgroundResource(R.drawable.false_question_background);
                }
                questionSixEditText.setEnabled(false);
            }

        }
    }

    /**
     * this method for saving the state of the ui in configuration changes
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(QUESTION_NUMBER, questionNumber);
        outState.putInt(SCORE, score);
        outState.putBoolean(IS_QUESTION_ONE_SUBMITTED, isQuestionOneSubmitted);
        outState.putBoolean(IS_QUESTION_TOW_SUBMITTED, isQuestionTwoSubmitted);
        outState.putBoolean(IS_QUESTION_THREE_SUBMITTED, isQuestionThreeSubmitted);
        outState.putBoolean(IS_QUESTION_FOUR_SUBMITTED, isQuestionFourSubmitted);
        outState.putBoolean(IS_QUESTION_FIVE_SUBMITTED, isQuestionFiveSubmitted);
        outState.putBoolean(IS_QUESTION_SIX_SUBMITTED, isQuestionSixSubmitted);
        outState.putString(RESPONSE_FOR_QUESTION_FIVE, responseForQuestionFive);
        outState.putString(RESPONSE_FOR_QUESTION_SIX, responseForQuestionSix);
        outState.putBoolean(IS_SCORE_VIEWED, isScoreViewed);
        super.onSaveInstanceState(outState);
    }

    /**
     * this method get called when the submit or next button get clicked
     */
    public void onSubmitOrNextClicked(View view) {
        if (submitAndNextButton.getText().toString().equals(getString(R.string.submit))) {
            if (questionNumber == 1) {

                if (!questionOneSuggestionOne.isChecked() && !questionOneSuggestionTow.isChecked()
                        && !questionOneSuggestionFour.isChecked() && !questionOneSuggestionThree.isChecked()) {
                    Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (questionOneSuggestionOne.isChecked() && questionOneSuggestionTow.isChecked()
                        && questionOneSuggestionFour.isChecked()) {
                    score = score + 1;
                }
                questionOneSuggestionOne.setBackgroundResource(R.drawable.correct_question_background);
                questionOneSuggestionTow.setBackgroundResource(R.drawable.correct_question_background);
                questionOneSuggestionThree.setBackgroundResource(R.drawable.false_question_background);
                questionOneSuggestionFour.setBackgroundResource(R.drawable.correct_question_background);
                questionOneSuggestionOne.setEnabled(false);
                questionOneSuggestionTow.setEnabled(false);
                questionOneSuggestionThree.setEnabled(false);
                questionOneSuggestionFour.setEnabled(false);
                isQuestionOneSubmitted = true;
            } else if (questionNumber == 2) {
                if (!questionTwoSuggestionOne.isChecked() && !questionTwoSuggestionTwo.isChecked()
                        && !questionTwoSuggestionThree.isChecked() && !questionTwoSuggestionFour.isChecked()) {
                    Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (questionTwoSuggestionThree.isChecked()) {
                    score = score + 1;
                }

                questionTwoSuggestionOne.setBackgroundResource(R.drawable.false_question_background);
                questionTwoSuggestionTwo.setBackgroundResource(R.drawable.false_question_background);
                questionTwoSuggestionThree.setBackgroundResource(R.drawable.correct_question_background);
                questionTwoSuggestionFour.setBackgroundResource(R.drawable.false_question_background);
                questionTwoSuggestionOne.setEnabled(false);
                questionTwoSuggestionTwo.setEnabled(false);
                questionTwoSuggestionThree.setEnabled(false);
                questionTwoSuggestionFour.setEnabled(false);
                isQuestionTwoSubmitted = true;
            } else if (questionNumber == 3) {
                if (!questionThreeSuggestionOne.isChecked() && !questionThreeSuggestionTwo.isChecked()
                        && !questionThreeSuggestionThree.isChecked() && !questionThreeSuggestionFour.isChecked()) {
                    Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (questionThreeSuggestionOne.isChecked()) {
                    score = score + 1;
                }

                questionThreeSuggestionOne.setBackgroundResource(R.drawable.correct_question_background);
                questionThreeSuggestionTwo.setBackgroundResource(R.drawable.false_question_background);
                questionThreeSuggestionThree.setBackgroundResource(R.drawable.false_question_background);
                questionThreeSuggestionFour.setBackgroundResource(R.drawable.false_question_background);
                questionThreeSuggestionOne.setEnabled(false);
                questionThreeSuggestionTwo.setEnabled(false);
                questionThreeSuggestionThree.setEnabled(false);
                questionThreeSuggestionFour.setEnabled(false);
                isQuestionThreeSubmitted = true;
            } else if (questionNumber == 4) {
                if (!questionFourSuggestionOne.isChecked() && !questionFourSuggestionTow.isChecked()
                        && !questionFourSuggestionThree.isChecked() && !questionFourSuggestionFour.isChecked()) {
                    Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (questionFourSuggestionTow.isChecked()) {
                    score = score + 1;
                }

                questionFourSuggestionOne.setBackgroundResource(R.drawable.false_question_background);
                questionFourSuggestionTow.setBackgroundResource(R.drawable.correct_question_background);
                questionFourSuggestionThree.setBackgroundResource(R.drawable.false_question_background);
                questionFourSuggestionFour.setBackgroundResource(R.drawable.false_question_background);
                questionFourSuggestionOne.setEnabled(false);
                questionFourSuggestionTow.setEnabled(false);
                questionFourSuggestionThree.setEnabled(false);
                questionFourSuggestionFour.setEnabled(false);
                isQuestionFourSubmitted = true;
            } else if (questionNumber == 5) {
                responseForQuestionFive = Objects.requireNonNull(questionFiveEditText.getText()).toString().trim();
                if (responseForQuestionFive.isEmpty()) {
                    Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (responseForQuestionFive.equals(getString(R.string.gradle))) {
                    score = score + 1;
                    questionFiveEditText.setBackgroundResource(R.drawable.correct_question_background);
                } else {
                    questionFiveEditText.setBackgroundResource(R.drawable.false_question_background);
                }
                isQuestionFiveSubmitted = true;
                questionFiveEditText.setEnabled(false);
            } else if (questionNumber == 6) {
                responseForQuestionSix = Objects.requireNonNull(questionSixEditText.getText()).toString().trim();
                if (responseForQuestionSix.isEmpty()) {
                    Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (responseForQuestionSix.equals(getString(R.string.image_view))) {
                    score = score + 1;
                    questionSixEditText.setBackgroundResource(R.drawable.correct_question_background);
                } else {
                    questionSixEditText.setBackgroundResource(R.drawable.false_question_background);
                }
                isQuestionSixSubmitted = true;
                questionSixEditText.setEnabled(false);
                submitAndNextButton.setText(getString(R.string.view_score));
            }
            if (questionNumber != 6) {
                submitAndNextButton.setText(getString(R.string.next));
            }

        } else if (submitAndNextButton.getText().toString().equals(getString(R.string.next))) {
            if (questionNumber == 1) {

                if (!isQuestionTwoSubmitted) {
                    submitAndNextButton.setText(getString(R.string.submit));
                }
                questionOneContainer.setVisibility(View.INVISIBLE);
                questionTwoContainer.setVisibility(View.VISIBLE);
                questionNumber++;
                previousButton.setVisibility(View.VISIBLE);

            } else if (questionNumber == 2) {

                if (!isQuestionThreeSubmitted) {
                    submitAndNextButton.setText(getString(R.string.submit));
                }
                questionTwoContainer.setVisibility(View.INVISIBLE);
                questionThreeContainer.setVisibility(View.VISIBLE);
                questionNumber++;
            } else if (questionNumber == 3) {
                if (!isQuestionFourSubmitted) {
                    submitAndNextButton.setText(getString(R.string.submit));
                }
                questionThreeContainer.setVisibility(View.INVISIBLE);
                questionFourContainer.setVisibility(View.VISIBLE);
                questionNumber++;
            } else if (questionNumber == 4) {
                if (!isQuestionFiveSubmitted) {
                    submitAndNextButton.setText(getString(R.string.submit));
                }
                questionFourContainer.setVisibility(View.INVISIBLE);
                questionFiveContainer.setVisibility(View.VISIBLE);
                questionNumber++;
            } else if (questionNumber == 5) {
                if (!isQuestionSixSubmitted) {
                    submitAndNextButton.setText(getString(R.string.submit));
                } else {
                    submitAndNextButton.setText(getString(R.string.view_score));
                }
                questionFiveContainer.setVisibility(View.INVISIBLE);
                questionSixContainer.setVisibility(View.VISIBLE);
                questionNumber++;
            }
        } else if (submitAndNextButton.getText().toString().equals(getString(R.string.view_score))) {
            questionSixContainer.setVisibility(View.INVISIBLE);
            scoreContainer.setVisibility(View.VISIBLE);
            submitAndNextButton.setVisibility(View.INVISIBLE);
            previousButton.setVisibility(View.INVISIBLE);
            submitAndNextButton.setEnabled(false);
            previousButton.setEnabled(false);
            scoreTextView.setText(getString(R.string.score_result, score));
            Toast.makeText(this, getString(R.string.final_score) + " " + getString(R.string.score_result, score), Toast.LENGTH_SHORT).show();
            isScoreViewed = true;
        }
    }

    /**
     * this method get called when the previous get clicked
     */
    public void onPreviousGetClicked(View view) {

        submitAndNextButton.setText(getString(R.string.next));

        if (questionNumber == 2) {
            questionOneContainer.setVisibility(View.VISIBLE);
            questionTwoContainer.setVisibility(View.INVISIBLE);
            previousButton.setVisibility(View.INVISIBLE);
            questionNumber--;
        } else if (questionNumber == 3) {
            questionTwoContainer.setVisibility(View.VISIBLE);
            questionThreeContainer.setVisibility(View.INVISIBLE);
            questionNumber--;
        } else if (questionNumber == 4) {
            questionThreeContainer.setVisibility(View.VISIBLE);
            questionFourContainer.setVisibility(View.INVISIBLE);
            questionNumber--;
        } else if (questionNumber == 5) {
            questionFourContainer.setVisibility(View.VISIBLE);
            questionFiveContainer.setVisibility(View.INVISIBLE);
            questionNumber--;
        } else if (questionNumber == 6) {
            questionFiveContainer.setVisibility(View.VISIBLE);
            questionSixContainer.setVisibility(View.INVISIBLE);
            questionNumber--;
        }
    }

    /**
     * this method get called when the play again  button is  clicked
     */
    public void playAgain(View view) {
        questionNumber = 1;
        score = 0;
        questionOneContainer.setVisibility(View.VISIBLE);
        scoreContainer.setVisibility(View.INVISIBLE);
        submitAndNextButton.setVisibility(View.VISIBLE);
        submitAndNextButton.setText(getString(R.string.submit));
        submitAndNextButton.setEnabled(true);
        previousButton.setEnabled(true);
        questionOneSuggestionOne.setEnabled(true);
        questionOneSuggestionTow.setEnabled(true);
        questionOneSuggestionThree.setEnabled(true);
        questionOneSuggestionFour.setEnabled(true);
        questionTwoSuggestionOne.setEnabled(true);
        questionTwoSuggestionTwo.setEnabled(true);
        questionTwoSuggestionThree.setEnabled(true);
        questionTwoSuggestionFour.setEnabled(true);
        questionThreeSuggestionOne.setEnabled(true);
        questionThreeSuggestionTwo.setEnabled(true);
        questionThreeSuggestionThree.setEnabled(true);
        questionThreeSuggestionFour.setEnabled(true);
        questionFourSuggestionOne.setEnabled(true);
        questionFourSuggestionTow.setEnabled(true);
        questionFourSuggestionThree.setEnabled(true);
        questionFourSuggestionFour.setEnabled(true);
        questionFiveEditText.setEnabled(true);
        questionSixEditText.setEnabled(true);
        questionOneSuggestionOne.setBackground(null);
        questionOneSuggestionTow.setBackground(null);
        questionOneSuggestionThree.setBackground(null);
        questionOneSuggestionFour.setBackground(null);
        questionTwoSuggestionOne.setBackground(null);
        questionTwoSuggestionTwo.setBackground(null);
        questionTwoSuggestionThree.setBackground(null);
        questionTwoSuggestionFour.setBackground(null);
        questionThreeSuggestionOne.setBackground(null);
        questionThreeSuggestionTwo.setBackground(null);
        questionThreeSuggestionThree.setBackground(null);
        questionThreeSuggestionFour.setBackground(null);
        questionFourSuggestionOne.setBackground(null);
        questionFourSuggestionTow.setBackground(null);
        questionFourSuggestionThree.setBackground(null);
        questionFourSuggestionFour.setBackground(null);
        questionFiveEditText.setBackground(null);
        questionSixEditText.setBackground(null);
        questionOneSuggestionOne.setChecked(false);
        questionOneSuggestionTow.setChecked(false);
        questionOneSuggestionThree.setChecked(false);
        questionOneSuggestionFour.setChecked(false);
        questionTwoRadioGroup.clearCheck();
        questionThreeRadioGroup.clearCheck();
        questionFourRadioGroup.clearCheck();
        questionFiveEditText.setText("");
        questionFiveEditText.setBackgroundResource(R.drawable.edit_text_background);
        questionSixEditText.setText("");
        questionSixEditText.setBackgroundResource(R.drawable.edit_text_background);
        isQuestionOneSubmitted = false;
        isQuestionTwoSubmitted = false;
        isQuestionThreeSubmitted = false;
        isQuestionFourSubmitted = false;
        isQuestionFiveSubmitted = false;
        isQuestionSixSubmitted = false;
        isScoreViewed = false;
    }

    /**
     * the method initialize our fields
     */
    private void initializeFields() {
        questionOneContainer = findViewById(R.id.question_one_container);
        questionTwoContainer = findViewById(R.id.question_two_container);
        questionThreeContainer = findViewById(R.id.question_three_container);
        questionFourContainer = findViewById(R.id.question_four_container);
        questionFiveContainer = findViewById(R.id.question_five_container);
        questionSixContainer = findViewById(R.id.question_six_container);
        scoreContainer = findViewById(R.id.score_container);
        questionOneSuggestionOne = findViewById(R.id.question_one_suggestion_one);
        questionOneSuggestionTow = findViewById(R.id.question_one_suggestion_two);
        questionOneSuggestionThree = findViewById(R.id.question_one_suggestion_three);
        questionOneSuggestionFour = findViewById(R.id.question_one_suggestion_four);
        questionTwoSuggestionOne = findViewById(R.id.question_two_suggestion_one);
        questionTwoSuggestionTwo = findViewById(R.id.question_two_suggestion_two);
        questionTwoSuggestionThree = findViewById(R.id.question_two_suggestion_three);
        questionTwoSuggestionFour = findViewById(R.id.question_two_suggestion_four);
        questionThreeSuggestionOne = findViewById(R.id.question_three_suggestion_one);
        questionThreeSuggestionTwo = findViewById(R.id.question_three_suggestion_two);
        questionThreeSuggestionThree = findViewById(R.id.question_three_suggestion_three);
        questionThreeSuggestionFour = findViewById(R.id.question_three_suggestion_four);
        questionFourSuggestionOne = findViewById(R.id.question_four_suggestion_one);
        questionFourSuggestionTow = findViewById(R.id.question_four_suggestion_two);
        questionFourSuggestionThree = findViewById(R.id.question_four_suggestion_three);
        questionFourSuggestionFour = findViewById(R.id.question_four_suggestion_four);
        questionFiveEditText = findViewById(R.id.question_five_edit_text);
        questionSixEditText = findViewById(R.id.question_six_edit_text);
        submitAndNextButton = findViewById(R.id.next_submit_button);
        previousButton = findViewById(R.id.previous_button);
        scoreTextView = findViewById(R.id.score_text_view);
        questionTwoRadioGroup = findViewById(R.id.question_two_radio_group);
        questionThreeRadioGroup = findViewById(R.id.question_three_radio_group);
        questionFourRadioGroup = findViewById(R.id.question_four_radio_group);
    }
}
