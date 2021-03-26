package com.vlad.wordysentences.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
public class BaseUi extends VerticalLayout {

    public BaseUi(){
        this.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
        HorizontalLayout view = new HorizontalLayout();
        view.setMargin(true);
        view.getStyle().set("margin-top","25%");
        view.getStyle().set("margin-left","20%");
        view.getStyle().set("margin-right","20%");
        view.getStyle().set("text-align",Alignment.CENTER.name());
        Div leftDiv = new Div();
        leftDiv.setWidth("50%");
        Label questionOneHeader = new Label("Question One");
        questionOneHeader.getStyle().set("text-decoration","underline");
        questionOneHeader.getStyle().set("display","block");
        questionOneHeader.getStyle().set("font-weight","bolder");
        Label questionOne = new Label("You will create a simple application that will take in 2 Argument SENTENCE and WORD\n" +
                "\n" +
                "SENTENCE is string of multiple words \n" +
                "\n" +
                "WORD is a string\n" +
                "\n" +
                "A. The SENTENCE should take maximum of 30 Words and minimum of 5 word  \n" +
                "\n" +
                "if not return Count of Words in SENTENCE\n" +
                "\n" +
                "B. Each Words Should not be greater than 8 character if a word in SENTENCE is higher than 8\n" +
                "\n" +
                "return the  word that failed the test and the count position of that word in the SENTENCE\n" +
                "\n" +
                " \n" +
                "\n" +
                "C. WORD Should not be greater than 8 character if not return Error\n" +
                "\n" +
                "D Output Should be the following \n" +
                "\n" +
                " \n" +
                "\n" +
                "i. Total Count of WORD in SENTENCE\n" +
                "\n" +
                "ii.  Total Vowels and consonants in WORD\n" +
                "\n" +
                "iii. Lengths of the Largest word in SENTENCE\n" +
                "\n" +
                "iv.  Lengths of the smallest word in SENTENCE");
        questionOne.getStyle().set("display","block");
        questionOne.getStyle().set("text-align","justify");
        NativeButton v1 = new NativeButton("View"); // process inputs
        v1.addClickListener(buttonClickEvent -> {
            v1.getUI().ifPresent(ui -> ui.navigate("solution1"));
        });
        leftDiv.add(questionOneHeader,questionOne,v1);


        Div rightDiv = new Div();
        rightDiv.setWidth("50%");
        Label questionTwoHeader = new Label("Question Two");
        questionTwoHeader.getStyle().set("text-decoration","underline");
        questionTwoHeader.getStyle().set("display","block");
        questionTwoHeader.getStyle().set("font-weight","bolder");
        Label questionTwo = new Label("Create a Simple timesheet application Using sqllite. The system should be able to achieve the following\n" +
                "\n" +
                "a.     Add a Customer\n" +
                "\n" +
                "b.     Add Staffs of the customer\n" +
                "\n" +
                "c.     Add a timestamp of customers everyday on resume and exit of work.\n" +
                "\n" +
                "Kindly build the system architecture as minimum details are given.");
        questionTwo.getStyle().set("display","block");
        questionTwo.getStyle().set("text-align","justify");
        NativeButton v2 = new NativeButton("View"); // process inputs
        v2.addClickListener(buttonClickEvent -> {
            v2.getUI().ifPresent(ui -> ui.navigate("solution2"));
        });
        rightDiv.add(questionTwoHeader,questionTwo,v2);

        view.add(leftDiv,rightDiv);
        add(view);
    }
}
