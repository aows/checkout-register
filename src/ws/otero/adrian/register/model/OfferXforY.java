package ws.otero.adrian.register.model;

public class OfferXforY
   extends Offer
{
   private int youPay;
   private int youGet;

   public OfferXforY (
      Item product,
      int youPay,
      int youGet )
   {
      super( product );
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
