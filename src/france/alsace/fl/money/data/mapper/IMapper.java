/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper;

import java.sql.ResultSet;

/**
 *
 * @author Florent
 */
public interface IMapper<T> {
    public T map(ResultSet rs);
}
