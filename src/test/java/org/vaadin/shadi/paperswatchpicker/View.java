package org.vaadin.shadi.paperswatchpicker;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div {

    public View() {
        getStyle().set("text-align", "center");
        VerticalLayout verticalLayout = new VerticalLayout();
        PaperSwatchPicker colorPicker = new PaperSwatchPicker();
        Div colorDiv = new Div();
        colorDiv.setWidth("160px");
        colorDiv.setHeight("90px");
        System.out.print("Sh " + colorPicker.getColor());
        colorPicker.addColorChangedListener(event -> colorDiv.getStyle()
                .set("background-color", event.getColor()));
        verticalLayout.add(colorDiv);

        add(colorPicker);

        Div enterColordiv = new Div();
        TextField enterColor = new TextField("Enter color");
        Button enterCollorButton = new Button("Set color", event -> {
            colorPicker.setColor(enterColor.getValue());
        });
        enterColordiv.add(enterColor, enterCollorButton);
        verticalLayout.add(enterColordiv);

        Button colorListButton = new Button("Set color list", event -> {
            String[] colorList = { "#008000", "#00FFFF", "#0000FF", "#f28eff",
                    "#a9fb0c", "#f63a13", "#fdaa60", "#6200e1", "#8d7ff7",
                    "#bec518" };
            colorPicker.setColorList(colorList);

        });
        verticalLayout.add(colorListButton);

        Div countColumnDiv = new Div();
        TextField countColumnTextField = new TextField("Enter column count");
        Button countColumnButton = new Button("set column count", event -> {
            colorPicker.setColumnCount(
                    Integer.valueOf(countColumnTextField.getValue()));
        });

        countColumnDiv.add(countColumnTextField, countColumnButton);
        verticalLayout.add(countColumnDiv);

        Select<HorizontalAlignment> horizontalSelect = new Select();
        horizontalSelect.setLabel("Select horizontal alignment");
        horizontalSelect.setItems(HorizontalAlignment.values());
        Div horizontalDiv = new Div();
        Button horizontalButton = new Button("set horizontal alignment",
                event -> {
                    colorPicker.setHorizontalAlign(horizontalSelect.getValue());
                });

        horizontalDiv.add(horizontalSelect, horizontalButton);
        verticalLayout.add(horizontalDiv);

        Select<VerticalAlignment> verticalSelect = new Select();
        verticalSelect.setLabel("Select vertical alignment");
        verticalSelect.setItems(VerticalAlignment.values());
        Div verticalDiv = new Div();
        Button verticalButton = new Button("set vertical alignment", event -> {
            colorPicker.setVerticalAlign(verticalSelect.getValue());
        });

        verticalDiv.add(verticalSelect, verticalButton);
        verticalLayout.add(verticalDiv);

        Button IconButton = new Button("Set icon", event -> {
            colorPicker.setIcon("swatch:none");
        });

        verticalLayout.add(IconButton);

        Button inkButton = new Button("Toggle no ink", event -> {
            colorPicker.setNoink(!colorPicker.getNoink());
        });

        verticalLayout.add(inkButton);

        add(verticalLayout);
    }
}
