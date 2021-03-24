package com.vlad.wordysentences;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Route("")
public class BaseUi extends VerticalLayout {
    @Autowired
    private BusinessLogicService businessLogicService;
    Map<String,String> result = new HashMap<>();

    public BaseUi(){

        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Label word = new Label("Please enter a Word:");
        TextField wordText = new TextField(); // textfield for word argument
        add(word,wordText);

        Label sentence = new Label("Please enter a Sentence:");
        TextArea sentenceText = new TextArea(); // text area for sentence argument
        add(sentence,sentenceText);

        Button execute = new Button("Execute"); // process inputs
        Button clear = new Button("Clear"); // reset button
        clear.setEnabled(false);

        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(clear,execute);
        add(buttonGroup);

        Label output = new Label("Output:");
        output.setVisible(false);
        add(output);

        execute.addClickListener(click-> {
            result = businessLogicService.processData(wordText.getValue(), sentenceText.getValue());
            output.add(" "+result.toString());
            output.setVisible(true);
            clear.setEnabled(true);
        });

        clear.addClickListener(click-> {
            wordText.setValue("");
            sentenceText.setValue("");
            businessLogicService.reset();
            result = new HashMap<>();
            output.setVisible(false);
            clear.setEnabled(false);
        });
    }
}
