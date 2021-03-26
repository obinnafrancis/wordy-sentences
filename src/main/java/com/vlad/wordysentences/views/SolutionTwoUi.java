package com.vlad.wordysentences.views;

import com.google.gson.Gson;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vlad.wordysentences.models.*;
import com.vlad.wordysentences.services.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("solution2")
public class SolutionTwoUi extends VerticalLayout {
    @Autowired
    TimeSheetService timeSheetService;

    public SolutionTwoUi(){

        this.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
        HorizontalLayout viewHor = new HorizontalLayout();
        viewHor.setMargin(true);
        Label word = new Label("Solution Two");
        word.getStyle().set("display","block");
        word.getStyle().set("text-decoration","underline");
        word.getStyle().set("font-weight","bolder");
        add(word);

//        Div viewCustomers = new Div();
//        Label idLabel = new Label("Please Enter Customer id");
//        TextField id = new TextField();
//        Button fetch = new Button("Save");
//        fetch.addThemeNames(Lumo.DARK);
//        Label fetchOut = new Label();
//        fetchOut.setVisible(false);
//        viewCustomers.add(idLabel,id,fetch,fetchOut);
//        add(viewCustomers);
//
//        fetch.addClickListener(buttonClickEvent -> {
//            Customer customer = timeSheetService.createCustomer(Integer.parseInt(id.getValue()));
//            fetchOut.setText("Output: "+new Gson().toJson(customer));
//            fetchOut.setVisible(true);
//        });

        Div createCustomer = new Div();
        createCustomer.setWidth("33.3%");
        Label cr = new Label("CREATE CUSTOMER SECTION");
        cr.getStyle().set("display","block");
        cr.getStyle().set("font-weight","bolder");
        cr.getStyle().set("text-align","center");
        cr.getStyle().set("bottom-margin","20%");
        Label customerName = new Label("Please Enter Customer Name");
        customerName.getStyle().set("display","block");
        customerName.getStyle().set("font-weight","bolder");
        TextField nameText = new TextField();
        nameText.getStyle().set("display","block");
        Button saveCustomer = new Button("Save");
        saveCustomer.addThemeNames(Lumo.DARK);
        Label customerOutput = new Label();
        customerOutput.getStyle().set("display","block");
        customerOutput.setVisible(false);
        createCustomer.add(cr,customerName,nameText,saveCustomer,customerOutput);
//        add(createCustomer);



        Div createStaff = new Div();
        createStaff.setWidth("33.3%");
        Label cS = new Label("CREATE STAFF SECTION");
        cS.getStyle().set("display","block");
        cS.getStyle().set("font-weight","bolder");
        cS.getStyle().set("text-align","center");
        cS.getStyle().set("bottom-margin","20%");
        Label staffLabel = new Label("Please Enter Staff First Name");
        staffLabel.getStyle().set("display","block");
        staffLabel.getStyle().set("font-weight","bolder");
        TextField staffFirstName = new TextField();
        staffFirstName.getStyle().set("display","block");
        Label staffLabel2 = new Label("Please Enter Staff Last Name");
        staffLabel2.getStyle().set("display","block");
        staffLabel2.getStyle().set("font-weight","bolder");
        TextField staffLastName = new TextField();
        staffLastName.getStyle().set("display","block");
        Label customerIDLabel = new Label("Please Enter Customer ID the Staff Belongs to");
        customerIDLabel.getStyle().set("display","block");
        customerIDLabel.getStyle().set("font-weight","bolder");
        TextField customerId = new TextField();
        customerId.getStyle().set("display","block");
        Button saveStaff = new Button("Save Staff");
        saveStaff.addThemeNames(Lumo.DARK);
        Label staffOutPut = new Label();
        staffOutPut.getStyle().set("display","block");
        staffOutPut.setVisible(false);
        createStaff.add(cS,staffLabel,staffFirstName,staffLabel2,staffLastName,customerIDLabel,customerId,saveStaff,staffOutPut);
//        add(createStaff);



        Div logTime = new Div();
        logTime.setWidth("33.3%");
        Label lg = new Label("LOG TIMESHEET SECTION");
        lg.getStyle().set("display","block");
        lg.getStyle().set("font-weight","bolder");
        lg.getStyle().set("text-align","center");
        lg.getStyle().set("bottom-margin","20%");
        Label staffIdLabel = new Label("StaffId:");
        staffIdLabel.getStyle().set("display","block");
        staffIdLabel.getStyle().set("font-weight","bolder");
        TextField staffId = new TextField();
        staffId.getStyle().set("display","block");
        Button log = new Button("Save Staff");
        log.addThemeNames(Lumo.DARK);
        Label logOutput = new Label();
        logOutput.getStyle().set("display","block");
        logOutput.setVisible(false);
        logTime.add(lg,staffIdLabel,staffId,log,logOutput);
//        add(logTime);
        viewHor.add(createCustomer,createStaff,logTime);
        add(viewHor);

        saveCustomer.addClickListener(buttonClickEvent -> {
            Customer customer = timeSheetService.createCustomer(new CreateCustomerRequest(nameText.getValue()));
            customerOutput.setText("Output: customer "+customer.getName()+" was created with ID"+ customer.getId());
            customerOutput.setVisible(true);
        });

        saveStaff.addClickListener(buttonClickEvent -> {
            Staff staff = timeSheetService.createStaff(new CreateStaffRequest(staffFirstName.getValue(),staffLastName.getValue(),customerId.getValue()));
            staffOutPut.setText(new Gson().toJson(staff));
            staffOutPut.setVisible(true);
        });

        log.addClickListener(buttonClickEvent -> {
            TimeLog timeLog = timeSheetService.logTime(new CreateLogRequest(staffId.getValue()));
            logOutput.setText(new Gson().toJson(timeLog));
            logOutput.setVisible(true);
        });

    }
}
