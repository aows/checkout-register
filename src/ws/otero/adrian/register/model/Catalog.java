package ws.otero.adrian.register.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Catalog
{

   private static Catalog instance;

   private Catalog ()
   {
   }

   public static Catalog getCatalog ()
   {
      if( instance == null )
      {
         instance = new Catalog();
      }
      return instance;
   }

   private static Map<String, Item> items = new HashMap<String, Item>();

   public static Catalog addItem (
      String code,
      Item item )
   {
      items.put( code, item );
      return instance;
   }

   public static Item searchItem ( String code )
   {
      return items.get( code );
   }

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
