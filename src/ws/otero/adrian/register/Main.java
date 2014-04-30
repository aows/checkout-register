package ws.otero.adrian.register;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{

   public static void main ( String[] args )
   {
      // initialize catalog
      Catalog.initFromFile( "catalog.csv" );

      // create a new cart and add items to it
      Cart cart = new Cart();
      initCartFromFile( cart );

      System.out.println( "Total price: " + cart.calculatePrice() );
   }

   private static void initCartFromFile(Cart cart) {
      BufferedReader br = null;
      String line;

      try
      {
         br = new BufferedReader( new FileReader( "input.csv" ) );
         while( ( line = br.readLine() ) != null )
         {
            cart.addItem( Catalog.searchItem( line ) );
         }
      }
      catch( FileNotFoundException e )
      {
         e.printStackTrace();
      }
      catch( IOException e )
      {
         e.printStackTrace();
      }
      finally
      {
         if( br != null )
         {
            try
            {
               br.close();
            }
            catch( IOException e )
            {
               e.printStackTrace();
            }
         }
      }
   }

}
