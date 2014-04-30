package ws.otero.adrian.register.model;

import java.util.ArrayList;
import java.util.List;

public class Cart
{
   private List<Item> items = new ArrayList<Item>();
   private List<Offer> offers = new ArrayList<Offer>();

   public void addItem ( Item item )
   {
      items.add( item );
   }

   public List<Item> getItems()
   {
      return items;
   }

   public void addOffer ( Offer offer )
   {
      offers.add( offer );
   }

   public double calculatePrice ()
   {
      double finalPrice = 0;
      for( Item item : items )
      {
         finalPrice += item.getPrice();
      }
      for( Offer offer : offers )
      {
         finalPrice -= offer.calculateDiscount( this );
      }

      return finalPrice;
   }
}
