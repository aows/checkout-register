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

   public List<Item> getItems ()
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

   public String explainCart ()
   {
      double price = 0, discount;
      StringBuilder sb = new StringBuilder();
      for( Item item : items )
      {
         sb.append( item.getCode() )
            .append( " - " )
            .append( item.getName() )
            .append( "\t\t" )
            .append( "$" + item.getPrice() )
            .append( "\r\n" );
         price += item.getPrice();
      }
      sb.append( "----------------\r\n" )
         .append( "subtotal\t\t" )
         .append( "$" + price )
         .append( "\r\n" );
      for( Offer offer : offers )
      {
         discount = offer.calculateDiscount( this );
         if( discount > 0 )
         {
            sb.append( "----------------\r\n" )
               .append( offer.getDescription() + "\r\n" )
               .append( offer.getProduct().getName() + "\t\t" )
               .append( "-$" + discount )
               .append( "\r\n\r\n" );
            price -= discount;
         }
      }
      sb.append( "----------------\r\n" )
         .append( "total\t\t" )
         .append( "$" + price )
         .append( "\r\n" );
      sb.append( "----------------\r\n\r\n" )
         .append( "THANKS FOR YOUR VISIT" );
      return sb.toString();
   }
}
