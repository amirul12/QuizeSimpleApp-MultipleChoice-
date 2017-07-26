package com.edupointbd.amirul.quizeappsdemo;

/**
 * Created by amirul on 26-Jul-17.
 * www.edupointbd.com
 */

public class QuestionBank {

    //array of question

    private  String textQuestion[] = {
            "The data type created by the data abstraction process is called",
            "Encapsulation is ",
            "Which of the following language support garbage collection ?",
            "Which is not the feature of structured programming?  ",
            "Procedural programming language is "
        };

    // multiple choise for each question

    private String multipleChoice[][]= {
            {"class", "structure", "abstract data type", "User-defined data type"},
            {"dynamic binding", "a mechanism to associate the code and data", "data abstraction", "none of these"},
            {"Java", "C++", "C", "Small Talk"},
            {"Support for modular programming", "User-defined data types", "Emphasis on algorithm", "Data abstraction"},
            {"COBOL", "BASICS", "C++", "PASCAL"},

    };

    // arraqy of correct question answer
    private String mCorrectAnswer[] = {"abstract data type", "a mechanism to associate the code and data", "Java", "Data abstraction","COBOL"};

    //method for get number of question
    public int getLength(){
        return textQuestion.length;
    }

    public String getQuestion(int a){

        String question = textQuestion[a];
        return question;
    }

    //return single multiple choice item int list 1 2 3 4 as an argument
    public String getChoice(int index, int num){
        String choice = multipleChoice[index][num-1];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }



}
