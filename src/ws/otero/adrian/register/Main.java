package ws.otero.adrian.register;

public class Main
{

   public static void main ( String[] args )
   {
      Catalog.getCatalog()
         .addItem( "000001", new Item( "Cereal", 3.5 ) )
         .addItem( "000002", new Item( "Meat", 10 ) );

      Cart cart = new Cart();
      cart.addItem( Catalog.searchItem( "000001" ) );
      cart.addItem( Catalog.searchItem( "000001" ) );
      cart.addItem( Catalog.searchItem( "000002" ) );

      System.out.println( "Total price: " + cart.calculatePrice() );
   }

}
