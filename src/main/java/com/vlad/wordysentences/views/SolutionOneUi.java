package com.vlad.wordysentences.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vlad.wordysentences.services.WordSentenceService;
import com.vlad.wordysentences.models.Report;
import org.springframework.beans.factory.annotation.Autowired;

@Route("solution1")
public class SolutionOneUi extends VerticalLayout {

    @Autowired
    private WordSentenceService wordSentenceService;
    Report result = new Report();

    public SolutionOneUi(){


        this.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
        Label word = new Label("Please enter a Word:");
        word.getStyle().set("font-weight","bolder");
        TextField wordText = new TextField(); // textfield for word argument
        add(word,wordText);

        Label sentence = new Label("Please enter a Sentence:");
        sentence.getStyle().set("font-weight","bolder");
        TextArea sentenceText = new TextArea(); // text area for sentence argument
        add(sentence,sentenceText);

        Button execute = new Button("Execute"); // process inputs
        execute.addThemeNames(Lumo.DARK);
        Button clear = new Button("Clear"); // reset button
        clear.setEnabled(false);

        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(clear,execute);
        add(buttonGroup);

        Label output = new Label("Output:");
        output.setVisible(false);
        add(output);

        execute.addClickListener(click-> {
            result = wordSentenceService.processData(wordText.getValue(), sentenceText.getValue());
            output.add(" "+result.toString());
            output.setVisible(true);
            clear.setEnabled(true);
        });

        clear.addClickListener(click-> {
            wordText.setValue("");
            sentenceText.setValue("");
            wordSentenceService.reset();
            result = new Report();
            output.removeAll();
            output.setVisible(false);
            clear.setEnabled(false);
        });
    }
}
