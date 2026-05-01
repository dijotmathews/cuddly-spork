package com.coredata.examplefeature.ui.forms;

import com.coredata.backend.service.PlayerService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PlayerForm extends Composite<HorizontalLayout> {
    final TextField firstname;
    final TextField lastname;
    final Button createBtn;
    final DatePicker dob;

    private final PlayerService playerService;
    public PlayerForm(PlayerService playerService) {

        this.playerService = playerService;

        var layout = getContent();
        layout.setWidthFull();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        layout.setSpacing(true);

        firstname = new TextField();
        firstname.setPlaceholder("First Name");
        firstname.setRequired(true);
        firstname.setAriaLabel("First Name");
        firstname.setWidthFull();

        lastname = new TextField();
        lastname.setPlaceholder("Last Name");
        lastname.setAriaLabel("Last Name");
        lastname.setWidthFull();
        lastname.setRequired(true);

        dob = new DatePicker();
        dob.setPlaceholder("Dote Of Birth");
        dob.setAriaLabel("Date Of Birth");
        dob.setWidthFull();
        dob.setRequired(true);

        createBtn = new Button("Create", event -> createPlayer());
        createBtn.addThemeVariants(ButtonVariant.PRIMARY);

        layout.add(firstname, lastname,dob, createBtn);
        layout.setFlexGrow(1, firstname, lastname);
    }

    private void createPlayer() {
        if(firstname.getValue().isBlank()) {
            firstname.setInvalid(true);
            firstname.setErrorMessage("First Name is required");
            return;
        }

        if(lastname.getValue().isBlank()) {
            lastname.setInvalid(true);
            lastname.setErrorMessage("Last Name is required");
            return;
        }

        if(dob.getValue() == null) {
            dob.setInvalid(true);
            dob.setErrorMessage("Date Of Birth is required");
            return;
        }

        playerService.createPlayer(firstname.getValue(), lastname.getValue(), dob.getValue());
        firstname.clear();
        lastname.clear();
        dob.clear();

        Notification.show("Player added", 3000, Notification.Position.BOTTOM_END)
                .addThemeVariants(NotificationVariant.SUCCESS);


    }

}
