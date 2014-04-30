package ws.otero.adrian.register.model;

/**
 * Example of one offer. With this offer the customer can get an amount of products paying only for some of them.
 * An example would be something like "Get 5 and pay 3".
 *
 * @author Adrian Otero
 */
public class OfferXforY
   extends Offer
{
   private int youPay;
   private int youGet;

   public OfferXforY (
      Item product,
      String description,
      int youPay,
      int youGet )
   {
      super( product, description );
      this.youPay = youPay;
      this.youGet = youGet;
   }

   public double calculateDiscount ( Cart cart )
   {
      int numOfProducts = 0;
      for( Item item : cart.getItems() )
      {
         if( item.getCode().equals( this.product.getCode() ) )
         {
            numOfProducts++;
         }
      }

      return ( numOfProducts / this.youGet ) * ( this.youGet - this.youPay ) * this.product.getPrice();
   }

}
