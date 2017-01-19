package ro.quiz;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    ViewPager viewPager_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        init();
    }

    private void init() {
        viewPager_quiz = (ViewPager) findViewById(R.id.viewPager_quiz_images);

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, populateImageArray());
        viewPager_quiz.setAdapter(adapterViewPager);
    }

    private int[] populateImageArray() {
        int[] imageArray = {

        } ;

        return imageArray;
    }

    private int[] populateQuestionArray() {
        int[] questionArray = {

        };

        return questionArray;
    }
}
