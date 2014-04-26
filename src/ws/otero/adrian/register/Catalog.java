package ws.otero.adrian.register;

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
}
