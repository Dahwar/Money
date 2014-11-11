/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.component;

import france.alsace.fl.money.data.utils.annotation.AutoJoin;
import java.util.Date;

/**
 *
 * @author Florent
 */
public class Operation {
    
    private int id;
    private double amount;
    private String description;
    private Date date;
    private String comment;
    private boolean check;
    @AutoJoin(true)
    private Type type;
    @AutoJoin(true)
    private Subtype subtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Subtype getSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Operation {")
                .append("id->").append(id)
                .append(", amount->").append(amount)
                .append(", description->").append(description)
                .append(", date->").append(date)
                .append(", comment->").append(comment)
                .append(", check->").append(check)
                .append(", type->[").append(type)
                .append("], subtype->[").append(subtype)
                .append("]}")
                .toString();
    }
}