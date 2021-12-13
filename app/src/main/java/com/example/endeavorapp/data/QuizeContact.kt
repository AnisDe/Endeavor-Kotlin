package com.example.endeavorapp.data
import android.provider.BaseColumns

public final class QuizeContact {

    public class QuestionTable: BaseColumns{
        final val TABLE_NAME: String ="quize_questions"
        final val COLUMN_QUESTION: String ="question"
        final val COLUMN_OPTION1 : String ="option1"
        final val COLUMN_OPTION2: String ="option2"
        final val COLUMN_OPTION3: String ="option3"
        final val COLUMN_OPTION4: String ="option4"
        final val COLUMN_ANSWER_NR: String ="answer_nr"
    }
}
