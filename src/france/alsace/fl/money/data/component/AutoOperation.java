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
public class AutoOperation {
    private int id;
    private double amount;
    private String description;
    private Date dateAction;
    private String comment;
    @AutoJoin(true)
    private Type type;
    @AutoJoin(true)
    private Subtype subtype;
    @AutoJoin(true)
    private Period period;

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

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("AutoOperation {")
                .append("id->").append(id)
                .append(", amount->").append(amount)
                .append(", description->").append(description)
                .append(", dateAction->").append(dateAction)
                .append(", comment->").append(comment)
                .append(", type->[").append(type)
                .append("], subtype->[").append(subtype)
                .append("], period->[").append(period)
                .append("]}")
                .toString();
    }
}
