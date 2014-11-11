/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.component;

import france.alsace.fl.money.data.utils.annotation.AutoJoin;

/**
 *
 * @author Florent
 */
public class Subtype {
    
    private int id;
    private String text;
    
    @AutoJoin
    private Type type;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Subtype {")
                .append("id->").append(id)
                .append(", text->").append(text)
                .append(", type->[").append(type)
                .append("]}")
                .toString();
    }
    
}
