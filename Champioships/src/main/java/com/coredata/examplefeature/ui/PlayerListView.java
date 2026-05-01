package com.coredata.examplefeature.ui;

import com.coredata.backend.dto.PlayerListItem;
import com.coredata.backend.service.PlayerService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("players")
@PageTitle("Player List")
@Menu(order = 1, icon = "vaadin:users", title = "Player List")
public class PlayerListView extends VerticalLayout {
    PlayerListView(PlayerService playerService) {

        var searchField = new TextField();
        searchField.setPlaceholder("Search by name");
        searchField.setPrefixComponent(VaadinIcon.SEARCH.create());
        searchField.setValueChangeMode(ValueChangeMode.LAZY);

        var grid = new Grid<PlayerListItem>();
        grid.addColumn(PlayerListItem::id).setHeader("ID").setAutoWidth(true);
        grid.addColumn(PlayerListItem::name).setHeader("Name").setAutoWidth(true).setSortProperty(PlayerListItem.SORT_PROPERTY_NAME);
        grid.addColumn(PlayerListItem::dob).setHeader("Date Of Birth").setAutoWidth(true);
        grid.setItemsPageable(pageable -> playerService.findPlayers(pageable, searchField.getValue()).getContent());

        searchField.addValueChangeListener(e -> grid.getDataProvider().refreshAll());



        setSizeFull();
        grid.setSizeFull() ;
        add(searchField);
        add(grid);
    }
}
