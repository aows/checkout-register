package ws.otero.adrian.register.model;

public abstract class Offer
{
   protected Item product;

   public Offer ( Item product )
   {
      this.product = product;
   }

   abstract double calculateDiscount ( Cart cart );
}
