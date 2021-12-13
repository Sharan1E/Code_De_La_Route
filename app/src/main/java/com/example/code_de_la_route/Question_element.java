package com.example.code_de_la_route;

public class Question_element {

    private  boolean answer_1;
    private  boolean answer_2;
    private  boolean answer_3;
    private  boolean answer_4;
    private  boolean answer_5;
    private  boolean answer_6;
    private String questionnumber;
    private String questiontitle1;
    private String questiontitle2;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;

    public Question_element()
    {
        this.questionnumber = null;
        this.questiontitle1 = null;

        this.answer1 = null;
        this.answer2 = null;
        this.answer3 = null;
        this.answer4 = null;

        answer_1 = false;
        answer_2 = false;
        answer_3 = false;
        answer_4 = false;

        this.questiontitle2 = null;

        this.answer5 = null;
        this.answer6 = null;

        answer_5 = false;
        answer_6 = false;
    }

    public Question_element(String questionnumber, String questiontitle1, String answer1,
                            boolean answer_1, String answer2, boolean answer_2,
                            String answer3, boolean answer_3, String answer4, boolean answer_4)
    {
        this();
        this.questionnumber = questionnumber;
        this.questiontitle1 = questiontitle1;

        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;

        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;

    }

    public Question_element(String questionnumber,String questiontitle1,String answer1,
                            boolean answer_1,String answer2,boolean answer_2,String questiontitle2,
                            String answer5,boolean answer_5, String answer6,boolean answer_6) {

        this();
        this.questionnumber = questionnumber;
        this.questiontitle1 = questiontitle1;
        this.questiontitle2 = questiontitle2;

        this.answer1 = answer1;
        this.answer2 = answer2;

        this.answer5 = answer5;
        this.answer6 = answer6;

        this.answer_1 = answer_1;
        this.answer_2 = answer_2;

        this.answer_5 = answer_5;
        this.answer_6 = answer_6;
    }

    public Question_element(String questionnumber, String questiontitle1, String answer1,
                            boolean answer_1, String answer2, boolean answer_2,
                            String answer3, boolean answer_3)
    {
        this();
        this.questionnumber = questionnumber;
        this.questiontitle1 = questiontitle1;

        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;

        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
    }

    public Question_element(String questionnumber, String questiontitle1, String answer1,
                            boolean answer_1, String answer2, boolean answer_2)
    {
        this();
        this.questionnumber = questionnumber;
        this.questiontitle1 = questiontitle1;

        this.answer1 = answer1;
        this.answer2 = answer2;

        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
    }

    public String getQuestionNumber(){return questionnumber;}
    public void setQuestionNumber(String questionnumber){this.questionnumber = questionnumber;}

    public String getQuestionTitle1(){return questiontitle1;}
    public void setQuestionTitle(String questiontitle1){this.questiontitle1 = questiontitle1;}

    public String getQuestionTitle2(){return questiontitle2;}
    public void setQuestionTitle2(String questiontitle2){this.questiontitle2 = questiontitle2;}

    public String getAnswer1(){return answer1;}
    public void setAnswer1(String answer1){this.answer1 = answer1;}

    public String getAnswer2(){return answer2;}
    public void setAnswer2(String answer2){this.answer2 = answer2;}

    public String getAnswer3(){return answer3;}
    public void setAnswer3(String answer3){this.answer3 = answer3;}

    public String getAnswer4(){return answer4;}
    public void setAnswer4(String answer4){this.answer4 = answer4;}
    public String getAnswer5(){return answer5;}
    public void setAnswer5(String answer5){this.answer5 = answer5;}

    public String getAnswer6(){return answer6;}
    public void setAnswer6(String answer6){this.answer6 = answer6;}

    public boolean isAnswer1Correct(){return this.answer_1;}
    public boolean isAnswer2Correct(){return this.answer_2;}
    public boolean isAnswer3Correct(){return this.answer_3;}
    public boolean isAnswer4Correct(){return this.answer_4;}
    public boolean isAnswer5Correct(){return this.answer_5;}
    public boolean isAnswer6Correct(){return this.answer_6;}

}
