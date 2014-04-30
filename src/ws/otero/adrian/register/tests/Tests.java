package ws.otero.adrian.register.tests;

import ws.otero.adrian.register.model.Cart;
import ws.otero.adrian.register.model.Catalog;
import ws.otero.adrian.register.model.OfferXforY;

public class Tests
{

   public static void main ( String[] args )
   {
      Tests test = new Tests();
      Catalog.initFromFile( "catalog.csv" );

      if( test.checkOffers() )
      {
         System.out.println( "Test checkOffers passed" );
      }
      else
      {
         System.out.println( "Test checkOffers failed" );
      }

      if( test.checkWithoutOffer() )
      {
         System.out.println( "Test checkWithoutOffer passed" );
      }
      else
      {
         System.out.println( "Test checkWithoutOffer failed" );
      }

   }

   private boolean checkOffers ()
   {
      Cart cart = new Cart();
      cart.addOffer( new OfferXforY( Catalog.searchItem( "B" ), "Get 5 for 3", 3, 5 ) );

      cart.addItem( Catalog.searchItem( "A" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "A" ) )
         .addItem( Catalog.searchItem( "C" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "A" ) )
         .addItem( Catalog.searchItem( "B" ) );

      return cart.calculatePrice() == 240;
   }

   private boolean checkWithoutOffer ()
   {
      Cart cart = new Cart();

      cart.addItem( Catalog.searchItem( "A" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "A" ) )
         .addItem( Catalog.searchItem( "C" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "B" ) )
         .addItem( Catalog.searchItem( "A" ) )
         .addItem( Catalog.searchItem( "B" ) );

      return cart.calculatePrice() == 240;
   }

}
