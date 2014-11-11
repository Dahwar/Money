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
public class Account {
    
    private int id;
    private String number;
    private String name;
    
    @AutoJoin
    private Bank bank;
    
    private String owner;
    private double amount;
    private Date creationDate;
    private String comment;
    private boolean open;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Account {")
                .append("id->").append(id)
                .append(", number->").append(number)
                .append(", name->").append(name)
                .append(", bank->[").append(bank)
                .append("]), owner->").append(owner)
                .append(", amount->").append(amount)
                .append(", creationDate->").append(creationDate)
                .append(", comment->").append(comment)
                .append(", open->").append(open)
                .append("}")
                .toString();
    }
}
