package ro.quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    static int scorCorect = 0, scorIncorect = 0, count = 0;

    Context context;

    static int[] questionArray = {
            R.string.question_1_eurovision,
            R.string.question_2_sergiu_nicolaescu,
            R.string.question_3_europa_fluviu,
            R.string.question_4_champions_league,
            R.string.question_5_capitala,
            R.string.question_6_primul_razboi_mondial,
            R.string.question_7_regele_mihai_si_regina_ana,
            R.string.question_8_taxi,
            R.string.question_9_florin_piersic,
            R.string.question_10_prima_noapte_de_dragoste
    };

    static String[] answerArray = {
            "c",
            "c",
            "b",
            "a",
            "c",
            "c",
            "c",
            "a",
            "b",
            "a"
    };

    static int[] imageArray = {
            R.drawable.eurovision,
            R.drawable.sergiu_nicolaescu,
            R.drawable.europa_fluviu,
            R.drawable.champions_league,
            R.drawable.capitale,
            R.drawable.primul_razboi_mondial,
            R.drawable.regele_mihai_regina_ana,
            R.drawable.trupa_taxi,
            R.drawable.florin_piersic,
            R.drawable.prima_noapte_de_razboi
    };


    ImageView imageView_images;

    TextView textView_question;

    TextView textView_answer_A, textView_answer_B, textView_answer_C;
    TextView textView_scorCorect, textView_scorIncorect;

    Button button_answer_A, button_answer_B, button_answer_C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        init();

        setQuestionText(count);
    }

    private void init() {

        scorIncorect = 0;
        scorCorect = 0;
        count = 0;

        context = QuizActivity.this;

        textView_scorCorect = (TextView) findViewById(R.id.textView_quiz_scorCorect);
        textView_scorIncorect = (TextView) findViewById(R.id.textView_quiz_scorInorect);

        textView_question = (TextView) findViewById(R.id.textView_quiz_question);

        imageView_images = (ImageView) findViewById(R.id.imageView_quiz_images);

        textView_answer_A = (TextView) findViewById(R.id.textView_answer_A);
        button_answer_A = (Button) findViewById(R.id.button_quiz_A);
        button_answer_A.setOnClickListener(this);

        textView_answer_B = (TextView) findViewById(R.id.textView_answer_B);
        button_answer_B = (Button) findViewById(R.id.button_quiz_B);
        button_answer_B.setOnClickListener(this);

        textView_answer_C = (TextView) findViewById(R.id.textView_answer_C);
        button_answer_C = (Button) findViewById(R.id.button_quiz_C);
        button_answer_C.setOnClickListener(this);

    }

    private void setQuestionText(int questionIndex) {

        if(questionIndex >= answerArray.length) {
            return;
        }

        textView_question.setText(questionArray[questionIndex]);

        imageView_images.setBackgroundResource(imageArray[questionIndex]);

        switch (questionIndex) {
            case 0:
                textView_answer_A.setText(R.string.answer_1_A);
                textView_answer_B.setText(R.string.answer_1_B);
                textView_answer_C.setText(R.string.answer_1_C);
                break;
            case 1:
                textView_answer_A.setText(R.string.answer_2_A);
                textView_answer_B.setText(R.string.answer_2_B);
                textView_answer_C.setText(R.string.answer_2_C);
                break;
            case 2:
                textView_answer_A.setText(R.string.answer_3_A);
                textView_answer_B.setText(R.string.answer_3_B);
                textView_answer_C.setText(R.string.answer_3_C);
                break;
            case 3:
                textView_answer_A.setText(R.string.answer_4_A);
                textView_answer_B.setText(R.string.answer_4_B);
                textView_answer_C.setText(R.string.answer_4_C);
                break;
            case 4:
                textView_answer_A.setText(R.string.answer_5_A);
                textView_answer_B.setText(R.string.answer_5_B);
                textView_answer_C.setText(R.string.answer_5_C);
                break;
            case 5:
                textView_answer_A.setText(R.string.answer_6_A);
                textView_answer_B.setText(R.string.answer_6_B);
                textView_answer_C.setText(R.string.answer_6_C);
                break;
            case 6:
                textView_answer_A.setText(R.string.answer_7_A);
                textView_answer_B.setText(R.string.answer_7_B);
                textView_answer_C.setText(R.string.answer_7_C);
                break;
            case 7:
                textView_answer_A.setText(R.string.answer_8_A);
                textView_answer_B.setText(R.string.answer_8_B);
                textView_answer_C.setText(R.string.answer_8_C);
                break;
            case 8:
                textView_answer_A.setText(R.string.answer_9_A);
                textView_answer_B.setText(R.string.answer_9_B);
                textView_answer_C.setText(R.string.answer_9_C);
                break;
            case 9:
                textView_answer_A.setText(R.string.answer_10_A);
                textView_answer_B.setText(R.string.answer_10_B);
                textView_answer_C.setText(R.string.answer_10_C);
                break;
        }
    }

    @Override
    public void onClick(View view) {

        if(questionArray.length <= count) {
            Toast.makeText(context, String.format(getString(R.string.final_message), scorCorect), Toast.LENGTH_SHORT).show();
            return;
        }

        switch (view.getId()) {
            case R.id.button_quiz_A:
                checkAnswer("a");
                break;

            case R.id.button_quiz_B:
                checkAnswer("b");
                break;

            case R.id.button_quiz_C:
                checkAnswer("c");
                break;
        }

    }

    public void checkAnswer(String value) {

        if(value.equals(answerArray[count])) {
            Log.i("Response", "Corect");
            textView_scorCorect.setText(String.valueOf(++scorCorect));
            notifyUser(true);
        } else {
            Log.i("Response", "Incorect");
            textView_scorIncorect.setText(String.valueOf(++scorIncorect));
            notifyUser(false);
        }

    }

    private void notifyUser(boolean response) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.response_title);

        if(response) {
            builder.setMessage(R.string.correct_message);
            builder.setIcon(R.drawable.corect);
        } else {
            builder.setMessage(String.format(getString(R.string.incorrect_message), answerArray[count]));
            builder.setIcon(R.drawable.incorect);
        }

        builder.setPositiveButton(R.string.next_question, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setQuestionText(++count);
                dialogInterface.dismiss();
            }
        });

        builder.setCancelable(false);

        builder.show();
    }

}
