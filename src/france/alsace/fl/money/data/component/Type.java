/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.component;

/**
 *
 * @author Florent
 */
public class Type {
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Type {")
                .append("id->").append(id)
                .append(", text->").append(text)
                .append("}")
                .toString();
    }
}
