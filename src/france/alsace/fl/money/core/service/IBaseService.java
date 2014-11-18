/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service;

import java.util.List;

/**
 *
 * @author Florent
 */
public interface IBaseService<T> {
    public boolean save(T t);
    public T findById(int id);
    public List<T> getAll();
    public List<T> getAll(int number, int offset);
}
