package org.vaadin.shadi.paperswatchpicker;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("color-picker-selected")
public class ColorChangedEvent extends ComponentEvent<PaperSwatchPicker> {

    private String color;

    public ColorChangedEvent(PaperSwatchPicker source, boolean fromClient,
            @EventData("element.color") String color) {
        super(source, fromClient);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}