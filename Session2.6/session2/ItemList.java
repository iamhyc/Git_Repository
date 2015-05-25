/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package session2;

/**
 *
 * @author Mark
 */
public class ItemList {
    public String name;
    public int sum,outsum;
    public double price;
    public double proto;

    public ItemList(String nm, double price, int sum){
        this.name = nm;
        this.sum = sum;  this.outsum = 0;
        this.price = price; this.proto = price;
    }

    public int getsum(){
        return this.sum;
    }
    public int getoutsum(){
        return this.outsum;
    }
    public double getprice(){
        return this.price;
    }
    //各种 get method

}
