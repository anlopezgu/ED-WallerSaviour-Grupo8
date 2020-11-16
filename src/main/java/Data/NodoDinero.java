/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/*
 *
 * @author ANDRES
 */
public class NodoDinero {
    String amount;
    String kind;
    String fecha;
    NodoDinero previous = null;
    NodoDinero next = null;

    public String getAmount() {
        return amount;
    }

    
    public String getKind() {
        return kind;
    }

    public String getFecha() {
        return fecha;
    }

    public NodoDinero(String amount,String kind,String fecha) {
        this.amount = amount;
        this.kind = kind;
        this.fecha = fecha;
    }
    
    
    
}
