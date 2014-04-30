package ws.otero.adrian.register.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class OfferPercentageDiscount
   extends Offer
{

   private int percentage;

   public OfferPercentageDiscount (
      Item product,
      int percentage )
   {
      super( product );
      this.percentage = percentage;
   }

   public double calculateDiscount ( Cart cart )
   {
      throw new NotImplementedException();
   }

}
