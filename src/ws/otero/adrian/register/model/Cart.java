package ws.otero.adrian.register.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements features for a basic shopping cart.
 *
 * You can add items and offers, then calculate the final price and get a ticket with all the results.
 *
 * @author Adrian Otero
 */
public class Cart
{
   private List<Item> items = new ArrayList<Item>();
   private List<Offer> offers = new ArrayList<Offer>();

   /**
    * @param item item to be added to the cart
    * @see Item
    */
   public void addItem ( Item item )
   {
      items.add( item );
   }

   /**
    * @return current items added to the cart
    * @see Item
    */
   public List<Item> getItems ()
   {
      return items;
   }

   /**
    * @param offer offer to apply to the items
    * @see Offer
    */
   public void addOffer ( Offer offer )
   {
      offers.add( offer );
   }

   /**
    * Calculates the final price of the current items and offers
    *
    * @return final price
    */
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

   /**
    * Generates a ticket
    *
    * @return the final result in a ticket-life format
    */
   public String explainCart ()
   {
      double price = 0, discount;
      StringBuilder sb = new StringBuilder();

      for( Item item : items )
      {
         // we could build this line using "+" or like here, using multiple appends.
         // the java compiler would convert the former to append calls
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
