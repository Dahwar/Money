/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.utils;

/**
 *
 * @author Florent
 */
public class RequestBuilder {
    
    private String request = null;
    private String separator = null;
    
    public RequestBuilder() {
        this.request = "";
        this.separator = ":";
    }
    
    public RequestBuilder(String separator) {
        this.request = "";
        this.separator = separator;
    }
    
    public RequestBuilder(String request, String separator) {
        this.request = request;
        this.separator = separator;
    }
    
    public void append(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.request);
        sb.append(s);
        this.request = sb.toString();
    }
    
    public void clear() {
        this.request = "";
    }
    
    public void setParameter(String parameter, String value) {
        this.request = this.request.replace(this.separator + parameter, "'"+value+"'");
    }
    
    public void setParameterWithoutQuote(String parameter, String value) {
        this.request = this.request.replace(this.separator + parameter, value);
    }
    
    public void setParameter(String parameter, int value) {
        this.request = this.request.replace(this.separator + parameter, Integer.toString(value));
    }
    
    public void setParameter(String parameter, double value) {
        this.request = this.request.replace(this.separator + parameter, Double.toString(value));
    }
    
    public void setParameter(String parameter, boolean value) {
        this.request = this.request.replace(this.separator + parameter, Integer.toString((value)?1:0));
    }
    
    public String getSeparator() {
        return this.separator;
    }
    
    public void setSeparator(String separator) {
        this.separator = separator;
    }
    
    @Override
    public String toString() {
        return this.request;
    }
}
