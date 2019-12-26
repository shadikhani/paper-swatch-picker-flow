package org.vaadin.shadi.paperswatchpicker;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonString;

import java.io.Serializable;

@Tag("paper-swatch-picker")
@JsModule("@polymer/paper-swatch-picker/paper-swatch-picker.js")
@NpmPackage(value = "@polymer/paper-swatch-picker", version = "^3.0.1")
public class PaperSwatchPicker extends Component {

    /**
     * The selected color, as hex (i.e. #ffffff). value.
     * 
     * @return
     */
    public String getColor() {
        return getElement().getProperty("color");
    }

    public void setColor(String color) {
        getElement().setProperty("color", color);
    }

    public void setColorList(String[] colorList) {
        getElement().setPropertyJson("colorList", createJsonArray(colorList));
    }

    /**
     *
     * The colors to be displayed. By default, these are the Material Design
     * colors. This array is arranged by "generic color", so for example, all
     * the reds (from light to dark), then the pinks, then the blues, etc.
     * Depending on how many of these generic colors you have, you should update
     * the `columnCount` property.
     * 
     * @return
     */
    public String[] getColorList() {

        Serializable colorListValue = getElement().getPropertyRaw("colorList");

        if (colorListValue == null) {
            return null;
        }
        String[] value = createStringArray((JsonArray) (colorListValue));
        return value;
    }

    public PaperSwatchPicker() {
        addColorChangedListener(
                colorChangedEvent -> setColor(colorChangedEvent.getColor()));
    }

    public Registration addColorChangedListener(
            ComponentEventListener<ColorChangedEvent> listener) {
        return addListener(ColorChangedEvent.class, listener);
    }

    /**
     * The number of columns to display in the picker. This corresponds to the
     * number of generic colors (i.e. not counting the light/dark) variants of a
     * specific color) you are using in your `colorList`. For example, the
     * Material Design palette has 18 colors.
     * 
     * @return
     */
    public int getColumnCount() {
        return getElement().getProperty("columnCount", 18);
    }

    public void setColumnCount(int columnCount) {
        getElement().setProperty("columnCount", columnCount);
    }

    /**
     * The orientation against which to align the menu dropdown horizontally
     * relative to the dropdown trigger.
     * 
     * @return
     */
    public HorizontalAlignment getHorizontalAlign() {

        String value = getElement().getProperty("horizontalAlign",
                HorizontalAlignment.LEFT.toString());
        return HorizontalAlignment.valueOf(value.toUpperCase());
    }

    public void setHorizontalAlign(HorizontalAlignment value) {
        getElement().setProperty("horizontalAlign", value.toString());
    }

    /**
     * The orientation against which to align the menu dropdown vertically
     * relative to the dropdown trigger.
     * 
     * @return
     */
    public VerticalAlignment getVerticalAlign() {
        String value = getElement().getProperty("verticalAlign",
                VerticalAlignment.TOP.toString());
        return VerticalAlignment.valueOf(value.toUpperCase());
    }

    public void setVerticalAlign(VerticalAlignment value) {
        getElement().setProperty("verticalAlign", value.toString());
    }

    /**
     * The name of the icon to use for the button used as a dropdown trigger.
     * The name should be of the form: `iconset_name:icon_name`. You must
     * manually import the icon/iconset you wish you use.
     * 
     * @return
     */
    public String getIcon() {
        return getElement().getProperty("icon", "swatch:format-color-fill");
    }

    public void setIcon(String icon) {
        getElement().setProperty("icon", icon);
    }

    /**
     * If true, the color picker button will not produce a ripple effect when
     * interacted with via the pointer.
     * 
     * @return
     */
    public Boolean getNoink() {
        return getElement().getProperty("noink", true);
    }

    public void setNoink(Boolean noink) {
        getElement().setProperty("noink", noink);
    }

    private static JsonArray createJsonArray(String[] array) {
        JsonArray jsonArray = Json.createArray();
        for (int i = 0; i < array.length; ++i) {
            jsonArray.set(i, array[i]);
        }
        return jsonArray;
    }

    private static String[] createStringArray(JsonArray jsonArray) {
        String[] stringArray = new String[jsonArray.length()];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = ((JsonString) jsonArray.get(i)).getString();
        }
        return stringArray;
    }
}
