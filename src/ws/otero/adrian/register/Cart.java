package ws.otero.adrian.register;

import java.util.ArrayList;
import java.util.List;

public class Cart
{
   protected List<Item> items = new ArrayList<Item>();

   public void addItem ( Item item )
   {
      items.add( item );
   }

   public double calculatePrice ()
   {
      double finalPrice = 0;
      for( Item item : items )
      {
         finalPrice += item.getPrice();
      }

      return finalPrice;
   }
}
