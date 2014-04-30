package ws.otero.adrian.register.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores the current catalog of products. Everything is static so we'll have just one catalog.
 *
 * @author Adrian Otero
 */
public class Catalog
{

   private Catalog ()
   {
   }

   private static Map<String, Item> items = new HashMap<String, Item>();

   /**
    * Adds one item to the catalog
    *
    * @param code this will be used to retrieve the product later calling {@link #searchItem(String)}
    * @param item item to add to the catalog
    * @see Item
    */
   public static void addItem (
      String code,
      Item item )
   {
      items.put( code, item );
   }

   /**
    * Looks for a product with the given code
    *
    * @param code code of the product we are looking for
    * @return the item as it is in the catalog
    * @see Item
    */
   public static Item searchItem ( String code )
   {
      return items.get( code );
   }

   /**
    * Initializes the catalog from a file
    *
    * @param csvFile
    */
   public static void initFromFile ( String csvFile )
   {
      BufferedReader br = null;
      String line;
      String separator = ",";

      try
      {
         br = new BufferedReader( new FileReader( csvFile ) );
         while( ( line = br.readLine() ) != null )
         {
            String[] values = line.split( separator );
            Catalog.addItem( values[ 0 ], new Item( values[ 0 ], values[ 1 ], Double.parseDouble( values[ 2 ] ) ) );
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
