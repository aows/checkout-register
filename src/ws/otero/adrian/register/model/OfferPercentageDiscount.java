package ws.otero.adrian.register.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class OfferPercentageDiscount
   extends Offer
{

   private int percentage;

   public OfferPercentageDiscount (
      Item product,
      String description,
      int percentage )
   {
      super( product, description );
      this.percentage = percentage;
   }

   public double calculateDiscount ( Cart cart )
   {
      throw new NotImplementedException();
   }

}
