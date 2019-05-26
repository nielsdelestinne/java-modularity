package javamodularity.easytext.cli;

import javamodularity.easytext.analysis.FleschKincaid;

public class Main {

    public static void main(String[]args){
        var text = "This is why i'm old. Old. oldè";
        var textAnalysis = new FleschKincaid();
        var score = textAnalysis.performAnalysis(text);
        System.out.println(score);
    }

}