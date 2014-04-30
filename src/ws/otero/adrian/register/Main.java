package ws.otero.adrian.register;

public class Main
{

   public static void main ( String[] args )
   {
      // initialize catalog
      Catalog.initFromFile( "catalog.csv" );

      // create a new cart and add items to it
      Cart cart = new Cart();
      cart.addItem( Catalog.searchItem( "000001" ) );
      cart.addItem( Catalog.searchItem( "000001" ) );
      cart.addItem( Catalog.searchItem( "000002" ) );

      System.out.println( "Total price: " + cart.calculatePrice() );
   }

}
